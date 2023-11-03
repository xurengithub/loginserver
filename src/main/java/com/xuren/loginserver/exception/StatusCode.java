package com.xuren.loginserver.exception;

/**
 * @author xuren
 */
public enum StatusCode {
    API_ERROR(500, "服务器开小差"),

    EXISTS_ACCOUNT(10001, "账号已存在"),
    ;
    private int code;
    private String msg;

    StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
