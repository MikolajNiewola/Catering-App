package com.catering.cateringapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlatnoscController {
    @GetMapping("/platnosc")
    public String Platnosc() {
        return "platnosc";
    }
}