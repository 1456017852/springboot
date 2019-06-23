package com.naruto.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 一、springboot默认支持两种技术来和elasticsearch交互
 *
 * 1、jest(默认不生效)
 *
 *  (1)需要导入jest的工具包（io.searchbox.client.JestClient）
 *      <dependency>
 *          <groupId>io.searchbox</groupId>
 *          <artifactId>jest</artifactId>
 *          <version>5.3.4</version>
 *      </dependency>
 *
 *  (2)properties属性配置
 *      #springboot jest 方式的属性配置
 *      spring.elasticsearch.jest.uris=http://192.168.1.108:9200
 *
 *  (3)在SpringbootApplicationTests注入JestClient来交互
 *
 *
 * 2、SpringData ElasticSearch
 *      自动配置类：
 *      ElasticsearchAutoConfiguration：ElasticsearchClient（clusterNodes、clusterName）
 *      ElasticsearchProperties：elasticsearch的属性配置
 *      ElasticsearchDataAutoConfiguration：ElasticsearchTemplate、ElasticsearchConverter
 *
 *
 */
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
