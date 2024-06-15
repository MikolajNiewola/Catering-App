/**
 * Kontroler obsługujący operacje związane z koszykiem zakupów.
 */
package com.catering.cateringapp.controller;

import com.catering.cateringapp.model.Danie;
import com.catering.cateringapp.model.Koszyk;
import com.catering.cateringapp.repository.DanieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Kontroler obsługujący operacje związane z koszykiem zakupów.
 */
@Controller
@SessionAttributes("koszyk")
public class KoszykController {

    @Autowired
    private DanieRepository danieRepository;

    /**
     * Metoda dodająca atrybut "koszyk" do sesji, inicjująca pusty koszyk.
     *
     * @return nowa lista obiektów typu Koszyk
     */
    @ModelAttribute("koszyk")
    public List<Koszyk> utworzKoszyk() {
        return new ArrayList<>();
    }

    /**
     * Metoda obsługująca żądanie HTTP GET na endpoint /koszyk.
     * Wylicza sumę wartości wszystkich pozycji w koszyku i dodaje ją do modelu.
     *
     * @param model   obiekt Model do przekazania danych do widoku
     * @param koszyk  lista obiektów typu Koszyk przechowująca pozycje w koszyku
     * @return nazwa widoku do wyrenderowania (koszyk)
     */
    @GetMapping("/koszyk")
    public String pokazKoszyk(Model model, @ModelAttribute("koszyk") List<Koszyk> koszyk) {
        double sumaWartosci = koszyk.stream()
                .mapToDouble(p -> p.getDanie().getCena() * p.getIlosc())
                .sum();
        model.addAttribute("sumaWartosci", sumaWartosci);
        return "koszyk";
    }

    /**
     * Metoda obsługująca żądanie HTTP POST na endpoint /zaplac.
     * Czyści koszyk i kończy sesję, przekierowując użytkownika na stronę płatności.
     *
     * @param koszyk         lista obiektów typu Koszyk przechowująca pozycje w koszyku
     * @param sessionStatus  obiekt SessionStatus do zarządzania statusem sesji
     * @return przekierowanie na endpoint /platnosc po zakończeniu operacji
     */
    @PostMapping("/zaplac")
    public String zaplac(@ModelAttribute("koszyk") List<Koszyk> koszyk, SessionStatus sessionStatus) {
        koszyk.clear();
        sessionStatus.setComplete();
        return "redirect:/platnosc";
    }

    /**
     * Metoda obsługująca żądanie HTTP POST na endpoint /usunZKoszyka.
     * Usuwa pozycję z koszyka na podstawie identyfikatora dania.
     *
     * @param id      identyfikator dania do usunięcia z koszyka
     * @param koszyk  lista obiektów typu Koszyk przechowująca pozycje w koszyku
     * @return przekierowanie na endpoint /koszyk po zakończeniu operacji
     */
    @PostMapping("/usunZKoszyka")
    public String usunZKoszyka(@RequestParam Long id, @ModelAttribute("koszyk") List<Koszyk> koszyk) {
        koszyk.removeIf(pozycja -> pozycja.getDanie().getId().equals(id));
        return "redirect:/koszyk";
    }

    /**
     * Metoda obsługująca żądanie HTTP POST na endpoint /dodajDoKoszyka.
     * Dodaje danie do koszyka lub zwiększa jego ilość, jeśli danie już istnieje w koszyku.
     *
     * @param id      identyfikator dania do dodania do koszyka
     * @param ilosc   ilość dania do dodania do koszyka
     * @param koszyk  lista obiektów typu Koszyk przechowująca pozycje w koszyku
     * @return przekierowanie na endpoint /dania po zakończeniu operacji
     */
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
