package com.xuren.loginserver.exception;

/**
 * @author xuren
 */
public enum StatusCodeEnum {
    API_ERROR(500, "服务器开小差"),

    EXISTS_ACCOUNT(10001, "账号已存在"),
    SECTION_NOT_EXISTS(10002, "区服不存在"),
    ;
    private int code;
    private String msg;

    StatusCodeEnum(int code, String msg) {
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
