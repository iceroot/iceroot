package com.icexxx.util;

import java.io.Serializable;

/**
 * 返回值封装
 * 
 * @author IceWater
 * @version 2.0.3
 */
public class IceData<T> implements Serializable {
    private static final long serialVersionUID = -7982442405806120824L;
    private int code;
    private String msg;
    private T data;

    public IceData() {

    }

    public IceData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public IceData(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "IceData [code=" + code + ", msg=" + msg + ", data=" + data + "]";
    }
}
