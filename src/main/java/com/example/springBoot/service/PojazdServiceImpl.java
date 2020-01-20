package com.example.springBoot.service;

import com.example.springBoot.repository.PojazdRepository;
import com.example.springBoot.entity.Pojazd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PojazdServiceImpl implements PojazdService{

    private PojazdRepository pojazdRepository;

    @Autowired
    public PojazdServiceImpl(PojazdRepository pojazdRepository) {
        this.pojazdRepository = pojazdRepository;
    }

    /**
     * @return lista wszystkich pojazdów kurierów dostępnych w bazie
     */
    @Override
    public List<Pojazd> findAll() {
        return pojazdRepository.findAll();
    }


    /**
     * Metada filtrująca kurieów wg przekazanych kryterów
     * @param pojazd Kryterium filtru
     * @return lista pojazdów kurierów
     */
    @Override
    public List<Pojazd> findAllByFilter(Pojazd pojazd) {
        List<Pojazd> pojazdy = pojazdRepository.findAll();

        if (pojazd.getKurier().getLokalizacja().equals("")){
            return pojazdy.stream()
                    .filter(c -> c.getCennik() <= pojazd.getCennik())
                    .filter(o -> o.getKurier().getOcena() >= pojazd.getKurier().getOcena())
                    .filter(w -> w.getLadownosc() >= pojazd.getLadownosc())
                    .collect(Collectors.toList());
        }
        return pojazdy.stream()
                .filter(c -> c.getCennik() <= pojazd.getCennik())
                .filter(o -> o.getKurier().getOcena() >= pojazd.getKurier().getOcena())
                .filter(w -> w.getLadownosc() >= pojazd.getLadownosc())
                .filter(l -> l.getKurier().getLokalizacja().equals(pojazd.getKurier().getLokalizacja()))
                .collect(Collectors.toList());
    }

    /**
     * Metoda wyszukuje dane wybranego pojazdu kuriera.
     * @param theId Identyfikator pojazdu kuriera.
     * @return informacje dotyczące pojazdu kuriera
     */
    @Override
    public Pojazd findById(int theId) {
        Optional<Pojazd> result = pojazdRepository.findById(theId);
        return result.isPresent() ? result.get() : null;
    }

    /**
     * Zwraca lista kurierów spełniające podane kryterium ceny
     * @param cena maksymalna cena do jakiej zostną wyświeleni dostępni kurierzy
     * @return lista pojazdów kurierów
     */
    @Override
    public List<Pojazd> findAllOrderByCennik(int cena) {
        List<Pojazd> pojazdy = pojazdRepository.findAll();
        return pojazdy.stream().filter(c -> c.getCennik() <= cena)
                .collect(Collectors.toList());
    }

    /**
     * @return lista pojazdów kurierów posortowna wg oceny malejąco
     */
    @Override
    public List<Pojazd> findAllOrderByOcena() {
        List<Pojazd> pojazdy = pojazdRepository.findAll();
        Collections.sort(pojazdy, (p1, p2) -> Double.compare(p2.getKurier().getOcena(), p1.getKurier().getOcena()));

        return pojazdy;
    }

    /**
     * @return lista pojazdów kurierów posortowna wg ceny malejąco
     */
    @Override
    public List<Pojazd> findAllOrderByCena() {
        List<Pojazd> pojazdy = pojazdRepository.findAll();
        Collections.sort(pojazdy, (p1, p2) -> Integer.compare(p2.getCennik(), p1.getCennik()));

        return pojazdy;
    }

    /**
     * @return lista pojazdów kurierów posortowna wg ładowności malejąco
     */
    @Override
    public List<Pojazd> findAllOrderByWaga() {
        List<Pojazd> pojazdy = pojazdRepository.findAll();
        Collections.sort(pojazdy, (p1, p2) -> Integer.compare(p2.getLadownosc(), p1.getLadownosc()));

        return pojazdy;
    }
}
