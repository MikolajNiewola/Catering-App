/**
 * Kontroler obsługujący zasoby dotyczące dań w aplikacji.
 */
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

    /**
     * Metoda obsługująca żądanie HTTP GET na endpoint /dania.
     * Pobiera listę wszystkich dań z repozytorium i przekazuje je do modelu.
     *
     * @param model obiekt Model do przekazania danych do widoku
     * @return nazwa widoku do wyrenderowania (listaDan)
     */
    @GetMapping("/dania")
    public String menu(Model model) {
        List<Danie> dania = danieRepository.findAll();
        model.addAttribute("dania", dania);
        return "listaDan";
    }
}
