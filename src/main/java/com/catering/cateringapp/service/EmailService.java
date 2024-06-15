package com.catering.cateringapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Serwis do wysyłania prostych wiadomości email.
 */
@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    /**
     * Wysyła prostą wiadomość email.
     *
     * @param from    adres email nadawcy
     * @param subject temat wiadomości email
     * @param text    treść wiadomości email
     */
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