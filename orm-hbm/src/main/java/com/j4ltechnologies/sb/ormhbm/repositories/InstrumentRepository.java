package com.j4ltechnologies.sb.ormhbm.repositories;

import com.j4ltechnologies.sb.ormhbm.models.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Classe InstrumentRepository, créée le 21/05/2021 à 19:22
 * Author: Joachim Zadi
 * Version: 1.0 du 21/05/2021
 */
public interface InstrumentRepository extends JpaRepository<Instrument, String> {
}
