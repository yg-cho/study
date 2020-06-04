package com.example.study.repository;


import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.repository.UserRepository;
import com.example.study.repository.UserRepositoryTest;
import com.example.study.StudyApplication;
import com.example.study.model.entity.User;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

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
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser03");


        User newUser = userRepository.save(user);
        System.out.println("newUser : " + newUser);
    }

    @Test
    @Transactional
    public void read(){
        //finById 의 쿼리문
        //select * from user where id = ?
        Optional<User> user = userRepository.findByAccount("TestUser03");

        user.ifPresent(selectUser -> selectUser.getOrderDetailList().forEach(detail -> {
            Item item = detail.getItem();
            System.out.println(detail.getItem());
        }));
    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findById(1L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("AAAA");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);

        });
    }

    @Test
    @Transactional
    public void delete(){
        Optional<User> user = userRepository.findById(2L);
        //org.junit (DI 설정 필요)
        Assert.assertTrue(user.isPresent()); //true
        user.ifPresent(selectUser -> userRepository.delete(selectUser));

        Optional<User> deleteUser = userRepository.findById(2L);

        Assert.assertFalse(deleteUser.isPresent()); //false
    }
}