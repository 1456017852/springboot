package com.naruto.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 一、springboot整合jdbc步骤
 * 1、pom
 *      <dependency>
 *          <groupId>org.springframework.boot</groupId>
 *          <artifactId>spring-boot-starter-jdbc</artifactId>
 *      </dependency>
 *      <dependency>
 *          <groupId>mysql</groupId>
 *          <artifactId>mysql-connector-java</artifactId>
 *          <scope>runtime</scope>
 *      </dependency>
 * 2、springboot.properties配置(---DataSourceProperties)
 *      spring.datasource.url=jdbc:mysql://127.0.0.1:3306/springboot?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8&useSSL=false
 *      spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
 *      spring.datasource.username=root
 *      spring.datasource.password=123456
 *
 * 3、在SpringbootApplicationTests中测试
 *
 * 4、由上我们可以发现，数据源的相关配置在DataSourceProperties类中进行
 *
 *
 * 二、springboot对数据源自动配置原理
 *
 * org.springframework.boot.autoconfigure.jdbc包
 *
 * DataSourceAutoConfiguration：数据源的自动配置类
 *
 * DataSourceConfiguration:数据源的配置类
 *
 *
 *
 *
 *
 */
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
