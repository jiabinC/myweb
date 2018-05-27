package com.sale.myweb.controller;

import com.sale.myweb.entity.Cloth;
import com.sale.myweb.entity.Manager;
import com.sale.myweb.services.ClothService;
import com.sale.myweb.services.ManagerService;
import com.sale.myweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ManagerController {

    private ManagerService managerService;
    private UserService userService;
    private ClothService clothService;

    @Autowired
    public ManagerController(ManagerService managerService,UserService userService,ClothService clothService) {
        this.managerService = managerService;
        this.userService = userService;
        this.clothService = clothService;
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

        model.addAttribute("womens",womens);
        model.addAttribute("mans",mans);
        model.addAttribute("womenNum",womenNum);
        model.addAttribute("manNum",manNum);

        return "userAnalysis";
    }
    @GetMapping("/clothInformation")
    public String clothInformation(ModelMap model) {
        List allCloths = managerService.getAllClothOfManager();
        model.addAttribute("allCloths",allCloths);

        return "clothInformation";
    }

    @PostMapping("/adminCenter")
    public String adminCenter(@ModelAttribute Manager manager, ModelMap model) {

        if (manager.getManagerId().equals(managerService.getManager().getManagerId() )&& manager.getManagerPassword().equals(managerService.getManager().getManagerPassword())) {

            return "adminCenter";
        } else{
            model.addAttribute("result","账号或密码错误");
            return "loginAdmin";

        }

    }

    @GetMapping("/userInformation")
    public String userInformation(@RequestParam String userName,ModelMap model ) {
        model.addAttribute("users",userService.findByUserName(userName));
        return "userCenter";
    }

    @PostMapping("/modifyCloth")
    public String modifyCloth(@ModelAttribute Cloth cloth,ModelMap model) {
        clothService.addCloth(cloth);
        List allCloths = managerService.getAllClothOfManager();
        model.addAttribute("allCloths",allCloths);
        return "clothInformation";

    }
}
