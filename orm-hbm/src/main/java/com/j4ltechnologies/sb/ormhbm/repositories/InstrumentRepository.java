package com.j4ltechnologies.sb.ormhbm.repositories;

import com.j4ltechnologies.sb.ormhbm.models.Instrument;
import org.springframework.data.repository.CrudRepository;

/**
 * Classe InstrumentRepository, créée le 23/05/2021 à 13:55
 * Author: Joachim Zadi
 * Version: 1.0 du 23/05/2021
 */
public interface InstrumentRepository extends CrudRepository<Instrument, String> {
    Instrument findByNom(String nom);
}
