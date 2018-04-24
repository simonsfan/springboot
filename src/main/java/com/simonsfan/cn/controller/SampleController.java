package com.simonsfan.cn.controller;

import com.simonsfan.cn.service.SampleService;
import com.simonsfan.cn.util.GetBeanInstanceUtil;
import com.simonsfan.cn.exception.GlobalException;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sample")
public class SampleController {

    private static final Logger log = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private SampleService sampleService;

    /**
     * 测试连接数据库
     * @return
     */
    @ResponseBody
    @RequestMapping("/connectdb")
    public List<String> sample(){
        return sampleService.getActivityIds();
    }

    /**
     * 通过BeanFactory获取service实例
     * @return
     */
    @ResponseBody
    @RequestMapping("/beanobtain")
    public List<String> beannObtain() {
        SampleService sampleService = (SampleService) GetBeanInstanceUtil.getBeanFactory().getBean("sampleService");
        List<String> activityIds = sampleService.getActivityIds();
        return activityIds;
    }

    /**
     * 测试Thymeleaf页面 + Cookie测试
     *
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model, HttpServletResponse response){
        model.addAttribute("name","simonsfan");
        Cookie cookie = new Cookie("token", RandomStringUtils.randomNumeric(16));
        cookie.setMaxAge(3600*2);
        cookie.setPath("/sample");
        response.addCookie(cookie);
        return "/index";
    }

   @ResponseBody
    @RequestMapping("/getcookie")
    public String index(HttpServletRequest request){
        String value = "";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")){
                value=cookie.getValue();
            };
        }
        return value;
    }

    @ExceptionHandler(GlobalException.class)
    @RequestMapping("/test1")
    public String test1() {
        log.info("this is method test1");
       List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i+5));
        }
        return "index";
    }
}
