package com.sale.myweb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class OtherController {

    @Autowired
<<<<<<< HEAD


    JavaMailSender javaMailSender;
>>>>>>> 9b487e8b0d5720ad21dfebcecc9afc4c6ab2bd41
    @PostMapping("/sendEmail")
    public String sendEmail(@RequestParam("mailTitle") String mailTitle, @RequestParam("mailContent") String mailContent, ModelMap model) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("abin_c@sina.com");
        simpleMailMessage.setTo("abin_c@sina.com");
        simpleMailMessage.setSubject(mailTitle);
        simpleMailMessage.setText(mailContent);
<<<<<<< HEAD
        javaMailSender.send(simpleMailMessage);
=======
        javaMailSender.send(simpleMailMessage);
>>>>>>> 9b487e8b0d5720ad21dfebcecc9afc4c6ab2bd41
        model.addAttribute("result","邮件已发送");
        return "contact";



    }

    @GetMapping("/contact")
    public String contact(HttpSession session,ModelMap model) {
        model.addAttribute("users",session.getAttribute("user"));
        return "contact";
    }
}
