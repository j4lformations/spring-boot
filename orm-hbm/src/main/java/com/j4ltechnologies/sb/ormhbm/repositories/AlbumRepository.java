package com.j4ltechnologies.sb.ormhbm.repositories;

import com.j4ltechnologies.sb.ormhbm.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Classe AlbumRepository, créée le 21/05/2021 à 19:21
 * Author: Joachim Zadi
 * Version: 1.0 du 21/05/2021
 */
public interface AlbumRepository extends JpaRepository<Album, Integer> {
}
