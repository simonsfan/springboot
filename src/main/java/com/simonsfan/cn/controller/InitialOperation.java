package com.simonsfan.cn.controller;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 系统初始化加载数据，例如初始化 热数据到redis中
 * </p>
 * Created by fanrx on 2018/3/11.
 */
@Component
public class InitialOperation implements InitializingBean {

    public void afterPropertiesSet() {
        System.out.println("this is the initial operation……");
        //TODO something else……
    }


}
