package com.sale.myweb.controller;

import com.sale.myweb.services.ClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    public String index(ModelMap model, HttpSession session) {
       model.addAttribute("users",session.getAttribute("user"));
        model.addAttribute("allTypes",clothService.findAllTypes());
        model.addAttribute("allCloths",clothService.getAllCloth());

        return "index";
    }
    @GetMapping("/cloths")
    public List getCloth() {
        return clothService.findByDiscount("30","60");

    }

    @GetMapping("/clothdetail")
    public String clothDetail(@RequestParam("clothId") String clothId,ModelMap model,HttpSession session) {

        model.addAttribute("users",session.getAttribute("user"));
        model.addAttribute("clothDetail",clothService.findByclothId(clothId));

        return "clothdetail";
    }




    @PostMapping("/searchCloth")
    public String searchCloth(@RequestParam String clothName,ModelMap model,HttpSession session) {

        model.addAttribute("cloths",clothService.getClothByLikeName(clothName));
        model.addAttribute("users",session.getAttribute("user"));
        model.addAttribute("num",clothService.getClothByLikeName(clothName).size());

        return "searchResult";
    }



}
