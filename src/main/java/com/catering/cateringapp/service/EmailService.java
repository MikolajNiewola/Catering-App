package com.catering.cateringapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleMessage(String from, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("tok.test.test@gmail.com");
        message.setFrom(from);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
        System.out.println("Mail został wysłany");
    }
}
