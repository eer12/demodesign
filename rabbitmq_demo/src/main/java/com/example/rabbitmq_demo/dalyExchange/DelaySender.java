package com.example.rabbitmq_demo.dalyExchange;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: wangxc
 * @GitHub: https://github.com/vector4wang
 * @CSDN: http://blog.csdn.net/qqhjqs?viewmode=contents
 * @BLOG: http://vector4wang.tk
 * @wxid: BMHJQS
 */
@Component
public class DelaySender {
	@Autowired
	private AmqpTemplate rabbitTemplate;


	/**
	 * 在消息上设置时间, 实现的原理是,将延迟队列的死信消息与 真正消费的交换机绑定,设置routekey为daly
	 * 然后再将交换机与真正消费队列绑定,设置routekey为daly.
	 *
	 * @param msg
	 */
	public void sendDelayMsg(Msg msg) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(msg.getId() + " 延迟消息发送时间:" + sdf.format(new Date()));
		rabbitTemplate.convertAndSend(MqConfig3.DELAY_EXCHANGE_NAME, "delay", msg, new MessagePostProcessor() {
			@Override
			public Message postProcessMessage(Message message) throws AmqpException {
				// 设置过期时间
				message.getMessageProperties().setExpiration(msg.getTtl() + "");
				return message;
			}
		});
	}

	/**
	 * 在队列上设置时间，则消息不需要任何处理,原理同上
	 * @param msg
	 */
	public void sendDelayQueue(Msg msg) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(msg.getId() + " 延迟队列消息发送时间:" + sdf.format(new Date()));
		rabbitTemplate.convertAndSend(MqConfig3.DELAY_QUEUE_EXCHANGE_NAME,"delay",  msg);
	}
}
