package com.j4ltechnologies.sb.ormhbm.repositories;

import com.j4ltechnologies.sb.ormhbm.models.Album;
import org.springframework.data.repository.CrudRepository;

/**
 * Classe AlbumRepository, créée le 23/05/2021 à 11:33
 * Author: Joachim Zadi
 * Version: 1.0 du 23/05/2021
 */
public interface AlbumRepository extends CrudRepository<Album, Integer> {
    Album findByTitre(String titre);
}