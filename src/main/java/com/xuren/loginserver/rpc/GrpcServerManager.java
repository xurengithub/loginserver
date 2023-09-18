package com.xuren.loginserver.rpc;

import com.google.common.reflect.Invokable;
import com.xuren.loginserver.log.Log;
import io.grpc.BindableService;
import io.grpc.MethodDescriptor;
import io.grpc.Server;
import io.grpc.ServerServiceDefinition;
import io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.ServerCalls;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xuren
 */
public class GrpcServerManager {
    private Server server;
    public GrpcServerManager(int port, List<BindableService> services) {
        var builder = NettyServerBuilder.forPort(port);
        services.forEach(builder::addService);
        server = builder.build();

    }


    public void start(){
        try {
            server.start();
            server.awaitTermination();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        server.shutdown();
    }

    public static ServerServiceDefinition wrap(Object obj) {
        return wrap(obj.getClass(), obj);
    }

    public static ServerServiceDefinition wrap(Class<?> clazz, Object obj) {
        var builder = ServerServiceDefinition.builder(clazz.getName());
        for (var method : clazz.getDeclaredMethods()) {
            var invokable = Invokable.from(method);
            if (invokable.isPublic() && !invokable.isStatic() && !method.getDeclaringClass().equals(Object.class)) {
                MethodDescriptor<Object[], Object> methodDescriptor = methodDescriptor(clazz, method);
                ServerCalls.UnaryMethod<Object[], Object> unaryMethod = (request, responseObserver) -> {
                    try {
                        var resp = method.invoke(obj, request);
                        if (resp instanceof CompletionStage) {
                            ((CompletionStage<?>)resp).whenComplete((d, t) -> {
                                if (t != null) {
                                    responseObserver.onError(t);
                                } else {
                                    responseObserver.onNext(d);
                                    responseObserver.onCompleted();
                                }
                            });
                        } else {
                            responseObserver.onNext(resp);
                            responseObserver.onCompleted();
                        }
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        responseObserver.onError(e);
                        Log.system.error("grpc invoke error", e);
                    }
                };
                var serverCallHandler = ServerCalls.asyncUnaryCall(unaryMethod);
                builder.addMethod(methodDescriptor, serverCallHandler);
            }
        }
        return builder.build();
    }

    public static String methodSignName(Type[] types, Type type) {
        return Stream.of(types).map(Type::getTypeName).collect(Collectors.joining("_")) + "_" + type.getTypeName();
    }

    public static MethodDescriptor.Marshaller<Object> marshaller(Type type) {
        var delegate = new HessianMarshaller(type);
        return new MethodDescriptor.Marshaller<>() {
            @Override
            public InputStream stream(Object value) {
                return delegate.stream(value);
            }

            @Override
            public Object parse(InputStream stream) {
                if (Void.class.equals(type) || void.class.equals(type)) {
                    return null;
                }
                return delegate.parse(stream)[0];
            }
        };
    }

    public static MethodDescriptor<Object[], Object> methodDescriptor(Class<?> clazz, Method method) {
        var fullname = MethodDescriptor.generateFullMethodName(clazz.getName(), method.getName() + "_" + methodSignName(method.getParameterTypes(), method.getReturnType()));
        System.out.println("fullName:" + fullname);
        return MethodDescriptor.newBuilder(new HessianMarshaller(method.getParameterTypes()), marshaller(method.getReturnType())).setFullMethodName(fullname).setType(MethodDescriptor.MethodType.UNARY).build();
    }
}
