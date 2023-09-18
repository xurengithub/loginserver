package com.xuren.loginserver.config.rpc;

import com.xuren.loginserver.config.RpcConfig;
import com.xuren.loginserver.rpc.GrpcServerManager;
import com.xuren.loginserver.rpc.impl.GS2GlobalService;
import com.xuren.rpc.IGS2GlobalService;
import io.grpc.BindableService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * @author xuren
 */
@AutoConfiguration
public class RpcConfiguration {
    @Bean(initMethod = "start", destroyMethod = "close")
    public GrpcServerManager init(RpcConfig rpcConfig, List<BindableService> services) {
        return new GrpcServerManager(rpcConfig.getPort(), services);
    }

    @Bean
    public BindableService gs2GlobalService() {
        return () -> GrpcServerManager.wrap(IGS2GlobalService.class, new GS2GlobalService());
    }
}
