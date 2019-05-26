package com.naruto.springboot.config.bean;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
@PropertySource("classpath:student.properties")
public class Student {

    @Value("${student.id}")
    private int id;
    @Value("${student.name}")
    private String name;
    @Value("${student.age}")
    private int age;



}
