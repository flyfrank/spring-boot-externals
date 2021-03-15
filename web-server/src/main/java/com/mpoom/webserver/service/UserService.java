package com.mpoom.webserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Service
public class UserService {

    @Autowired
    private RedisTemplate<String, Serializable> serializableRedisTemplate;



    @Transactional
    public void updateUser() {

    }
}
