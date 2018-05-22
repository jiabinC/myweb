package com.sale.myweb.controller;import com.sale.myweb.entity.Users;import com.sale.myweb.services.ClothService;import com.sale.myweb.services.UserService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.ui.Model;import org.springframework.ui.ModelMap;import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.ModelAttribute;import org.springframework.web.bind.annotation.PostMapping;import org.springframework.web.bind.annotation.ResponseBody;import javax.servlet.http.HttpServletResponse;import javax.servlet.http.HttpSession;import java.util.List;@Controllerpublic class UserController {    private final UserService userService;    private final ClothService clothService;    @Autowired    public UserController(UserService userService,ClothService clothService) {        this.userService = userService;        this.clothService = clothService;    }    @GetMapping("/register")    public String registerGet() {        return "register";    }    @PostMapping("/register")    public String registerPost(@ModelAttribute Users users,ModelMap model,HttpServletResponse response) {        String result = userService.userRegister(users);      //  System.out.println(users);        model.addAttribute("registerResult",result);        if (result.equals("注册成功")) {            return response.encodeRedirectURL("/login");        }        else {            model.addAttribute("result",result);            return response.encodeRedirectURL("/register");        }    }    @GetMapping("/login")    public String loginGet() {        return "login";    }    @PostMapping("/login")    public String loginPost(Model model, @ModelAttribute Users users, HttpSession session, HttpServletResponse response) {        String result = userService.userLogin(users);        if (result.equals("登陆成功")) {            session.setAttribute("user", users);            model.addAttribute("users",session.getAttribute("user"));            model.addAttribute("allTypes", clothService.findAllTypes());            model.addAttribute("allCloths", clothService.getAllCloth());            return response.encodeRedirectURL("/index");        }        else {            model.addAttribute("result", result);            return response.encodeRedirectURL("login");        }    }    @GetMapping("/loginOut")    public String loginOut(HttpSession session, ModelMap model) {        session.removeAttribute("user");        model.addAttribute("allTypes", clothService.findAllTypes());        model.addAttribute("allCloths", clothService.getAllCloth());        return "index";    }}