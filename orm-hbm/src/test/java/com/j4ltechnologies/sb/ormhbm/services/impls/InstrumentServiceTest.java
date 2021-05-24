package com.j4ltechnologies.sb.ormhbm.services.impls;

import com.j4ltechnologies.sb.ormhbm.models.Instrument;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Classe InstrumentServiceTest, créée le 23/05/2021 à 17:40
 * Author: Joachim Zadi
 * Version: 1.0 du 23/05/2021
 */
@SpringBootTest
class InstrumentServiceTest {

    @Autowired
    private InstrumentService service;

    @Test
    void loadContext() {
        assertNotNull(service);
    }

    @Test
    void allInstruments() {
        assertEquals(service.allInstruments().size(),2);
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
        assertEquals(service.allInstruments().size(),1);

        instrument = new Instrument("Piano");
        service.addInstrument(instrument);
        assertEquals(service.allInstruments().size(),2);

        service.addInstrument(instrument);
        assertEquals(service.allInstruments().size(),2);
    }
}