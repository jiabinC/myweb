package com.sale.myweb.controller;

import com.sale.myweb.entity.Users;
import com.sale.myweb.DAO.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author abin
 * @version 1.0
 * @date 2018/5/5 11:21
 */


@RestController
public class ControllerTest {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/user")
    public List test() {
        userRepository.save(new Users("dada", 132));
        userRepository.save(new Users("dadaa", 132));
        userRepository.save(new Users("DADA",12));
        String s = userRepository.toString();
        List user = userRepository.findAll();


        return user;
    }
}
