package com.j4ltechnologies.sb.ormhbm.services.impls;

import com.j4ltechnologies.sb.ormhbm.repositories.MusicienRepository;
import com.j4ltechnologies.sb.ormhbm.services.IMusicienService;
import org.springframework.stereotype.Service;

/**
 * Classe MusicienService, créée le 21/05/2021 à 19:26
 * Author: Joachim Zadi
 * Version: 1.0 du 21/05/2021
 */
@Service
public class MusicienService implements IMusicienService {

    private final MusicienRepository musicienRepository;

    public MusicienService(MusicienRepository musicienRepository) {
        this.musicienRepository = musicienRepository;
    }
}
