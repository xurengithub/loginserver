package com.xuren.loginserver.dto;

import lombok.Data;

/**
 * @author xuren
 */
@Data
public class Response<T> {
    private int code;
    private String msg;
    private T data;

    public static <K> Response<K> ok() {
        Response<K> response = new Response<>();
        response.code = 200;
        response.msg = "SUCCESS";
        return response;
    }

    public static <K> Response<K> ok(K data) {
        Response<K> response = new Response<>();
        response.code = 200;
        response.data = data;
        response.msg = "SUCCESS";
        return response;
    }

//    public static Response<Void> error(String msg) {
//        Response<Void> response = new Response<>();
//        response.code = 500;
//        response.msg = msg;
//        return response;
//    }

    public static <K> Response<K> error(String msg) {
        Response<K> response = new Response<>();
        response.code = 500;
        response.msg = msg;
        return response;
    }

    public static <K> Response<K> error(int code, String msg) {
        Response<K> response = new Response<>();
        response.code = code;
        response.msg = msg;
        return response;
    }

//    public static Response<Void> error(int code, String msg) {
//        Response<Void> response = new Response<>();
//        response.code = code;
//        response.msg = msg;
//        return response;
//    }
}
