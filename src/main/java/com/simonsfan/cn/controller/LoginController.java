package com.simonsfan.cn.controller;

import com.simonsfan.cn.result.CodeMsg;
import com.simonsfan.cn.result.Result;
import com.simonsfan.cn.service.HuyiMessageService;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fanrx on 2018/5/18.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    private static  final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private HuyiMessageService huyiMessageService;

    @ResponseBody
    @RequestMapping(value = "/sendMessageTest",method = RequestMethod.GET)
    public  Result  sendMessageTest(@RequestParam(value="mobile") String mobile){
        log.info("sendMessageTest method mobile="+mobile);
        if(StringUtils.isEmpty(mobile)){
            Result back = Result.error(CodeMsg.BIND_ERROR);
            return back;
        }
        String code = RandomStringUtils.randomNumeric(4);
        String content = "您的验证码是："+code+"。请不要把验证码泄露给其他人。";
        String result = huyiMessageService.sendMessage(mobile, content);
        Result<String> back = Result.success(result);
        return back;
    }

}
