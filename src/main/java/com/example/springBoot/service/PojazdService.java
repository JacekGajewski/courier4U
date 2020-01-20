package com.example.springBoot.service;

import com.example.springBoot.entity.Kurier;
import com.example.springBoot.entity.Pojazd;

import java.util.List;

public interface PojazdService {

    public List<Pojazd> findAll();

    public List<Pojazd> findAllOrderByOcena();

    public List<Pojazd> findAllOrderByCennik(int cena);

    public Pojazd findById(int theId);


    List<Pojazd> findAllByFilter(Pojazd pojazd);

    List<Pojazd> findAllOrderByCena();

    List<Pojazd> findAllOrderByWaga();
}
