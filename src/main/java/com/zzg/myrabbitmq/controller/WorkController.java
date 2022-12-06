package com.zzg.myrabbitmq.controller;

import com.google.gson.Gson;
import com.zzg.myrabbitmq.domain.User;
import com.zzg.myrabbitmq.mq.workmq.WorkProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author 张中贵
 */
@RequestMapping("work")
@RestController
public class WorkController {
    @Resource
    private WorkProducer workProducer;

    @GetMapping
    public String getWork() {
        Gson gson = new Gson();
        User user = new User();
        for (int i = 0; i < 100; i++) {
            user.setId(i);
            user.setName(UUID.randomUUID().toString() + "i");
            workProducer.sendWorkSms(gson.toJson(user));
        }
        return gson.toJson(LocalDateTime.now());
    }

}
