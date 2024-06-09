package com.catering.cateringapp.controller;

import com.catering.cateringapp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class EmailController {

    @GetMapping("/kontakt")
    public String showKontakt() {
        return "kontakt";
    }

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendMail")
    public String sendEmail(@RequestParam String from, @RequestParam String subject, @RequestParam String text) {
        emailService.sendSimpleMessage(from, subject, text);
        return "redirect:/kontakt";
    }


}
