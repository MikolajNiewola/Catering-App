package com.catering.cateringapp.model;

/**
 * Model reprezentujący pozycję w koszyku.
 */
public class Koszyk {
    private Danie danie;
    private int ilosc;

    /**
     * Zwraca danie w koszyku.
     *
     * @return danie w koszyku
     */
    public Danie getDanie() {
        return danie;
    }

    /**
     * Ustawia danie w koszyku.
     *
     * @param danie danie do ustawienia w koszyku
     */
    public void setDanie(Danie danie) {
        this.danie = danie;
    }

    /**
     * Zwraca ilość dania w koszyku.
     *
     * @return ilość dania w koszyku
     */
    public int getIlosc() {
        return ilosc;
    }

    /**
     * Ustawia ilość dania w koszyku.
     *
     * @param ilosc ilość do ustawienia w koszyku
     */
    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
}