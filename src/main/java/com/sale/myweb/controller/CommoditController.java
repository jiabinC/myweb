package com.sale.myweb.controller;

import com.sale.myweb.services.ClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author abin
 * @version 1.0
 * @date 2018/5/15 18:25
 */

@RestController
public class CommoditController {

    @Autowired
    ClothService clothService;

    @GetMapping("/index")
    public String index(ModelMap model) {

        model.addAttribute("allCloths",clothService.getAllCloth());

        return "index";
    }
    @GetMapping("/cloths")
    public List getCloth() {
        return clothService.findByDiscount("30","60");

    }

}
