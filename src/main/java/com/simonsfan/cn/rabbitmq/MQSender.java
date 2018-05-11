package com.simonsfan.cn.rabbitmq;

;

/**
 * Created by fanrx on 2018/3/6.
 */
/*
@Component
public class MQSender {

    private static Logger log = LoggerFactory.getLogger(MQSender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(Object msg) {
        log.info("rabbitmq send:" + msg);
        amqpTemplate.convertAndSend("queue", msg);
    }

    public void sendTopic(Object msg) {
        log.info("send topic message:" + msg);
        amqpTemplate.convertAndSend(MQConfig.TOPIC_EXCHANGE, "topic.key1", msg + "1");
        amqpTemplate.convertAndSend(MQConfig.TOPIC_EXCHANGE, "topic.key2", msg + "2");
    }

    public void sendFanout(Object msg) {
        log.info("send fanout message:" + msg);
        amqpTemplate.convertAndSend(MQConfig.FANOUT_EXCHANGE, "", msg);
    }

    public void sendHeader(Object message) {
        String msg = String.valueOf(message);
        log.info("send headerqueue message:" + msg);
        MessageProperties properties = new MessageProperties();
        properties.setHeader("header1", "value1");
        properties.setHeader("header2", "value2");
        Message obj = new Message(msg.getBytes(), properties);
        amqpTemplate.convertAndSend(MQConfig.HEADERS_EXCHANGE, "", obj);
    }
}
*/
