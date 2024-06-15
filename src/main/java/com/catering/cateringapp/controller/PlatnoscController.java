/**
 * Kontroler obsługujący operacje związane z płatnościami.
 */
package com.catering.cateringapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Kontroler obsługujący żądania dotyczące płatności.
 */
@Controller
public class PlatnoscController {

    /**
     * Metoda obsługująca żądanie HTTP GET na endpoint /platnosc.
     *
     * @return nazwa widoku do wyrenderowania (platnosc)
     */
    @GetMapping("/platnosc")
    public String Platnosc() {
        return "platnosc";
    }
}
