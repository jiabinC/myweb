package com.sale.myweb.controller;

import com.sale.myweb.services.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ManagerController {

    private ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }
    @GetMapping("/loginAdmin")
    public String loginAdmin() {
        return "loginAdmin";
    }

    @GetMapping("/adminCenter")
    public String adminCenter() {
        return "adminCenter";
    }

    @GetMapping("/userAnalysis")
    public String userAnalysis(ModelMap model) {

        List womens =managerService.gerUsersBySex("女");
        int womenNum = womens.size();
        List mans = managerService.gerUsersBySex("男");
        int manNum = mans.size();


        return "userAnalysis";
    }
    @GetMapping("/clothInformation")
    public String clothInformation(ModelMap model) {
        List allCloths = managerService.getAllClothOfManager();
        model.addAttribute("allCloths",allCloths);

        return "clothInformation";
    }
}
