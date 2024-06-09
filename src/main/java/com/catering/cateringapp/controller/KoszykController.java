package com.catering.cateringapp.controller;

import com.catering.cateringapp.model.Danie;
import com.catering.cateringapp.model.Koszyk;
import com.catering.cateringapp.repository.DanieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("koszyk")
public class KoszykController {

    @Autowired
    private DanieRepository danieRepository;


    @ModelAttribute("koszyk")
    public List<Koszyk> utworzKoszyk() {
        return new ArrayList<>();
    }

    @GetMapping("/koszyk")
    public String pokazKoszyk() {
        return "koszyk";
    }

    @PostMapping("/usunZKoszyka")
    public String usunZKoszyka(@RequestParam Long id, @ModelAttribute("koszyk") List<Koszyk> koszyk) {
        koszyk.removeIf(pozycja -> pozycja.getDanie().getId().equals(id));
        return "redirect:/koszyk";
    }

    @PostMapping("/dodajDoKoszyka")
    public String dodajDoKoszyka(@RequestParam Long id, @RequestParam int ilosc,
                                 @ModelAttribute("koszyk") List<Koszyk> koszyk) {
        Optional<Danie> opcjonalneDanie = danieRepository.findById(id);

        if (opcjonalneDanie.isPresent()) {
            Danie danie = opcjonalneDanie.get();

            Optional<Koszyk> opcjonalnaPozycja = koszyk.stream()
                    .filter(p -> p.getDanie().getId().equals(danie.getId()))
                    .findFirst();

            if (opcjonalnaPozycja.isPresent()) {
                Koszyk pozycja = opcjonalnaPozycja.get();
                pozycja.setIlosc(pozycja.getIlosc() + ilosc);
            } else {
                Koszyk nowaPozycja = new Koszyk();
                nowaPozycja.setDanie(danie);
                nowaPozycja.setIlosc(ilosc);
                koszyk.add(nowaPozycja);
            }
        }

        return "redirect:/dania";
    }


}
