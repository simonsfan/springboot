package com.simonsfan.cn.controller;
/*

import com.simonsfan.cn.rabbitmq.MQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class RabbitMqController {

    @Autowired
    private MQSender sender;

    @RequestMapping("/direct")
    @ResponseBody
    public String mq() {
        sender.send("hello world");
        return "hello world";
    }

    @RequestMapping("/topicQueue")
    @ResponseBody
    public String topicQueue() {
        sender.sendTopic("hello world");
        return "hello world";
    }

    @RequestMapping("/fanoutQueue")
    @ResponseBody
    public String fanoutQueue() {
        sender.sendFanout("hello world");
        return "hello world";
    }

    @RequestMapping("/headerQueue")
    @ResponseBody
    public String headerQueue() {
        sender.sendHeader("hello world");
        return "hello world";
    }


}
*/
