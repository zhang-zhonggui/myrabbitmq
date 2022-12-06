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
public class FanoutCustomerTwo {
    /**
     * 配置路由 与queue 进行消费，如果queue没有绑定会自动创建一个queue
     *
     * @param msg
     */
    @RabbitListener(bindings = {@QueueBinding(value = @Queue("zzg"), exchange = @Exchange(value = EXCHANGE_FANOUT, type = "fanout"))})
    public void customerOne(String msg) {
        log.info("第二个消费者{}", msg);
    }
}
