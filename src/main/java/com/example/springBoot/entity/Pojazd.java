package com.example.springBoot.entity;

import javax.persistence.*;

@Entity
@Table(name = "pojazd")
public class Pojazd {

    public Pojazd() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pojazd")
    private int idPojazd;

    @ManyToOne
    @JoinColumn(name = "id_kurier")
    private Kurier kurier;

    @Column(name = "marka")
    private String marka;

    @Column(name = "model")
    private String model;

    @Column(name = "rocznik")
    private int rocznik;

    @Column(name = "numer_ubezpieczenia")
    private int numerUbezpieczenia;

    @Column(name = "wymiarx")
    private int wymiarX;

    @Column(name = "wymiary")
    private int wymiarY;

    @Column(name = "wymiarz")
    private int wymiarZ;

    @Column(name = "ladownosc")
    private int ladownosc;

    @Column(name = "cennik")
    private int cennik;

    @Column(name = "image_url")
    private String imageUrl;

    public int getIdPojazd() {
        return idPojazd;
    }

    public void setIdPojazd(int idPojazd) {
        this.idPojazd = idPojazd;
    }

    public Kurier getKurier() {
        return kurier;
    }

    public void setKurier(Kurier kurier) {
        this.kurier = kurier;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRocznik() {
        return rocznik;
    }

    public void setRocznik(int rocznik) {
        this.rocznik = rocznik;
    }

    public int getNumerUbezpieczenia() {
        return numerUbezpieczenia;
    }

    public void setNumerUbezpieczenia(int numerUbezpieczenia) {
        this.numerUbezpieczenia = numerUbezpieczenia;
    }

    public int getWymiarX() {
        return wymiarX;
    }

    public void setWymiarX(int wymiarX) {
        this.wymiarX = wymiarX;
    }

    public int getWymiarY() {
        return wymiarY;
    }

    public void setWymiarY(int wymiarY) {
        this.wymiarY = wymiarY;
    }

    public int getWymiarZ() {
        return wymiarZ;
    }

    public void setWymiarZ(int wymiarZ) {
        this.wymiarZ = wymiarZ;
    }

    public int getLadownosc() {
        return ladownosc;
    }

    public void setLadownosc(int ladownosc) {
        this.ladownosc = ladownosc;
    }

    public int getCennik() {
        return cennik;
    }

    public void setCennik(int cennik) {
        this.cennik = cennik;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Pojazd{" +
                "id_pojazd=" + idPojazd +
                ", kurier=" + kurier +
                ", marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", rocznik=" + rocznik +
                ", numerUbezpieczenia=" + numerUbezpieczenia +
                ", wymiarX=" + wymiarX +
                ", wymiarY=" + wymiarY +
                ", wymiarZ=" + wymiarZ +
                ", ladownosc=" + ladownosc +
                ", cennik=" + cennik +
                '}';
    }
}
