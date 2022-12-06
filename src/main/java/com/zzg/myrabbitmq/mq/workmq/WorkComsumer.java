package com.zzg.myrabbitmq.mq.workmq;

import com.google.gson.Gson;
import com.zzg.myrabbitmq.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.zzg.myrabbitmq.constant.MqConstant.WORK_QUEUE;

/**
 * 一号消费者
 *
 * @author 张中贵
 */
@Component
@Slf4j
public class WorkComsumer {
    @RabbitListener(queuesToDeclare = @Queue(WORK_QUEUE))
    public void work(String msg) {
        Gson gson = new Gson();
        User user = gson.fromJson(msg, User.class);
        log.info("一号消费者{}", user);

    }


}
