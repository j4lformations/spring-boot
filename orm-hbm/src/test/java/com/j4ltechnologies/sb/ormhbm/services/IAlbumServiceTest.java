package com.j4ltechnologies.sb.ormhbm.services;

import com.j4ltechnologies.sb.ormhbm.models.Album;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe IAlbumServiceTest, créée le 27/05/2021 à 12:48
 * Author: Joachim Zadi
 * Version: 1.0 du 27/05/2021
 */
@SpringBootTest
class IAlbumServiceTest {

    @Autowired
    private IAlbumService service;

    @Test
    void loadContext() {
        assertNotNull(service);
    }

    @Test
    void allAlbums() {
        assertEquals(service.allAlbums().size(), 4);
        System.out.println(service.allAlbums());
    }

    @Test
    void findByTitre() {
        Album album = service.findByTitre("Battle Studies");
        assertNotNull(album);
        assertEquals(album.getId(), 2);
    }
}