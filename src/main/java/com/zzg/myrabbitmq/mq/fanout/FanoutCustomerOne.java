package com.zzg.myrabbitmq.mq.fanout;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.zzg.myrabbitmq.constant.MqConstant.EXCHANGE_FANOUT;

/**
 * 第一个先放着
 *
 * @author 张中贵
 */
@Component
@Slf4j
public class FanoutCustomerOne {
    @RabbitListener(bindings = {@QueueBinding(value = @Queue, exchange = @Exchange(value = EXCHANGE_FANOUT , type = "fanout"))})
    public void customerOne(String msg) {
        log.info("第一个消费者{}", msg);
    }
}
