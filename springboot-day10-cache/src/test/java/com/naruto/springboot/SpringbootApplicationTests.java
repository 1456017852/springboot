package com.naruto.springboot;

import com.naruto.springboot.service.EmployService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private EmployService employService;

    @Test
    public void contextLoads() {


//        redisTemplate.opsForValue();
//        redisTemplate.opsForList();
//        redisTemplate.opsForSet();
//        redisTemplate.opsForZSet();
//        redisTemplate.opsForHash();

        /**
         * StringRedisTemplate 主要对字符串进行操作，
         */

        //stringRedisTemplate.opsForValue().set("1","123");
        /**
         *
         * RedisTemplate:主要对Object进行操作
         *
         * 如果保存对象，对象必须实现序列化，
         * RedisTemplate的序列化机制，默认为JdkSerializationRedisSerializer，序列化后的数据保存到redis中，不是我们习惯的格式
         * 我们可以编写Redis的配置类RedisConfig设置RedisTemplate的序列化机制
         *
         *
         */
        //redisTemplate.opsForValue().set("employee",employService.getEmployeeById(1));
        redisTemplate.opsForValue().set("employee1",employService.getEmployeeById(1));
    }

}
