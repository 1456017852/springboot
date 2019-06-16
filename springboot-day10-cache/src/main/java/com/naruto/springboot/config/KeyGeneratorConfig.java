package com.naruto.springboot.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 自定义Key生成器
 */
@Configuration
public class KeyGeneratorConfig {

    @Bean("keyGenerator")
    public KeyGenerator keyGenerator(){
        return new KeyGenerator(){

            @Override
            public Object generate(Object o, Method method, Object... params) {
                return method.getName()+"["+ Arrays.asList(params)+"]";
            }
        };
    }
}
