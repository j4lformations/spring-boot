package com.j4ltechnologies.sb.ormhbm.services;

import com.j4ltechnologies.sb.ormhbm.models.Musicien;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Classe MusicienService, créée le 21/05/2021 à 19:24
 * Author: Joachim Zadi
 * Version: 1.0 du 21/05/2021
 */
public interface IMusicienService {

    Set<Musicien> findAllMusiciens();

    Collection<Musicien> findAllWithAlbum();

    Musicien findById(Integer id);

    Musicien findByPrenomAndNom(String prenom, String nom);

    Musicien addMusicien(Musicien musicien);

    void deleteMusicienById(Integer id);

    void updateMusicien(Musicien musicien);
}
