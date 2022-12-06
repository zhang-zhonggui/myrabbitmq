package com.zzg.myrabbitmq.mq.hellowoldmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.zzg.myrabbitmq.constant.MqConstant.HelloWoldQueue;

/**
 * 二号消费者
 *
 * @author 张中贵
 */
@Component
@Slf4j
public class ComsumerTwo {
    //消费者消费的queue的名称
    @RabbitListener(queuesToDeclare = @Queue(HelloWoldQueue))
    public void comsumer(String msg) {
        log.info("二号消费者消费{}", msg);
        System.out.println("二号消费者消费");
    }

}
