package com.example.springBoot.service;

import com.example.springBoot.entity.Karta;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KartaServiceImplTest {

    private KartaService kartaService;
    private Karta karta;

    @BeforeEach
    void setUp(){
        kartaService = new KartaServiceImpl();
        karta = new Karta("John Doe", "1234567890101010",
                10, 2020, 123);
    }

    @Test
    void walidacjaKartyPoprawna(){
        assertEquals(1, kartaService.walidacjaKarty(karta));
    }

    @Test
    void walidacjaKartyCVV() {
        karta.setCVV(0);
        assertEquals(-1, kartaService.walidacjaKarty(karta));
        karta.setCVV(12398);
        assertEquals(-1, kartaService.walidacjaKarty(karta));
    }

    @Test
    void walidacjaKartyDanePosiadacza(){
        karta.setDanePosiadacza("");
        assertEquals(-1, kartaService.walidacjaKarty(karta));
        karta.setDanePosiadacza("123456789");
        assertEquals(-1, kartaService.walidacjaKarty(karta));
        karta.setDanePosiadacza(null);
        assertEquals(-1, kartaService.walidacjaKarty(karta));
        karta.setDanePosiadacza("Joh&n D*e");
        assertEquals(-1, kartaService.walidacjaKarty(karta));
    }

    @Test
    void walidacjaKartyNumerKarty(){
        karta.setNumerKarty("Numer karty");
        assertEquals(-1, kartaService.walidacjaKarty(karta));
        karta.setNumerKarty("123456789101");
        assertEquals(-1, kartaService.walidacjaKarty(karta));
        karta.setNumerKarty("1234567898765432123456");
        assertEquals(-1, kartaService.walidacjaKarty(karta));
        karta.setNumerKarty("6712367^767*77");
        assertEquals(-1, kartaService.walidacjaKarty(karta));
        karta.setNumerKarty("");
        assertEquals(-1, kartaService.walidacjaKarty(karta));
    }

}
