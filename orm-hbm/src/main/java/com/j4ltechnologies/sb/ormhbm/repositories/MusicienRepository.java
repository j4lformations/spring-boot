package com.j4ltechnologies.sb.ormhbm.repositories;

import com.j4ltechnologies.sb.ormhbm.models.Musicien;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Classe MusicienRepository, créée le 21/05/2021 à 19:20
 * Author: Joachim Zadi
 * Version: 1.0 du 21/05/2021
 */
public interface MusicienRepository extends JpaRepository<Musicien, Integer> {
}
