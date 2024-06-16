/**
 * Klasa reprezentująca danie w systemie cateringowym.
 */
package com.catering.cateringapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Encja JPA reprezentująca danie w bazie danych.
 */
@Entity
public class Danie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nazwa;
    private String opis;
    private Double cena;

    /**
     * Zwraca identyfikator dania.
     *
     * @return identyfikator dania
     */
    public Long getId() {
        return id;
    }

    /**
     * Ustawia identyfikator dania.
     *
     * @param id identyfikator dania
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Zwraca nazwę dania.
     *
     * @return nazwa dania
     */
    public String getNazwa() {
        return nazwa;
    }

    /**
     * Ustawia nazwę dania.
     *
     * @param nazwa nazwa dania
     */
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    /**
     * Zwraca opis dania.
     *
     * @return opis dania
     */
    public String getOpis() {
        return opis;
    }

    /**
     * Ustawia opis dania.
     *
     * @param opis opis dania
     */
    public void setOpis(String opis) {
        this.opis = opis;
    }

    /**
     * Zwraca cenę dania.
     *
     * @return cena dania
     */
    public Double getCena() {
        return cena;
    }

    /**
     * Ustawia cenę dania.
     *
     * @param cena cena dania
     */
    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Danie() {}

    public Danie(String nazwa, String opis, Double cena) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.cena = cena;
    }

}
