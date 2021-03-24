package com.mpoom.webserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class RedisService {

    @Autowired
    private RedisTemplate<String, String> stringRedisTemplate;


    public void writeRedis() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS");
        while(true) {
            try {
                String time = ZonedDateTime.now().format(formatter);
                stringRedisTemplate.opsForValue().set("master-failover", time);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
