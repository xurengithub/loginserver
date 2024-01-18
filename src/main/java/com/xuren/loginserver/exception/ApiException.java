package com.xuren.loginserver.exception;

import org.slf4j.helpers.MessageFormatter;

/**
 * @author xuren
 */
public class ApiException extends RuntimeException{
    private final int code;
    private final String msg;

    public ApiException(StatusCodeEnum statusCodeEnum) {
        super(statusCodeEnum.getMsg());
        this.code = statusCodeEnum.getCode();
        this.msg = statusCodeEnum.getMsg();
    }

    public ApiException(StatusCodeEnum statusCodeEnum, String message, Object... args) {
        super(MessageFormatter.arrayFormat(message, args).getMessage());
        this.code = statusCodeEnum.getCode();
        this.msg = statusCodeEnum.getMsg();
    }

    public ApiException(String message, Object... args) {
        super(MessageFormatter.arrayFormat(message, args).getMessage());
        this.code = StatusCodeEnum.API_ERROR.getCode();
        this.msg = StatusCodeEnum.API_ERROR.getMsg();
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
