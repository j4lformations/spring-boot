package com.j4ltechnologies.sb.ormhbm.services;

import com.j4ltechnologies.sb.ormhbm.models.Album;

import java.util.Set;

/**
 * Classe IAlbumService, créée le 23/05/2021 à 11:34
 * Author: Joachim Zadi
 * Version: 1.0 du 23/05/2021
 */
public interface IAlbumService {
    Set<Album> allAlbums();

    Album findByTitre(String titre);

    Album addAlbum(Album album);
}
