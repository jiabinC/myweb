package com.sale.myweb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OtherController {

    @Autowired
    JavaMailSender mailSender;

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestParam("mailTitle") String mailTitle, @RequestParam("mailContent") String mailContent, ModelMap model) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("abin_c@sina.com");
        simpleMailMessage.setTo("abin_c@sina.com");
        simpleMailMessage.setSubject(mailTitle);
        simpleMailMessage.setText(mailContent);
        mailSender.send(simpleMailMessage);
        model.addAttribute("result","邮件已发送");
        return "contact";



    }
}
