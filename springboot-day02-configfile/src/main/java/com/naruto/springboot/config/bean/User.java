package com.naruto.springboot.config.bean;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {

    @Value("${user.id}")
    private int id;

    @Value("${user.name}")
    private String name;

    @Value("${user.age}")
    private int age;



}
