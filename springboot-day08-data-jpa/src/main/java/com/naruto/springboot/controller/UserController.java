package com.naruto.springboot.controller;

import com.naruto.springboot.entity.User;
import com.naruto.springboot.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userRepository.getOne(id);
    }

    @GetMapping("/user")
    public User insertUser(User user){
        return userRepository.save(user);
    }

}
