package com.naruto.springboot.controller;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.naruto.springboot.bean.Employee;
import com.naruto.springboot.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Cache注解开发
 */
@RestController
public class EmployeeController {

    private final Log logger= LogFactory.getLog(EmployeeController.class);

    @Autowired
    private EmployService employService;

    /**
     *
     *@Cacheable：主要针对方法配置，能够根据方法的请求参数对其结果进行缓存（查询）
     *  1、@Cacheable运行时机：
     *      @Cacheable标注的方法执行之前先来检查缓存，有没有这个数据，默认按照参数作为key去查询
     *      如果有就直接从缓存中获取方法调用后的结果，
     *      如果没有就调用方法并缓存结果后返回给用户，下次调用直接从缓存中获取
     *  2、@Cacheable的属性：
     *      value/cacheNames：缓存组件的名称
     *      key:缓存数据的key，可以为空，如果指定要按照SpEL 表达式编写，
     *          如果不指定，则缺省按照方法的所有参数进行组合(默认使用方法参数的值)
     *      keyGenerator:指定key的生成策略(与key二选一)
     *      cacheManager:指定从哪个缓存管理器中获取该缓存
     *      cacheResolver:指定从哪个缓存解析器中获取该缓存(与cacheManager二选一)
     *      condition:指定的条件符合，才缓存 eg:#id>0
     *      unless:指定的条件为true,不缓存 eg:unless="result==null"
     *      sync:是否使用异步模式
     * @param id
     * @return
     */
    @Cacheable(value = {"emp","temp"},
            key="#id",
            /*keyGenerator = "keyGenerator",*/
            condition = "#id>0",
            unless = "#id==0")
    @RequestMapping("/get/emp/{id}")
    public Employee getEmployeeById(@PathVariable("id") Integer id){
        return employService.getEmployeeById(id);
    }

    /**
     * @CachePut:保证方法被调用，又希望结果被缓存，修改数据库的数据，同时更新缓存(增加、修改)
     *
     * 1、@CachePut运行时机：先调用目标方法，同时更新缓存
     *      http://localhost:8081/update/emp?id=1&empName=naruto1&email=1234@qq.com1&deptId=11
     * 2、@CachePut的属性：同@Cacheable(没有sync)
     *
     */
    @CachePut(value = {"emp","temp"},
            key="#employee.id",
            /*keyGenerator = "keyGenerator",*/
            condition = "#employee.id>0",
            unless = "#result==null")
    @RequestMapping("/update/emp")
    public Employee updateEmployee(Employee employee){
         return employService.updateEmployee(employee);
    }

}
