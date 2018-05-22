package com.sale.myweb.controller;

import com.sale.myweb.services.ClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author abin
 * @version 1.0
 * @date 2018/5/15 18:25
 */

@Controller
public class CommoditController {

    @Autowired
    ClothService clothService;

    @ResponseBody
    @GetMapping("/test1")
    public List test1() {
        return  clothService.findAllTypes();
    }


    @GetMapping("/index")
    public String index(ModelMap model) {

        model.addAttribute("allTypes",clothService.findAllTypes());
        model.addAttribute("allCloths",clothService.getAllCloth());

        return "index";
    }
    @GetMapping("/cloths")
    public List getCloth() {
        return clothService.findByDiscount("30","60");

    }

}
