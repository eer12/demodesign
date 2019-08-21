package com.example.rabbitmq_demo.dalyExchange;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig3 {

    /**
     * 发送到该队列的message会在一段时间后过期进入到delay_process_queue
     * 每个message可以控制自己的失效时间
     */
    public final static String DELAY_QUEUE_MSG = "delay_queue";

    /**
     * DLX
     */
    public final static String DELAY_EXCHANGE_NAME = "delay_exchange";


    /**
     * 正常消费的队列
     */
    public final static String PROCESS_QUEUE = "process_queue";

    /**
     * 正常队列对应的exchange
     */
    public final static String PROCESS_EXCHANGE_NAME = "process_exchange";


    public static String ROUTING_KEY = "delay";

    /**
     * 延迟交换机 exchange
     * @return
     */
    @Bean
    public DirectExchange delayExchange() {
        return new DirectExchange(DELAY_EXCHANGE_NAME);
    }

    @Bean
    public DirectExchange processExchange() {
        return new DirectExchange(PROCESS_EXCHANGE_NAME);
    }

    /**
     * 存放延迟消息的队列 最后将会转发给exchange(实际消费队列对应的)
     * @return
     */
    @Bean
    Queue delayQueue4Msg(){
        return QueueBuilder.durable(DELAY_QUEUE_MSG)
                .withArgument("x-dead-letter-exchange", PROCESS_EXCHANGE_NAME) // DLX，dead letter发送到的exchange
                .withArgument("x-dead-letter-routing-key", ROUTING_KEY) // dead letter携带的routing key
                .build();
    }

    @Bean
    public Queue processQueue() {
        return QueueBuilder.durable(PROCESS_QUEUE)
                .build();
    }



    /**
     * 将延迟队列与exchange绑定，即到达指定时间之后需要转交给queue消费
     * @return
     */
    @Bean
    Binding delayBinding() {
        return BindingBuilder.bind(delayQueue4Msg())
                .to(delayExchange())
                .with(ROUTING_KEY);
    }

    @Bean
    Binding queueBinding() {
        return BindingBuilder.bind(processQueue())
                .to(processExchange())
                .with(ROUTING_KEY);
    }

    //////////////////////////////以上针对消息delay////////////////////////////////


    //////////////////////////////针对队列delay////////////////////////////////

    /**
     * 针对队列设置过期时间的队列
     */
    public final static String DELAY_QUEUE_NAME = "delay_queue_queue";

    public final static String DELAY_QUEUE_EXCHANGE_NAME = "delay_queue_exchange";

    @Bean
    public DirectExchange delayQueueExchange() {
        return new DirectExchange(DELAY_QUEUE_EXCHANGE_NAME);
    }

    /**
     * 存放消息的延迟队列 最后将会转发给exchange(实际消费队列对应的)
     * @return
     */
    @Bean
    public Queue delayQueue4Queue() {
        return QueueBuilder.durable(DELAY_QUEUE_NAME)
                .withArgument("x-dead-letter-exchange", PROCESS_EXCHANGE_NAME) // DLX
                .withArgument("x-dead-letter-routing-key", ROUTING_KEY) // dead letter携带的routing key
                .withArgument("x-message-ttl", 10000) // 设置队列的过期时间
                .build();
    }

    @Bean
    Binding delayQueueBind() {
        return BindingBuilder.bind(delayQueue4Queue())
                .to(delayQueueExchange())
                .with(ROUTING_KEY);
    }
}
