package com.naruto.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot项目的入口,启动springboot了程序，启动内嵌的tomcat
 * @SpringBootApplication 是springboot的核心注解，主要作用是开启spring的自动配置
 */
@SpringBootApplication//@SpringbootApplication 注解能开启自动配置
public class SpringbootHelloworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHelloworldApplication.class, args);
    }

}
