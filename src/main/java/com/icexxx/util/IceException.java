package com.icexxx.util;

import java.io.Serializable;

/**
 * 异常工具类
 * 
 * @author IceWater
 * @version 2.0.3
 */
public class IceException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -2465451842985316398L;
    private int code;
    private String message;

    public IceException() {

    }

    public IceException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{\"code\" = " + code + ", \"message\" = \"" + message + "\"}";
    }
}
