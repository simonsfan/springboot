package com.simonsfan.cn.rabbitmq;

/**
 * Created by fanrx on 2018/3/6.
 */
/*@Component
public class MQReceiver {

    private static Logger log = LoggerFactory.getLogger(MQReceiver.class);

    @RabbitListener(queues = "queue")
    public void receive(String msg) {
        log.info("rabbitmq receive:" + msg);
    }

    @RabbitListener(queues = MQConfig.TOPIC_QUEUE1)
    public void receiveTopic1(String message) {
        log.info(" topic  queue1 message:" + message);
    }

    @RabbitListener(queues = MQConfig.TOPIC_QUEUE2)
    public void receiveTopic2(String message) {
        log.info(" topic  queue2 message:" + message);
    }

    @RabbitListener(queues = MQConfig.HEADER_QUEUE)
    public void receiveHeaderQueue(byte[] message) {
        log.info(" header  queue message:" + new String(message));
    }

}*/
