package com.catering.cateringapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void wyslijEmail(String adres, String temat, String tresc) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(adres);
        mailMessage.setSubject(temat);
        mailMessage.setText(tresc);

        javaMailSender.send(mailMessage);
    }
}
