package com.j4ltechnologies.sb.ormhbm.services;

import com.j4ltechnologies.sb.ormhbm.models.Album;
import com.j4ltechnologies.sb.ormhbm.models.Musicien;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Classe IMusicienServiceTest, créée le 27/05/2021 à 13:51
 * Author: Joachim Zadi
 * Version: 1.0 du 27/05/2021
 */
@SpringBootTest
class IMusicienServiceTest {

    private final Logger logger = LoggerFactory.getLogger(IMusicienServiceTest.class);

    @Autowired
    private IMusicienService musicienService;

    @Autowired
    private IAlbumService albumService;

    @Autowired
    private IInstrumentService instrumentService;

    @Test
    void loadContext() {
        assertNotNull(musicienService);
        assertNotNull(albumService);
        assertNotNull(instrumentService);
    }

    @Test
    void findAllMusiciens() {
        Set<Musicien> musiciens = musicienService.findAllMusiciens();
        assertNotNull(musiciens);
        assertEquals(musiciens.size(), 4);
        logger.info(musiciens.toString());
    }

    @Test
    void findAllWithAlbum() {
        Collection<Musicien> musiciens = musicienService.findAllWithAlbum();
        assertNotNull(musiciens);
        assertEquals(musiciens.size(), 4);
        System.out.println(musiciens);
        musiciens.forEach(m -> System.out.println(m.getAlbums()));
    }

    @Test
    void findById() {
        Musicien musicien = musicienService.findById(2);
        assertNotNull(musicien);
        assertEquals(musicien.getNom(), "CLAPTON");
        System.out.println(musicien);
    }

    @Test
    void findByPrenomAndNom() {
        Musicien musicien = musicienService.findByPrenomAndNom("Prince", "Nelson");
        assertNotNull(musicien);
        System.out.println(musicien);
    }

    @Test
    void addMusicien() {
        Musicien musicien = new Musicien();
        musicien.setDdn(LocalDate.of(1960, 5, 15));
        musicien.setNom("jackson");
        musicien.setPrenom("mickael");

        musicien = musicienService.addMusicien(musicien);
        assertEquals(musicien.getId(), 5);

        Album album = new Album("Dangerous", LocalDate.of(1991, 11, 26));
        album.setMusicien(musicien);
        album = albumService.addAlbum(album);
        musicien.add(album);

        album = new Album("Thriller", LocalDate.of(1982, 11, 30));
        album.setMusicien(musicien);
        album = albumService.addAlbum(album);
        musicien.add(album);
        assertEquals(musicien.getAlbums().size(), 2);

        logger.info("\n\n" + musicienService.findAllMusiciens());
        logger.info("\n\n" + musicien.getAlbums());
        assertEquals(albumService.allAlbums().size(), 6);
        System.out.println(albumService.allAlbums());
    }

    @Test
    void deleteMusicienById() {
        musicienService.deleteMusicienById(2);
        assertEquals(musicienService.findAllMusiciens().size(), 2);
    }

    @Test
    void updateMusicien() {
        Musicien musicien = musicienService.findById(1);
        assertNotNull(musicien);
        assertEquals("MAYER", musicien.getNom());

        Album album = musicien.getAlbums()
                .stream()
                .filter(a -> a.getTitre().equals("Battle Studies"))
                .findFirst()
                .get();

        musicien.setPrenom("joachim");
        musicien.removeAlbum(album);
        musicienService.updateMusicien(musicien);

        musicienService.findAllMusiciens().forEach(m -> {
            System.out.println();
            System.out.println(m);
            System.out.println();
            System.out.println(m.getAlbums());
        });
    }
}