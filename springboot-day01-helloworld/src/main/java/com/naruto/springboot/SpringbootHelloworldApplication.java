package com.naruto.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 一、springboot简介
 * 1、简介
 * （1）、springboot是spring家族中的一个全新的框架，它用来简化spring应用程序的创建和开发，也就是说springboot能简化我们之前用的ssm框架进行开发的过程
 * （2）、在我们以往采用ssm框架开发的时候，塔尖和整合三大框架我们要做许多的工作，比如配置web.xml，配置mybatis,配置spring，并将它们整合到一起，而Springboot框架对此工程进行了革命性的颠覆，springboot抛弃了繁琐的xml配置过程，采用大量的默认配置简化我们的开发！
 * （3）、springboot可以快速的创建基于spring框架的应用程序，它让编码变简单，配置变简单，部署变简单，监控变简单！
 * 2、特性
 * （1）、能够快速的创建基于spring的应用程序，
 * （2）、能够直接Java main方法启动内嵌的servlet容器，运行springboot程序，不需要部署war包
 * （3）、起步依赖-提供约定的starter POM 来简化Maven配置，让Maven的配置变得更简单！
 * （4）、自动配置-根据项目得起步以来，springboot自动配置spring，springmvc，mybatis等
 * （5）、健康检查-提供了程序的健康检查
 * （6）、基本可以完全不使用xml配置文件，采用注解配置
 * 3、四大核心
 * （1）、自动配置：针对spring应用程序常见的应用功能，springboot能自动提供相关的配置
 * （2）、起步依赖：告诉springboot需要什么功能，他就能引入需要的类库；
 * （3）、Actuator:让你能够深入运行中的springboot应用程序中，一探springboot的内部信息
 * （4）、命令行界面：这是springboot的可选特性，主要针对Groovy语言
 */


/**
 * 二、springboot自动配置原理
 * @SpringBootApplication :springboot的核心注解，该注解的作用开启自动扫描包和自动配置，
 * 该注解为一个组合注解;配置在某个类上，表明这个类是springboot的入口类及主配置类，
 * springboot就会运行该类的main方法来启动springboot服务.
 *
 * @SpringBootApplication由以下注解组成:
 * 1、@SpringBootConfiguration 【@Configration】：
 *  配置类上标注这个注解，配置类类似于我们过去用的xml配置文件，配置类也是spring中的组件
 *
 * 2、@EnableAutoConfiguration【@AutoConfigurationPackage @Import({AutoConfigurationImportSelector.class})】
 * @EnableAutoConfiguration告诉springboot开启自动配置功能和包扫描，这样自动配置才能生效
 *
 *  (1)、@AutoConfigurationPackage【@Import({Registrar.class})】：
 *      自动扫描包，由spring的底层注解@import实现，
 *      通过Registrar类的registerBeanDefinitions方法将注解所在包及其所有子包下的组件注入到springIOC容器中
 *  (2)、Spring的底层注解@Import，给容器中导入一些组件，导入那些组件由AutoConfigurationImportSelector.class 来指定
 *      AutoConfigurationImportSelector:自动配置选择器，其中的getAutoConfigurationEntry方法
 *      将需要自动配置的组件以配置类的类全名的方式返回，这样许多场景的自动配置类就注入到IOC容器中了;
 *      有了自动配置类，自动配置类就为我们配置了许多的组件， 就免去了我们手动编写配置注入功能组件的工作
 *
 *      这些配置类都配置在META-INF/spring.factories下面
 *
 *    Spring全家桶的整体整合解决方案和自动配置都在 spring-boot-autoconfigure-RELEASE.jar 下
 *    这些自动配置类在一定的 条件下才能生效
 *    我们可以在springboot的核心配置文件中配置debug=true,运行springboot的入口类来看那些配置类生效，那些配置类没有生效
 *
 *
 *
 *
 */
//springboot项目的入口,启动springboot了程序，启动内嵌的tomcat,@SpringBootApplication
// 是springboot的核心注解，主要作用是开启spring的自动配置
@SpringBootApplication
public class SpringbootHelloworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHelloworldApplication.class, args);
    }

}
