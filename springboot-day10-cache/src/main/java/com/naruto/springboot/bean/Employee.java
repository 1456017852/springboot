package com.naruto.springboot.bean;


import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String empName;
    private String email;
    private Integer deptId;

}
