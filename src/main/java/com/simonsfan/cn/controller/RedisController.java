package com.simonsfan.cn.controller;

import com.simonsfan.cn.redis.RedisService;
import com.simonsfan.cn.redis.SampleKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fanrx on 2018/3/10.
 */
@Controller
@RequestMapping("/redis")
public class RedisController {

    private static final Logger log = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private RedisService redisService;

    @ResponseBody
    @RequestMapping("/set")
    public String setValue(){
        redisService.set(SampleKey.SAMPLEKEY,"key1","redis_test_value1");
        return "redis set value successful";
    }

    @ResponseBody
    @RequestMapping("/get")
    public String getetValue(){
        String value = redisService.get(SampleKey.SAMPLEKEY,"key1",String.class);
        return value;
    }



}
