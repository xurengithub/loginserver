package com.xuren.loginserver.exception;

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

    public ApiException(StatusCode statusCode, String message) {
        super(message);
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }

    public ApiException(String message) {
        super(message);
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
