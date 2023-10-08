package com.xuren.loginserver.config;

import com.xuren.loginserver.dto.Response;
import com.xuren.loginserver.exception.ApiException;
import com.xuren.loginserver.log.Log;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author xuren
 */
@RestControllerAdvice(basePackages = "com.xuren.loginserver.controller")
public class ControllerExceptionAdvice {
    @ExceptionHandler({BindException.class})
    public Response<Void> methodArgumentNotValidExceptionHandler(BindException bindException) {
        ObjectError objectError = bindException.getBindingResult().getAllErrors().get(0);
        return Response.error(objectError.getDefaultMessage());
    }

    @ExceptionHandler({ApiException.class})
    public Response<Void> apiError(ApiException apiException) {
        Log.system.error("api error {}", apiException.getMessage());
        return Response.error(apiException.getCode(), apiException.getMsg());
    }
}
