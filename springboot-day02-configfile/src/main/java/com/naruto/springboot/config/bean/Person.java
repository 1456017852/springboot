package com.naruto.springboot.config.bean;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.Map;


/**
 *配置文件的相关配置映射到IOC中的组件上
 *
 * @ConfigurationProperties(prefix = "person")
 * prefix = "person":那个配置下的属性
 *
 */

@Component //通过自动扫包注册到IOC容器中
@ConfigurationProperties(prefix = "person")//将类中的属性和配置文件的相关配置映射
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private int id;
    private String name;
    private boolean isBoss;
    private Date birth;

    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;

}
