package com.example.springBoot.controller;

import com.example.springBoot.entity.Karta;
import com.example.springBoot.service.KartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/platnosc")
public class PlatnoscController {

    private KartaService kartaService;

    @Autowired
    public PlatnoscController(KartaService kartaService) {
        this.kartaService = kartaService;
    }

    /**
     * Przekierowuje do strony obsługującej płatność,
     * w której dokonywany jest wybór sposobu płatności.
     * @param model Model przekazywany do widoku.
     * @return identyfikator pliku html
     */
    @GetMapping("/wybor")
    public String wyborPlatnosc (Model model){
        return "platnosc";
    }

    /**
     * Przekierowuje do strony obsługującej płatność gotówka.
     * @param model Model przekazywany do widoku.
     * @return identyfikator pliku html
     */
    @GetMapping("/gotowka")
    public String gotowka (Model model){
        return "gotowka";
    }

    /**
     * Przekierowuje do strony obsługującej płatność kartą,
     * przekazuje do modelu puste dane karty, oraz wstepny komunikat
     * powodzenia walidacji.
     * @param model Model przekazywany do widoku.
     * @return identyfikator pliku html
     */
    @GetMapping("/karta")
    public String karta (Model model){
        model.addAttribute("walidacja", 1);
        model.addAttribute("karta", new Karta());
        return "karta";
    }

    /**
     * Zwraca informacje o powodzeniu, lub nie, walidacji karty.
     * @param karta Dane karty podane w widoku.
     * @param model Model przekazywany do widoku.
     * @return identyfikator pliku html
     */
    @GetMapping("/karta/zaplac")
    public String kartaZaplac (@ModelAttribute("karta") Karta karta,
                               Model model){
        model.addAttribute("walidacja", kartaService.walidacjaKarty(karta));
        model.addAttribute("karta", karta);
        return "karta";
    }
}
