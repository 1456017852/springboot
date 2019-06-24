package com.naruto.springboot.asyn.controller;

import com.naruto.springboot.asyn.service.AsynService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsynController {

    @Autowired
    private AsynService asynService;

    /**
     * 同步
     * @return
     */
    @RequestMapping("/sayHello")
    public String sayHello(){
        asynService.sayHello();
        return "hello";
    }

    /**
     * 异步
     * @return
     */

    @RequestMapping("/asyn/sayHello")
    public String sayAsynHello(){
        asynService.sayAsynHello();
        return "hello";
    }

}
