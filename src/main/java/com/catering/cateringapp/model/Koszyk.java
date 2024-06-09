package com.catering.cateringapp.model;

public class Koszyk {
    private Danie danie;
    private int ilosc;

    public Danie getDanie() {
        return danie;
    }
    public void setDanie(Danie danie) {
        this.danie = danie;
    }

    public int getIlosc() {
        return ilosc;
    }
    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
}
