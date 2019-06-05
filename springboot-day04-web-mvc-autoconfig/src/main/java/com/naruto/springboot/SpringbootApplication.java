package com.naruto.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 * 一、springboot下的springmvc注解
 * 1、@controller
 * 同springmvc中的用法一样，用于前端控制器的注解
 * 2、@Resrcontroller
 * 相当于@controller和@ResponseBody的组合，该注解用于数据的返回，不能用于页面的跳转
 * 3、@GetMappering
 * 相当于RequestMapperin和get方法请求的组合
 * 4、@PostMappering
 * 相当于RequestMapperin和post方法请求的组合
 * 5、@PutMappering
 * 相当于RequestMapperin和put方法请求的组合,可以用post代替
 * 6、@DeleteMappering
 * 相当于RequestMapperin和delete方法请求的组合，可以用get代替；
 *
 *
 * 二、springboot对springmvc的自动配置--【WebMvcAutoConfiguration】
 *
 * 1、ContentNegotiatingViewResolver
 *      springboot自动配置了ViewResolver,ContentNegotiatingViewResolver :组合所有的视图解析器
 *      如何定制我们自己的试图解析器？我们可以给容器中添加一个试图解析器组件(@Bean),
 *      ContentNegotiatingViewResolver 将自动将其组合进来
 * 2、springboot自动为我们提供了静态资源的映射
 *      WebJars ,index.html,Favicon.ico
 * 3、springboot自动为我们配置了Converter,formatter
 *      Converter:类型转换组件
 *      Formatter :格式化器
 *      自己添加的格式化转化器，我们只需要放到容器中即可
 * 4、springboot自动配置了HttpMessageConverters
 *      HttpMessageConverters ：springmvc用来转换http请求和响应的；User---Json,xml
 *      HttpMessageConverters 从容器中确定，获取所有的HttpMessageConverter
 *      自己添加的HttpMessageConverter组件(@Bean)，我们只需要放到容器中即可
 * 5、springboot自动配置了MessageCodesResolver
 *      定义错误代码的生成规则
 * 6、springboot自动配置了ConfigurableWebBindingInitializer
 *      初始化WebDataBinder,请求数据---javabean
 *      自己添加的ConfigurableWebBindingInitializer，我们只需要放到容器中即可
 *
 * 二、pringboot对springmvc的自动配置的扩展
 *
 *     1、【扩展】
 *      spring boot在配置springMvc组件时
 *      先看容器中有没有用户自己注册的springMvc组件,
 *      如果有就会用自己注册的springMvc组件(编写一个配置类@Configration,继承WebMvcConfigurer)
 *      如果没有自己注册springMvc组件，就会用springboot自动配置注册的springMvc组件
 *      如果有些组件可以有注册多个(ViewResvoler)，将组合使用(即springboot的自动配置，和我们的扩展配置都会起作用)
 *
 *
 *     2、【全面接管springMvc的配置】--- @EnableWebMvc
 *      我们自己的编写的配置类(@Configration),不能把标@EnableWebMvc
 *      如果我们的配置类标注了@EnableWebMvc表示springboot为我们自动配置的springMvc组件将失效，
 *      我们自己将全面接管springmvc组件的配置， 这个时候所有的springMvc所需要的组件我们都需要自己配置
 *
 *      原因：
 *
 *      @Import({DelegatingWebMvcConfiguration.class})
 *      public @interface EnableWebMvc{}
 *
 *      @Configuration
 *      public class DelegatingWebMvcConfiguration extends WebMvcConfigurationSupport {}
 *
 *      @Configuration
 *      @ConditionalOnWebApplication( type = Type.SERVLET)
 *      @ConditionalOnClass({Servlet.class, DispatcherServlet.class, WebMvcConfigurer.class})
 *      @ConditionalOnMissingBean({WebMvcConfigurationSupport.class})
 *      @AutoConfigureOrder(-2147483638)
 *      @AutoConfigureAfter({DispatcherServletAutoConfiguration.class, TaskExecutionAutoConfiguration.class, ValidationAutoConfiguration.class})
 *      public class WebMvcAutoConfiguration {}
 *
 *
 *      由上述发现@EnableWebMvc给容器中导入DelegatingWebMvcConfiguration组件,
 *      DelegatingWebMvcConfiguration extends WebMvcConfigurationSupport,
 *      而WebMvcAutoConfiguration在springIOC容器没有WebMvcConfigurationSupport的才会生效
 *
 *
 */
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
