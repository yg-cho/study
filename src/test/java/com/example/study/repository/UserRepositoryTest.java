package com.example.study.repository;


import com.example.study.StudyApplicationTests;
import com.example.study.repository.UserRepository;
import com.example.study.repository.UserRepositoryTest;
import com.example.study.StudyApplication;
import com.example.study.model.entity.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserRepositoryTest extends StudyApplicationTests {

    //Spring의 디자인패턴 - Dependency Injection
    //의존성 주입 (직접 객체를 만들지 않고 스프링이 관리하겠다. 의존성은 스프링이 주입)
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        //String sql = insert into user (%s, %s, %d) values (account,email,age
        //Single tone Pattern
        User user = new User();
        user.setAccount("TestUser01");
        user.setEmail("TestUser01@gmail.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser01");


        User newUser = userRepository.save(user);
        System.out.println("newUser : " + newUser);
    }

    public void read(){

    }

    public void update(){

    }


}
