package com.naruto.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 一、springboot对静态资源的映射规则
 * springboot中springmvc的自动配置都在WebMvcAutoConfiguration配置类中
 * 静态资源的参数都在ResourceProperties中进行配置
 *
 * 1、所有/webjars/**的静态资源请求,都去classpath:/META-INF/resources/webjars/路径下去查资源
 *  (1)、WebJars介绍
 *      Web前端使用了越来越多的JS或CSS，如jQuery，Backbone.js和Bootstrap。
 *      一般情况下，我们是将这些Web资源拷贝到Java Web项目的webapp相应目录下进行管理。
 *      这种通过人工方式管理可能会产生版本误差，拷贝版本错误，漏拷等现象，
 *      导致前端页面无法正确展示，版本不一致，文件混乱等，导致出现一些莫名其妙的错误等。
 *      WebJars是将web前端资源（js，css等）打成jar包文件，然后借助Maven工具，
 *      以jar包形式对web前端资源进行统一依赖管理，保证这些Web资源版本唯一性。
 *      WebJars的jar包部署在Maven中央仓库上
 *  (2)、WebJars使用(pom.xml中引入)
 *
 *      <!--引入jquery的webjars-->
 *      <dependency>
 *          <groupId>org.webjars</groupId>
 *          <artifactId>jquery</artifactId>
 *          <version>3.3.1</version>
 *      </dependency>
 *      <!--引入bootstarp的webjars-->
 *      <dependency>
 *          <groupId>org.webjars</groupId>
 *          <artifactId>bootstrap</artifactId>
 *          <version>3.3.6</version>
 *      </dependency>
 *
 *  2、所有/**的静态资源请求会去，以下几个路径下进行映射(即静态资源的文件夹)
 *      (1)、classpath:/META-INF/resources/
 *      (2)、classpath:/resources/
 *      (3)、classpath:/static/
 *      (4)、classpath:/public/
 *      (5)、/项目根路径
 *
 *  3、静态资源下的所有index.html页面；被/**映射欢迎页
 *
 *  4、图标【** /favicon.ico】请求，都会在静态资源文件夹下映射
 *
 */
@SpringBootApplication
public class StaticSourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(StaticSourceApplication.class, args);
    }
}
