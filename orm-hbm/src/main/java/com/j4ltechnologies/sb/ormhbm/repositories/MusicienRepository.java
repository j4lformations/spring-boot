package com.j4ltechnologies.sb.ormhbm.repositories;

import com.j4ltechnologies.sb.ormhbm.models.Musicien;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * Classe MusicienRepository, créée le 21/05/2021 à 19:20
 * Author: Joachim Zadi
 * Version: 1.0 du 21/05/2021
 */
public interface MusicienRepository extends CrudRepository<Musicien, Integer> {
    Musicien findByPrenomAndNom(String prenom, String nom);

    @Query("select distinct m from Musicien m left join fetch m.albums a left join fetch m.instruments i")
    Collection<Musicien> findAllWithAlbum();
}