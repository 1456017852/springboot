package com.naruto.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *一、 springboot对错误页面的自动配置 --[ErrorMvcAutoConfiguration、ErrorProperties]
 *
 * 1、springboot对错误页面的自动配置，ErrorMvcAutoConfiguration给容重添加以下组件
 *
 * ErrorPageCustomizer：系统发生错误的页面请求就会调用它
 *
 * BasicErrorController：处理默认的/error请求
 *
 * DefaultErrorViewResolver：进行视图的映射处理
 *
 * DefaultErrorAttributes：配置错误页面所带的信息
 */
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
