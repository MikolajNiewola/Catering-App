/**
 * Kontroler obsługujący stronę główną aplikacji.
 */
package com.catering.cateringapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Kontroler obsługujący żądania dotyczące głównej strony aplikacji.
 */
@Controller
public class HomeController {

    /**
     * Metoda obsługująca żądanie HTTP GET na głównym endpoint'cie "/".
     *
     * @return nazwa widoku do wyrenderowania (index)
     */
    @GetMapping("/")
    public String Home() {
        return "index";
    }
}
