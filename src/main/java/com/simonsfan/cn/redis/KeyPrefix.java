package com.simonsfan.cn.redis;

public interface KeyPrefix {

    int expireSeconds();

    String getPrefix();

}
