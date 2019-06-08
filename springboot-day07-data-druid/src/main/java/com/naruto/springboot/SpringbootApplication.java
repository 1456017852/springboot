package com.naruto.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot整合Druid数据源
 *  1、pom引入
 *      <!--引入druid 数据源 -->
 *      <dependency>
 *         <groupId>com.alibaba</groupId>
 *         <artifactId>druid</artifactId>
 *         <version>1.1.16</version>
 *      </dependency>
 *
 *  2、spring配置文件
 *      spring.datasource.url=jdbc:mysql://127.0.0.1:3306/springboot?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8&useSSL=false
 *      spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
 *      spring.datasource.username=root
 *      spring.datasource.password=123456
 *      #指定数据原类型为Druid数据源
 *      spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
 *      #Druid数据源的配置
 *      spring.datasource.initial-size=5
 *      spring.datasource.min-idle=5
 *      spring.datasource.max-active=20
 *      spring.datasource.max-wait=60000
 *      spring.datasource.time-between-eviction-runs-millis=60000
 *      spring.datasource.min-evictable-idle-time-millis=30000
 *      spring.datasource.validation-query=SELECT 1 FROM DUAL
 *      spring.datasource.test-while-idle=true
 *      spring.datasource.test-on-borrow=false
 *      spring.datasource.test-on-return=false
 *      spring.datasource.pool-prepared-statements=true
 *      #spring.datasource.filters=stat,wall,log4j
 *      spring.datasource.maxPoolPreparedStatementPerConnectionSize=20
 *      spring.datasource.useGlobalDataSourceStat=true
 *      spring.datasource.connection-properties=druid.stat.mergeSql=true;druid.slowSqlMillis=500
 *
 * 3、编写配置文件DruidConfig
 *
 *      (1)给容器中注入DruidDataSource
 *          @Bean
 *          @ConfigurationProperties(prefix = "spring.datasource")//配置文件中的属性和DruidDataSource属性映射
 *          public DataSource druid(){
 *              return new DruidDataSource();
 *          }
 *      (2)配置监控
 *          配置一个管理后台的servlet
 *          @Bean
 *          public ServletRegistrationBean statViewServlet(){
 *              ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
 *              //配置初始化参数
 *              Map<String,String> initParams=new HashMap<>();
 *              initParams.put("loginUsername","admin");
 *              initParams.put("loginPassword","123456");
 *              servletRegistrationBean.setInitParameters(initParams);
 *              return servletRegistrationBean;
 *          }
 *
 *          配置一个监控的filter
 *          @Bean
 *          public FilterRegistrationBean webStatFilter(){
 *              FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
 *              filterRegistrationBean.setFilter(new WebStatFilter());
 *              //配置初始化参数
 *              Map<String,String> initParams=new HashMap<>();
 *              initParams.put("exclusions","*.js,*.css,/druid/*");//
 *              filterRegistrationBean.setInitParameters(initParams);
 *              filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
 *              return filterRegistrationBean;
 *          }
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
