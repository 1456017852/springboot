package com.naruto.springboot.mapper;

import com.naruto.springboot.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    Employee getEmployeeById(Integer id);

    void updateEmployee(Employee employee);

    void deleteEmployee(Integer id);

    List<Employee> getEmployees(String name);
}
