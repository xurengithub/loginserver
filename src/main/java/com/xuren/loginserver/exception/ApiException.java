package com.xuren.loginserver.exception;

import org.slf4j.helpers.MessageFormatter;

/**
 * @author xuren
 */
public class ApiException extends RuntimeException{
    private final int code;
    private final String msg;

    public ApiException(StatusCode statusCode) {
        super(statusCode.getMsg());
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }

    public ApiException(StatusCode statusCode, String message, Object... args) {
        super(MessageFormatter.arrayFormat(message, args).getMessage());
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }

    public ApiException(String message, Object... args) {
        super(MessageFormatter.arrayFormat(message, args).getMessage());
        this.code = StatusCode.API_ERROR.getCode();
        this.msg = StatusCode.API_ERROR.getMsg();
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
