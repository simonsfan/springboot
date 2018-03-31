package com.simonsfan.cn.controller;

import com.simonsfan.cn.service.SampleService;
import com.simonsfan.cn.util.GetBeanInstanceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @ResponseBody
    @RequestMapping("/beanobtain")
    public List<String> beannObtain() {
        SampleService sampleService = (SampleService) GetBeanInstanceUtil.getBeanFactory().getBean("sampleService");
        List<String> activityIds = sampleService.getActivityIds();
        return activityIds;
    }

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("name","simonsfan");
        return "/index";
    }

}
