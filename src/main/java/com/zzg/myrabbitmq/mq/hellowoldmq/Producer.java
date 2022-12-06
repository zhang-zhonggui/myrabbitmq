package com.zzg.myrabbitmq.mq.hellowoldmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static com.zzg.myrabbitmq.constant.MqConstant.HelloWoldQueue;

/**
 * @author 张中贵
 */
@Component
public class Producer {
    @Resource
    RabbitTemplate rabbitTemplate;

    public void setRabbitTemplate(String msg) {
        //生产者绑定指定的queue，与生产的消息
        rabbitTemplate.convertAndSend(HelloWoldQueue, msg);
    }

}
