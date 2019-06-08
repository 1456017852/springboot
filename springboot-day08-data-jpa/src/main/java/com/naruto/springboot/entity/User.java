package com.naruto.springboot.entity;



import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

/**
 * 使用JPA注解，配置映射关系
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity//标识为JPA的组件(实体类,和数据库映射)
@Table(name="tb_user")
public class User {

    @Id//这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//逐渐生成策略(自增)
    private Integer id;

    @Column(name="user_name",length = 50)//这是和数据库表对对应的一个列
    private String userName;

    @Column//默认列名就是属性名
    private String email;
}
