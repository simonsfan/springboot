package com.simonsfan.cn.controller;

import com.simonsfan.cn.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sample")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @ResponseBody
    @RequestMapping("/connectdb")
    public List<String> sample(){
        return sampleService.getActivityIds();
    }


}
