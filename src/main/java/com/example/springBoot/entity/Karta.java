package com.example.springBoot.entity;

public class Karta {

    private String danePosiadacza;
    private String numerKarty;
    private int miesiac;
    private int rok;
    private int CVV;

    public Karta() {
    }

    public Karta(String danePosiadacza, String numerKarty, int miesiac, int rok, int CVV) {
        this.danePosiadacza = danePosiadacza;
        this.numerKarty = numerKarty;
        this.miesiac = miesiac;
        this.rok = rok;
        this.CVV = CVV;
    }

    public String getDanePosiadacza() {
        return danePosiadacza;
    }

    public void setDanePosiadacza(String danePosiadacza) {
        this.danePosiadacza = danePosiadacza;
    }

    public String getNumerKarty() {
        return numerKarty;
    }

    public void setNumerKarty(String numerKarty) {
        this.numerKarty = numerKarty;
    }

    public int getMiesiac() {
        return miesiac;
    }

    public void setMiesiac(int miesiac) {
        this.miesiac = miesiac;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }
}
