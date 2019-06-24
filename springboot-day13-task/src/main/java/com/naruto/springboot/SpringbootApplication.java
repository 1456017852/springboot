package com.naruto.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 1、sprinboot的异步任务
 *
 *  @EnableAysnc、@Aysnc
 *
 *  在Java应用中，绝大多数情况下都是通过同步的方式来实现交互处理的；
 *  但是在处理与第三方系统交互的时候，容易造成响应迟缓的情况，之前大部分都是使用多线程来完成此类任务，
 *  其实，在Spring 3.x之后，就已经内置了@Async来完美解决这个问题。
 *
 * 2、定时任务
 *
 * @EnableScheduling、@Scheduled
 *
 *  项目开发中经常需要执行一些定时任务，比如需要在每天凌晨时候，分析一次前一天的日志信息。
 *   Spring为我们提供了异步执行任务调度的方式，提供TaskExecutor、TaskScheduler接口。
 *
 * 3、邮件任务
 *
 * 邮件发送需要引入spring-boot-starter-mail
 * Spring Boot 自动配置MailSenderAutoConfiguration
 * 定义MailProperties内容，配置在application.yml中
 * 自动装配JavaMailSender
 * 测试邮件发送
 */
@EnableScheduling//开启基于注解的定时任务
@EnableAsync//开启异步注解功能
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
