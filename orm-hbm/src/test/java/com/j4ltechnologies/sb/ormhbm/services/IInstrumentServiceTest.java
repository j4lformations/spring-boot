package com.j4ltechnologies.sb.ormhbm.services;

import com.j4ltechnologies.sb.ormhbm.models.Instrument;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Classe IInstrumentServiceTest, créée le 27/05/2021 à 12:40
 * Author: Joachim Zadi
 * Version: 1.0 du 27/05/2021
 */
@SpringBootTest
class IInstrumentServiceTest {

    @Autowired
    private IInstrumentService service;

    @Test
    void loadContext() {
        assertNotNull(service);
    }

    @Test
    void allInstruments() {
        assertEquals(service.allInstruments().size(), 5);
        System.out.println(service.allInstruments());
    }

    @Test
    void findByNom() {
        Instrument instrument = service.findByNom("Piano");
        assertNotNull(instrument);
    }

    @Test
    void addInstrument() {
        Instrument instrument = new Instrument("Guitare");
        service.addInstrument(instrument);
        assertNotNull(service.allInstruments());
        assertEquals(service.allInstruments().size(), 5);

        instrument = new Instrument("orgue");
        instrument = service.addInstrument(instrument);
        assertEquals(service.allInstruments().size(), 6);
        System.out.println(instrument);
    }
}