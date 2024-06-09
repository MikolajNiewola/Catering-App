package com.catering.cateringapp.controller;

import com.catering.cateringapp.model.Danie;
import com.catering.cateringapp.repository.DanieRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DanieCotroller {
    @Autowired
    private DanieRepository danieRepository;

    @GetMapping("/dania")
    public String listaDan(Model model) {
        List<Danie> dania = danieRepository.findAll();
        model.addAttribute("dania", dania);
        return "listaDan";
    }
}
