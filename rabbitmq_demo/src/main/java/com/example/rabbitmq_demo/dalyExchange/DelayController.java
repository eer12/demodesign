package com.example.rabbitmq_demo.dalyExchange;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * http://blog.battcn.com/2018/05/23/springboot/v2-queue-rabbitmq-delay/
 */

@RestController
@RequestMapping("/delay")
public class DelayController {

	@Autowired
	private DelaySender delaySender;


	//@ApiOperation("延时队列发送(发送消息的时候设置过期时间)")
	@RequestMapping(value = "/sendDelay", method = RequestMethod.POST)
	public String sendDelayMsg(@RequestBody Msg msg) {

		delaySender.sendDelayMsg(msg);

		return "success";

	}

	//@ApiOperation("延时队列发送(整个队列设置过期时间，与msg没有关系)")
	@RequestMapping(value = "/sendQueueDelay", method = RequestMethod.GET)
	public String sendDelayQueueMsg() {


		Msg msg1 = new Msg();
		msg1.setContent("这是消息");
		msg1.setId(1);
		delaySender.sendDelayQueue(msg1);

		return "success";

	}

}
