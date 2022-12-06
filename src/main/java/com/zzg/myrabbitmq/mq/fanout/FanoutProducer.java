package com.zzg.myrabbitmq.mq.fanout;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static com.zzg.myrabbitmq.constant.MqConstant.EXCHANGE_FANOUT;

/**
 * 广播生产者
 *
 * @author 张中贵
 */
@Component
public class FanoutProducer {
    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendFanout(String msg) {
        /**
         * @param 绑定路由与发送的信息，queue可以选项绑定或者不绑定
         */
        rabbitTemplate.convertAndSend(EXCHANGE_FANOUT, msg);
    }
}
