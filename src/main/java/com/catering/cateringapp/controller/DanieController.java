package com.catering.cateringapp.controller;

import com.catering.cateringapp.model.Danie;
import com.catering.cateringapp.repository.DanieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DanieController {
    @Autowired
    private DanieRepository danieRepository;

    @GetMapping("/dania")
    public String menu(Model model) {
        List<Danie> dania = danieRepository.findAll();
        model.addAttribute("dania", dania);
        return "listaDan";
    }
}
