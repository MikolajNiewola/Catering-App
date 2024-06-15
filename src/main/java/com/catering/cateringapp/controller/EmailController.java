/**
 * Kontroler obsługujący operacje związane z wysyłaniem e-maili.
 */
package com.catering.cateringapp.controller;

import com.catering.cateringapp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Kontroler obsługujący widoki i operacje związane z wysyłaniem e-maili.
 */
@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    /**
     * Obsługuje żądanie HTTP GET na endpoint /kontakt.
     *
     * @return nazwa widoku do wyrenderowania (kontakt)
     */
    @GetMapping("/kontakt")
    public String showKontakt() {
        return "kontakt";
    }

    /**
     * Obsługuje żądanie HTTP POST na endpoint /sendMail do wysyłania e-maili.
     * Po wysłaniu e-maila przekierowuje użytkownika z powrotem na stronę kontaktową.
     *
     * @param from    adres e-mail nadawcy
     * @param subject temat e-maila
     * @param text    treść e-maila
     * @return przekierowanie na endpoint /kontakt po wysłaniu e-maila
     */
    @PostMapping("/sendMail")
    public String sendEmail(@RequestParam String from, @RequestParam String subject, @RequestParam String text) {
        emailService.sendSimpleMessage(from, subject, text);
        return "redirect:/kontakt";
    }

}
