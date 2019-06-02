package com.naruto.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 一、springboot的嵌入式servlet容器
 *
 * 1、springboot支持内嵌servlet容器的自动配置的原理
 *
 * springboot为我们默认配置了Tomcat的servlet容器
 * springboot同时还支持：jetty、netty(适合长连接场景)、undertow(适合高并发场景)等servlet容器
 *
 * EmbeddedWebServerFactoryCustomizerAutoConfiguration：嵌入式Servlet容器自动配置类
 * ServerProperties :嵌入式Servlet容器自动配置时，导入组件所需要的属性配置文件
 *
 * 2、如何定制和修改默认的servlet容器的相关配置
 *      修改springboot核心配置中的server相关的配置
 *
 *      //通用的servlet容器的配置
 *      server.port=8081
 *      server.servlet.context-path=/springboot
 *      //tomcat的相关配置
 *      server.tomcat.accesslog.buffered=true
 *      server.tomcat.accept-count=100
 *
 * 3、springboot切换为另外的内嵌servlet容器
 * (1)pom中排除掉 spring-boot-starter-tomcat
 *      <dependency>
 *          <groupId>org.springframework.boot</groupId>
 *          <artifactId>spring-boot-starter-web</artifactId>
 *          <!--排除默认的servlet容器的依赖(tomcat)-->
 *          <exclusions>
 *              <exclusion>
 *                  <artifactId>spring-boot-starter-tomcat</artifactId>
 *                  <groupId>org.springframework.boot</groupId>
 *              </exclusion>
 *          </exclusions>
 *      </dependency>
 * (2) pom中引入其他的servlet容器 例如jetty
 *      <!--引入其他的servlet容器的依赖-->
 *      <dependency>
 *          <groupId>spring-boot-starter-jetty</groupId>
 *          <artifactId>org.springframework.boot</artifactId>
 *      </dependency>
 *
 *
 */
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
