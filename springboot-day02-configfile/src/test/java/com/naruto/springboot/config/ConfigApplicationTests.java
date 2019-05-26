package com.naruto.springboot.config;

import com.naruto.springboot.config.bean.Person;
import com.naruto.springboot.config.bean.Student;
import com.naruto.springboot.config.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * springboot的单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigApplicationTests {

    @Autowired
    private Person person;

    @Autowired
    private User user;

    @Autowired
    private Student student;


    /**
     * 测试@ConfigurationProperties
     */
    @Test
    public void contextLoads() {
        System.out.println("person:----"+person);
    }


    /**
     * 测试@Value
     */
    @Test
    public void testValue() {
        System.out.println("user:----"+user);
    }


    /**
     * 测试@PropertySource+@Value
     */
    @Test
    public void testPropertySource() {
        System.out.println("student:----"+student);
    }

}
