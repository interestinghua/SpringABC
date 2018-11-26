package com.example.util;

import org.apache.commons.httpclient.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class ReturnObject extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public ReturnObject() {
        put("code", 0);
    }

    public static ReturnObject error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static ReturnObject error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static ReturnObject error(int code, String msg) {
        ReturnObject r = new ReturnObject();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static ReturnObject ok(String msg) {
        ReturnObject r = new ReturnObject();
        r.put("msg", msg);
        return r;
    }

    public static ReturnObject ok(Map<String, Object> map) {
        ReturnObject r = new ReturnObject();
        r.put("code",200);
        r.putAll(map);
        return r;
    }

    public static ReturnObject ok() {
        return new ReturnObject();
    }

    public ReturnObject put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public ReturnObject data(Object value) {
        super.put("data", value);
        return this;
    }

    public static ReturnObject apiError(String msg) {
        return error(1, msg);
    }
}
