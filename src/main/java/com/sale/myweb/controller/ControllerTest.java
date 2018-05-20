package com.sale.myweb.controller;

import com.sale.myweb.DAO.ClothRepository;
import com.sale.myweb.entity.Carts;
import com.sale.myweb.entity.Users;
import com.sale.myweb.DAO.UserRepository;
import com.sale.myweb.services.CartsService;
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
        return userService.userRegister(new Users("aaa","aaa","aaa","aaa","男","ddd"));



    }


    @Autowired
    ClothRepository clothRepository;
    CartsService cartsService;

    @GetMapping("/cloth")
    public List test1() {
        return clothRepository.findAll();

    }
//    @GetMapping("/addCarts")
//    public List test2(){
//        cartsService.addClothsToCarts(new Carts("ddd","ddd","ddd"));
//        return  cartsService.
//
//    }
}
