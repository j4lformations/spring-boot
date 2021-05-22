package com.j4ltechnologies.sb.ormhbm.web;

import com.j4ltechnologies.sb.ormhbm.models.Album;
import com.j4ltechnologies.sb.ormhbm.models.Musicien;
import com.j4ltechnologies.sb.ormhbm.services.IMusicienService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * Classe MusicienController, créée le 21/05/2021 à 19:35
 * Author: Joachim Zadi
 * Version: 1.0 du 21/05/2021
 */
@RestController
@RequestMapping("api/musiciens")
public class MusicienController {

    private final IMusicienService musicienService;

    public MusicienController(IMusicienService musicienService) {
        this.musicienService = musicienService;
    }

    @GetMapping
    public List<Musicien> getMusiciens() {
        return musicienService.findAll();
    }

    @PostMapping
    public void addMusicien(@RequestBody Musicien musicien) {
        Set<Album> albums = musicien.getAlbums();
        albums.forEach(a -> a.setMusicien(musicien));
        musicienService.addMusicien(musicien);
    }
}