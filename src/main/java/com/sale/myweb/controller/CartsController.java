package com.sale.myweb.controller;


import com.sale.myweb.entity.Carts;
import com.sale.myweb.entity.Users;
import com.sale.myweb.services.CartsService;
import com.sale.myweb.services.ClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartsController {

    private final CartsService cartsService;
    private final ClothService clothService;

    @Autowired
    public CartsController(CartsService cartsService,ClothService clothService) {
        this.cartsService = cartsService;
        this.clothService = clothService;
    }

    @PostMapping("/addClothToCart")
    public String addClothToCart(@RequestParam String clothId, @RequestParam String clothNumber, HttpSession session, ModelMap model) {
        if(session.getAttribute("user")==null){
            model.addAttribute("result","您还没有登陆，请先登陆！");
            return "login";
        }

        Users users = (Users) session.getAttribute("user");
        Integer integer = Integer.parseInt(clothNumber);
        cartsService.addClothsToCarts(new Carts(users.getUserId(),clothId,integer));
        List<Carts> carts = cartsService.getMyCarts(users);
        model.addAttribute("carts",carts);
        model.addAttribute("users",users);
        model.addAttribute("cloths",clothService.getAllCloth());
        return "myCart";
    }


    @GetMapping("/myCart")
    public String myCart(HttpSession session,ModelMap model) {
        Users users = (Users) session.getAttribute("user");
        List<Carts> carts = cartsService.getMyCarts(users);
        model.addAttribute("carts",carts);
        model.addAttribute("users",session.getAttribute("user"));
        model.addAttribute("cloths",clothService.getAllCloth());
        return "myCart" ;
    }
}
