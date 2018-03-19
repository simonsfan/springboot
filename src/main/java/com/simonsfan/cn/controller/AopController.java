package com.simonsfan.cn.controller;

import com.simonsfan.cn.aspect.AccessLimit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fanrx on 2018/3/11.
 */
@Controller
@RequestMapping("/aop")
public class AopController {

    @AccessLimit(limit = 4,seconds = 10)
    @ResponseBody
    @RequestMapping("/intercept")
    public String intercept(){
        return "hello world!";
    }

}
