package com.example.springBoot.service;

import com.example.springBoot.entity.Karta;
import org.springframework.stereotype.Service;

@Service
public class KartaServiceImpl implements KartaService{

    /**
     * Metoda sprawdza, czy podane dane karty płaniczej są poprawne.
     * @param karta Dane karty przekazane do walidacji.
     * @return 1 - walidacja przebiegła pomyślnie
     * -1 - walidacja przebiegła niepomyślnie
     */
    @Override
    public int walidacjaKarty(Karta karta) {

        try {
            if (!String.valueOf(karta.getCVV()).matches("\\d{3}")) return -1;
            else if (!karta.getNumerKarty().matches("\\d{13,16}")) return -1;
            else if (!karta.getDanePosiadacza().matches("^[a-zA-Z \\-.']*$") ||
                    karta.getDanePosiadacza().length() == 0) return -1;
        }
        catch (NullPointerException e){
            return -1;
        }
        return 1;
    }
}
