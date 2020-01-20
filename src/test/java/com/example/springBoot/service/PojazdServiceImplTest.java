package com.example.springBoot.service;

import com.example.springBoot.entity.Pojazd;
import com.example.springBoot.repository.PojazdRepository;
import com.fasterxml.jackson.databind.node.POJONode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PojazdServiceImplTest {

    private PojazdRepository pojazdRepository;
    private PojazdService pojazdService;
    private List<Pojazd> expectedList;


    @BeforeEach
    void setUp() {
        pojazdRepository = mock(PojazdRepository.class);
        pojazdService = new PojazdServiceImpl(pojazdRepository);
    }

    @Test
    void findAllSize() {
        List<Pojazd> pojazdList = new ArrayList<>();
        pojazdList.add(new Pojazd());
        pojazdList.add(new Pojazd());
        when(pojazdRepository.findAll()).thenReturn(pojazdList);

        expectedList = pojazdService.findAll();
        assertEquals(2, expectedList.size());
        pojazdList.remove(1);
        assertEquals(1, expectedList.size());

    }

    @Test
    void findAllEmpty() {
        List<Pojazd> pojazdList = new ArrayList<>();
        when(pojazdRepository.findAll()).thenReturn(pojazdList);

        expectedList = pojazdService.findAll();
        assertTrue(expectedList.isEmpty());

        pojazdList.add(new Pojazd());
        assertFalse(expectedList.isEmpty());
    }

    @Test
    void findAllContains() {
        List<Pojazd> pojazdList = new ArrayList<>();
        when(pojazdRepository.findAll()).thenReturn(pojazdList);

        Pojazd pojazd = new Pojazd();
        pojazdList.add(new Pojazd());
        pojazdList.add(pojazd);
        assertEquals(pojazd, pojazdService.findAll().get(1));

        pojazdList.remove(1);
        pojazdList.add(new Pojazd());
        assertNotEquals(pojazd, pojazdService.findAll().get(1));
    }
}
