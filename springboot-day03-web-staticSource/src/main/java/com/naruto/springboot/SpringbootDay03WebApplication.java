package com.naruto.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Springboot-web
 *
 * springboot中springmvc的自动配置都在WebMvcAutoConfiguration配置类中
 *
 *  一、springboot对静态资源的映射
 *
 *
 *  1、WebMvcAutoConfiguration配置类的addResourceHandlers()方法可以知道
 *  所有/webjars/**的静态资源请求,都去classpath:/META-INF/resources/webjars/
 *
 *      <1>.WebJars介绍
 *          官网：https://www.webjars.org/
 *          Web前端使用了越来越多的JS或CSS，如jQuery，Backbone.js和Bootstrap。
 *          一般情况下， 我们是将这些Web资源拷贝到Java Web项目的webapp相应目录下进行管理。
 *          这种通过人工方式管理可能会产生版本误差，拷贝版本错误，漏拷等现象，
 *          导致前端页面无法正确展示，版本不一致，文件混乱等，导致出现一些莫名其妙的错误等。
 *          WebJars是将web前端资源（js，css等）打成jar包文件，然后借助Maven工具，
 *          以jar包形式对web前端资源进行统一依赖管理，保证这些Web资源版本唯一性。
 *          WebJars的jar包部署在Maven中央仓库上
 *      <2>.pom引入依赖
 *           <!--jquery的webjar-->
 *         <dependency>
 *             <groupId>org.webjars</groupId>
 *             <artifactId>jquery</artifactId>
 *             <version>3.4.1</version>
 *         </dependency>
 *
 *         <!--bootstarp的webjar-->
 *         <dependency>
 *             <groupId>org.webjars</groupId>
 *             <artifactId>bootstrap</artifactId>
 *             <version>4.3.1</version>
 *         </dependency>
 *
 *   2、ResourceProperties的CLASSPATH_RESOURCE_LOCATIONS =
 *      new String[]{"classpath:/META-INF/resources/","classpath:/resources/","classpath:/static/","classpath:/public/"}
 *      即：
 *      所有/**的静态资源请求会去，以下几个路径下进行映射(即静态资源的文件夹)
 *
 *
 *      (1)、classpath:/META-INF/resources/
 *      (2)、classpath:/resources/
 *      (3)、classpath:/static/
 *      (4)、classpath:/public/
 *      (5)、/项目根路径
 *
 *
 *   3、WebMvcAutoConfiguration注册的WelcomePageHandlerMapping
 *      可知springboot 的/**  请求，都会去找静态资源下的所有index.html页面(欢迎页)
 *
 *   4、图标favicon.ico请求，都会在静态资源文件夹下映射
 *
 */
@SpringBootApplication
public class SpringbootDay03WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDay03WebApplication.class, args);
    }

}
