package com.example.rabbitmq_demo.fanoutExChange;


import com.example.rabbitmq_demo.fanoutExChange.FanoutSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangxc
 * @GitHub: https://github.com/vector4wang
 * @CSDN: http://blog.csdn.net/qqhjqs?viewmode=contents
 * @BLOG: http://vector4wang.tk
 * @wxid: BMHJQS
 */
@RestController
@RequestMapping("/rabbit6")
public class FanoutController {

    @Autowired
    private FanoutSender fanoutSender;

    @RequestMapping(value = "/fanout",method = RequestMethod.GET)
    public void fanoutTest() {
        fanoutSender.send();
    }
}
