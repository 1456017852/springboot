package com.naruto.springboot.bean;


import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
    private Integer id;
    private String empName;
    private String email;
    private Integer deptId;

}
