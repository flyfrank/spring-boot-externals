package com.mpoom.webserver;


import com.mpoom.common.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.Serializable;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisTest {
    @Autowired
    private RedisTemplate<String, String> stringRedisTemplate;

    @Resource
    private RedisTemplate<String, Serializable> serializableRedisTemplate;

    @Test
    public void testString() {
        stringRedisTemplate.opsForValue().set("username:zhangsan", "zhangsan");
        System.out.println(stringRedisTemplate.opsForValue().get("username:zhangsan"));
    }

    @Test
    public void testSerializable() {
        User user=new User();
        user.setId(1);
        user.setUsername("张三");
        user.setAge(20);
        user.setEmail("za@qq.com");
        user.setState(1);
        serializableRedisTemplate.opsForValue().set("user", user);
        User userDB = (User) serializableRedisTemplate.opsForValue().get("user");
        System.out.println(user.toString());
    }

}
