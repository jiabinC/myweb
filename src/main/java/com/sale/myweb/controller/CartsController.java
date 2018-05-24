package com.sale.myweb.controller;


import com.sale.myweb.entity.Carts;
import com.sale.myweb.entity.Users;
import com.sale.myweb.services.CartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartsController {

    private final CartsService cartsService;

    @Autowired
    public CartsController(CartsService cartsService) {
        this.cartsService = cartsService;
    }

    @PostMapping("addClothToCart")
    public String addClothToCart(@RequestParam String clothId, @RequestParam String clothNumber, HttpSession session, ModelMap model) {
        Users users = (Users) session.getAttribute("user");
        cartsService.addClothsToCarts(new Carts(users.getUserId(),clothId,clothNumber));
        List<Carts> carts = cartsService.getMyCarts(users);
        model.addAttribute("carts",carts);
        model.addAttribute("users",users);
        return "myCart";
    }
}
