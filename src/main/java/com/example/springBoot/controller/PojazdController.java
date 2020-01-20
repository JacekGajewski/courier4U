package com.example.springBoot.controller;

import com.example.springBoot.entity.Pojazd;
import com.example.springBoot.service.PojazdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pojazdy")
public class PojazdController {

    private final PojazdService pojazdService;

    @Autowired
    public PojazdController(PojazdService pojazdService) {
        this.pojazdService = pojazdService;
    }

    /**
     * Wyświetla listę dostępnycb kurierów/pojazdów
     * @param model Model przekazywany do widoku
     * @return identyfikator pliku html
     */
    @GetMapping("/list")
    public String list(Model model){

        model.addAttribute("pojazdy", pojazdService.findAll());

        Pojazd pojazd = new Pojazd();
        model.addAttribute("pojazd", pojazd);

        return "pojazdy-lista";
    }

    /**
     * Wyświetla szczegóły wybranego pojazdu kuriera
     * @param theId Identyfikator pojazdu kuriera
     * @param model Model przekazywany do widoku
     * @return identyfikator pliku html
     */
    @GetMapping("/showDetails")
    public String showDetails(@RequestParam("pojazdId") int theId,
                                    Model model){

        Pojazd pojazd = pojazdService.findById(theId);

        model.addAttribute("pojazd", pojazd);

        return "pojazd-form";
    }

    /**
     * Wyświetla listę dostępnycb kurierów/pojazdów posortowanych wg oceny
     * od najwyższej do najniższej
     * @param model Model przekazywany do widoku
     * @return identyfikator pliku html
     */
    @GetMapping("/sortOcena")
    public String sortOcena(Model model){

        model.addAttribute("pojazdy", pojazdService.findAllOrderByOcena());

        Pojazd pojazd = new Pojazd();
        model.addAttribute("pojazd", pojazd);

        return "pojazdy-lista";
    }

    /**
     * Wyświetla listę dostępnycb kurierów/pojazdów posortowanych wg ceny
     * od najwyższej do najniższej
     * @param model Model przekazywany do widoku
     * @return identyfikator pliku html
     */
    @GetMapping("/sortCena")
    public String sorCena(Model model){

        model.addAttribute("pojazdy", pojazdService.findAllOrderByCena());

        Pojazd pojazd = new Pojazd();
        model.addAttribute("pojazd", pojazd);

        return "pojazdy-lista";
    }

    /**
     * Wyświetla listę dostępnycb kurierów/pojazdów posortowanych wg ładowności
     * od najwyższej do najniższej
     * @param model Model przekazywany do widoku
     * @return identyfikator pliku html
     */
    @GetMapping("/sortWaga")
    public String sortWaga(Model model){

        model.addAttribute("pojazdy", pojazdService.findAllOrderByWaga());

        Pojazd pojazd = new Pojazd();
        model.addAttribute("pojazd", pojazd);

        return "pojazdy-lista";
    }

    /**
     * Wyświetla listę dostępnycb kurierów/pojazdów posortowanych wg wybranego filtra
     * @param model Model przekazywany do widoku
     * @param pojazd Dane na podstawie, których jest dokonywana filtracja
     * @return identyfikator pliku html
     */
    @GetMapping("/search")
    public String search(@ModelAttribute("employee") Pojazd pojazd,
                          Model model){

        model.addAttribute("pojazd", pojazd);
        model.addAttribute("pojazdy", pojazdService.findAllByFilter(pojazd));

        return "pojazdy-lista";
    }

    /**
     * Przekierowuje do strony obsługującej płatność
     * @param model Model przekazywany do widoku
     * @return identyfikator pliku html obsługującego płatność
     */
    @GetMapping("/platnosc")
    public String platnosc(Model model){
        return "platnosc";
    }
}
