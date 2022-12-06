package com.zzg.myrabbitmq.controller;

import com.zzg.myrabbitmq.mq.hellowoldmq.Producer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 张中贵
 */
@RestController
@RequestMapping("test")
public class HelloWordRabbitMqController {
    @Resource
    public Producer producer;

    @GetMapping
    public void sendMsg() {
        String message = "HelloWordRabbitMq";
        for (int i = 0; i < 10000; i++) {
            producer.setRabbitTemplate(message + i);
        }
    }
}
