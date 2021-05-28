package com.j4ltechnologies.sb.ormhbm.services.impls;

import com.j4ltechnologies.sb.ormhbm.models.Album;
import com.j4ltechnologies.sb.ormhbm.repositories.AlbumRepository;
import com.j4ltechnologies.sb.ormhbm.services.IAlbumService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Classe AlbumService, créée le 23/05/2021 à 11:41
 * Author: Joachim Zadi
 * Version: 1.0 du 23/05/2021
 */
@Service
public class AlbumService implements IAlbumService {

    private final AlbumRepository repository;

    public AlbumService(AlbumRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<Album> allAlbums() {
        Set<Album> albums = new HashSet<>();
        Iterable<Album> albumIterable = repository.findAll();
        albumIterable.forEach(albums::add);
        return albums;
    }

    @Override
    public Album findByTitre(String titre) {
        return repository.findByTitre(titre);
    }

    @Override
    public Album addAlbum(Album album) {
        Set<Album> albums = allAlbums();
        boolean resultat = !allAlbums().contains(album);
        if (!allAlbums().contains(album)) {
            return repository.save(album);
        }
        return findByTitre(album.getTitre());
    }
}