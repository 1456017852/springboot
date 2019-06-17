package com.naruto.springboot.service;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.naruto.springboot.bean.Employee;
import com.naruto.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployService {

    private final Log logger= LogFactory.getLog(EmployService.class);

    @Autowired
    private EmployeeMapper employeeMapper;

    public Employee getEmployeeById(Integer id){
        logger.info("查询"+id+"号员工");
        return employeeMapper.getEmployeeById(id);
    }

    public Employee updateEmployee(Employee employee) {
        logger.info("更新"+employee.getId()+"号员工");
         employeeMapper.updateEmployee(employee);
         return employee;
    }

    public void deleteEmployee(Integer id) {
        logger.info("删除"+id+"号员工");
        employeeMapper.deleteEmployee(id);
    }

    public List<Employee> getEmployees(String name) {
        logger.info("模糊查询"+name+"号员工");
        return employeeMapper.getEmployees(name);
    }
}
