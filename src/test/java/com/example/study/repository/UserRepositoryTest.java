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

        String account = "Test01";
        String password = "Test01";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-2222";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);

        Assert.assertNotNull(newUser);



    }

    @Test
    @Transactional
    public void read(){

        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");
        Assert.assertNotNull(user);



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