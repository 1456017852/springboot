package com.naruto.springboot.mapper;

import com.naruto.springboot.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {

    Employee getEmployeeById(Integer id);

    void updateEmployee(Employee employee);
}
