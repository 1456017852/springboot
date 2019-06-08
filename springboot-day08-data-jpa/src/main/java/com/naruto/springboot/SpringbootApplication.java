package com.naruto.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot整合JPA
 *
 * 1、pom引入JPA
 * <dependency>
 *     <groupId>org.springframework.boot</groupId>
 *     <artifactId>spring-boot-starter-data-jpa</artifactId>
 * </dependency>
 *
 * 2、基本的配置
 * JPAspring.jpa.hibernate.ddl-auto=update
 * spring.jpa.show-sql=true
 *
 * 3、编写一个实体类
 *  @Entity//标识为JPA的组件(实体类,和数据库映射)
 *  @Table(name="tb_user")
 *  public class User {
 *
 *     @Id//这是一个主键
 *     @GeneratedValue(strategy = GenerationType.IDENTITY)//逐渐生成策略(自增)
 *     private Integer id;
 *
 *     @Column(name="user_name",length = 50)//这是和数据库表对对应的一个列
 *     private String userName;
 *
 *     @Column//默认列名就是属性名
 *     private String email;
 *  }
 *
 *  4、编写一个Repository继承JpaRepository,来操作对应对应的数据库表
 *
 *  5、Controller层注入UserRepository
 *
 *  6、访问 http:localhost:8080/user?userName=naruto&email=1234@qq.com
 *
 *
 */
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
