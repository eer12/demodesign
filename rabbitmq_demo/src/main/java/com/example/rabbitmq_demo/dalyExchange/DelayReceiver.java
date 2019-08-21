package com.example.rabbitmq_demo.dalyExchange;


import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DelayReceiver {

	@RabbitListener(queues = {MqConfig3.PROCESS_QUEUE})
	public void process(Msg msg , Channel channel) throws IOException {
		channel.basicAck(msg.getTtl(), true);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("当前时间: " + sdf.format(new Date()) + " ---> msg：【" + msg + "]");
	}
}
