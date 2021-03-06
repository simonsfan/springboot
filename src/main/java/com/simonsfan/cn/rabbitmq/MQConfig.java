package com.simonsfan.cn.rabbitmq;

/**
 * Created by fanrx on 2018/3/6.
 */
/*@Configuration
public class MQConfig {

    public static final String  QUEUE = "queue";
    public static final String  TOPIC_QUEUE1 = "topic.queue1";
    public static final String  TOPIC_QUEUE2 = "topic.queue2";
    public static final String  TOPIC_EXCHANGE = "topicexchange";
    public static final String  FANOUT_EXCHANGE = "fanoutexchange";
    public static final String HEADERS_EXCHANGE = "headersExchage";
    public static final String HEADER_QUEUE = "header.queue";

    *//**
     * Direct模式 交换机Exchange
     *//*
    @Bean
    public Queue directQueue() {
        return new Queue(QUEUE, true);
    }

    *//**
     * Topic模式 交换机Exchange
     *//*
    @Bean
    public Queue topicQueue1(){
        return new Queue(TOPIC_QUEUE1,true);
    }
    @Bean
    public Queue topicQueue2(){
        return new Queue(TOPIC_QUEUE2,true);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Binding topicBinding1(){
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("topic.key1");
    }

    @Bean
    public Binding topicBinding2(){
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("topic.#");   //支持通配符，可发送给多个queue
    }
    *//**
     * Fanout模式 交换机Exchange
     *//*
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Binding fanoutBinding1(){
        return BindingBuilder.bind(topicQueue1()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutBinding2(){
        return BindingBuilder.bind(topicQueue2()).to(fanoutExchange());
    }

    *//**
     * Header模式 交换机Exchange
     * *//*
    @Bean
    public HeadersExchange headersExchage(){
        return new HeadersExchange(HEADERS_EXCHANGE);
    }
    @Bean
    public Queue headerQueue1() {
        return new Queue(HEADER_QUEUE, true);
    }
    @Bean
    public Binding headerBinding() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("header1", "value1");
        map.put("header2", "value2");
        return BindingBuilder.bind(headerQueue1()).to(headersExchage()).whereAll(map).match();
    }

}*/
