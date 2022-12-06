package com.zzg.myrabbitmq.mq.workmq;


import com.sun.corba.se.spi.orbutil.threadpool.WorkQueue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static com.zzg.myrabbitmq.constant.MqConstant.WORK_QUEUE;

/**
 * 生产者
 *
 * @author 张中贵
 */
@Component
public class WorkProducer {
    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendWorkSms(String msg) {
        rabbitTemplate.convertAndSend(WORK_QUEUE, msg);
    }
}
