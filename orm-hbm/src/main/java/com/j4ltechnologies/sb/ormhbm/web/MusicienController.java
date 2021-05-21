package com.j4ltechnologies.sb.ormhbm.web;

import com.j4ltechnologies.sb.ormhbm.services.IMusicienService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
