package com.example.springBoot.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "kurier")
public class Kurier {

    public Kurier() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kurier")
    private int idKurier;

    @Column(name = "login")
    private String login;

    @Column(name = "haslo")
    private String haslo;

    @Column(name = "numer_dowodu_osobistego")
    private String numerDowoduOsobistego;

    @Column(name = "numer_prawa_jazdy")
    private String numerPrawaJazdy;

    @Column(name = "nip")
    private int NIP;

    @Column(name = "numer_konta_bankowego")
    private int numerKontaBankowego;

    @Column(name = "status")
    private int status;

    @Column(name = "akceptacja")
    private boolean akceptacja;

    @Column(name = "numer_telefonu")
    private String  numerTelefonu;

    @Column(name = "lokalizacja")
    private String lokalizacja;

    @Column(name = "ocena")
    private double ocena;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kurier")
    private Set<Pojazd> pojazdy;

    public int getIdKurier() {
        return idKurier;
    }

    public void setIdKurier(int idKurier) {
        this.idKurier = idKurier;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getNumerDowoduOsobistego() {
        return numerDowoduOsobistego;
    }

    public void setNumerDowoduOsobistego(String numerDowoduOsobistego) {
        this.numerDowoduOsobistego = numerDowoduOsobistego;
    }

    public String getNumerPrawaJazdy() {
        return numerPrawaJazdy;
    }

    public void setNumerPrawaJazdy(String numerPrawaJazdy) {
        this.numerPrawaJazdy = numerPrawaJazdy;
    }

    public int getNIP() {
        return NIP;
    }

    public void setNIP(int NIP) {
        this.NIP = NIP;
    }

    public int getNumerKontaBankowego() {
        return numerKontaBankowego;
    }

    public void setNumerKontaBankowego(int numerKontaBankowego) {
        this.numerKontaBankowego = numerKontaBankowego;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isAkceptacja() {
        return akceptacja;
    }

    public void setAkceptacja(boolean akceptacja) {
        this.akceptacja = akceptacja;
    }

    public String getNumerTelefonu() {
        return numerTelefonu;
    }

    public void setNumerTelefonu(String numerTelefonu) {
        this.numerTelefonu = numerTelefonu;
    }

    public String getLokalizacja() {
        return lokalizacja;
    }

    public void setLokalizacja(String lokalizacja) {
        this.lokalizacja = lokalizacja;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    @Override
    public String toString() {
        return "Kurier{" +
                "login='" + login + '\'' +
                ", haslo='" + haslo + '\'' +
                ", numerDowoduOsobistego='" + numerDowoduOsobistego + '\'' +
                ", numerPrawaJazdy='" + numerPrawaJazdy + '\'' +
                ", NIP=" + NIP +
                ", numerKontaBankowego=" + numerKontaBankowego +
                ", status=" + status +
                ", akceptacja=" + akceptacja +
                ", numerTelefonu='" + numerTelefonu + '\'' +
                ", lokalizacja='" + lokalizacja + '\'' +
                ", ocena=" + ocena +
                '}';
    }
}
