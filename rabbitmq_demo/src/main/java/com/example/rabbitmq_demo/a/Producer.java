package com.example.rabbitmq_demo.a;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 生产者
 * @author milicool
 * Created on 2018/9/14
 */
@Component
public class Producer {

   @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 给hello队列发送消息
     */
    public void send() {
        for (int i =0; i< 100; i++) {
            String msg = "hello, 序号: " + i;
            CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString()
                    .replace("-",""));


            System.out.println("Producer, " + msg+"消息id:"+correlationData.getId());
            rabbitTemplate.convertAndSend("queue-test", (Object) msg,correlationData);
        }
    }

}