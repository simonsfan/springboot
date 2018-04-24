package com.simonsfan.cn.exception;

/**
 * Created by fanrx on 2018/4/24.
 */
public class GlobalException extends Exception {

    private static final long serialVersionUID = 6919252522159514857L;

    private String msg;

    public GlobalException(String msg){
        super(msg);
    }

    public String getMsg() {
        return msg;
    }
}
