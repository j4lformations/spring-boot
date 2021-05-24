package com.j4ltechnologies.sb.ormhbm.services;

import com.j4ltechnologies.sb.ormhbm.models.Instrument;

import java.util.Set;

/**
 * Classe IInstrumentService, créée le 23/05/2021 à 14:26
 * Author: Joachim Zadi
 * Version: 1.0 du 23/05/2021
 */
public interface IInstrumentService {
    Set<Instrument> allInstruments();

    Instrument findByNom(String nom);

    Instrument addInstrument(Instrument instrument);
}
