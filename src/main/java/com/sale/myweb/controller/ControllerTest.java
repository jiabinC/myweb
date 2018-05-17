package com.sale.myweb.controller;

import com.sale.myweb.DAO.ClothRepository;
import com.sale.myweb.entity.Users;
import com.sale.myweb.DAO.UserRepository;
import com.sale.myweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public String test() {
        userRepository.save(new Users("dada", "123","adad","dad","ada","ada"));
        userRepository.save(new Users("aaa","dad","dad","ada","22","d"));
        String s = userRepository.toString();
        List user = userRepository.findAll();
       return userService.userLogin(new Users("dada", "123","adad","dad","ada","ada"));



    }

    @Autowired
    ClothRepository clothRepository;

    @GetMapping("/cloth")
    public List test1() {
        return clothRepository.findAll();

    }
}
