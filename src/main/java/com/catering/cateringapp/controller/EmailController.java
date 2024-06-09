package com.catering.cateringapp.controller;

import com.catering.cateringapp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    public static void main(String[] args){
        SpringApplication.run(EmailController.class,args);
    }

    @GetMapping("/send-email")
    public String sendEmail(@RequestParam String from, @RequestParam String subject, @RequestParam String text) {
        from = "marcelnose@o2.pl";
        subject = "test starego";
        text = "twój stary działą";
        emailService.sendSimpleMessage(from, subject, text);
        return "Email sent successfully";
    }
}
