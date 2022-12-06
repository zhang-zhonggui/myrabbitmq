package com.zzg.myrabbitmq.mq.hellowoldmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.zzg.myrabbitmq.constant.MqConstant.HelloWoldQueue;

/**
 * @author 张中贵
 */
@Component
@Slf4j
public class Comsumer {
    @RabbitListener(queuesToDeclare = @Queue(HelloWoldQueue))
    public void getCommons(String msg) {
        log.info("消费的消息是{}", msg);
        System.out.println(msg);
    }
}
