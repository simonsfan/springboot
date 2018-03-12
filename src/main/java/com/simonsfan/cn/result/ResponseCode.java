package com.simonsfan.cn.result;

/**
 * 项目名称：springboot
 * 类名称：com.simonsfan.cn.result
 * 类描述：
 * 创建人：simonsfan
 * 创建时间：2018/3/9 16:25
 */
public enum ResponseCode {

    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");

    private final int code;
    private final String desc;


    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

}
