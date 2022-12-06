package com.zzg.myrabbitmq.controller;

import com.zzg.myrabbitmq.mq.fanout.FanoutProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.util.resources.LocaleData;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

@RequestMapping("fanout")
@RestController
public class FanoutController {
    @Resource
    public FanoutProducer fanoutProducer;

    @GetMapping
    public String setProducer() {
        for (int i = 0; i < 1000; i++) {
            fanoutProducer.sendFanout(UUID.randomUUID().toString() + i);
        }
        return LocalDateTime.now().toString();
    }
}
