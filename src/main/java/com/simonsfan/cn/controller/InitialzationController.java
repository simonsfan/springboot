package com.simonsfan.cn.controller;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 系统初始化加载数据，例如初始化数据到redis中
 * </p>
 * Created by fanrx on 2018/3/11.
 */
@Controller
@RequestMapping("/init")
public class InitialzationController implements InitializingBean {

    public void afterPropertiesSet() {
        System.out.println("this is the initial content……");
        //TODO
    }


}
