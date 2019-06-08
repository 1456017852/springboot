package com.naruto.springboot.repository;

import com.naruto.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 编写一个Repository集成JpaRepository,来操作对应的数据库表
 */
public interface UserRepository extends JpaRepository<User,Integer> {

}
