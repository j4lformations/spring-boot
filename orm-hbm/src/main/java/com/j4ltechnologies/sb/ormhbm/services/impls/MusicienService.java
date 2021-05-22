package com.j4ltechnologies.sb.ormhbm.services.impls;

import com.j4ltechnologies.sb.ormhbm.models.Musicien;
import com.j4ltechnologies.sb.ormhbm.repositories.MusicienRepository;
import com.j4ltechnologies.sb.ormhbm.services.IMusicienService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Musicien> findAll() {
        List<Musicien> musiciens = new ArrayList<>();
        Iterable<Musicien> liste = musicienRepository.findAll();
        liste.forEach(m -> musiciens.add(m));
        return musiciens;
    }

    @Override
    public Collection<Musicien> findAllWithAlbum() {
        return musicienRepository.findAllWithAlbum();
    }

    @Override
    public Musicien findById(Integer id) {
        return musicienRepository.findById(id).orElse(null);
    }

    @Override
    public Musicien findByPrenomAndNom(String prenom, String nom) {
        return musicienRepository.findByPrenomAndNom(prenom, nom);
    }

    @Override
    public void addMusicien(Musicien musicien) {
        musicienRepository.save(musicien);
    }

    @Override
    public void deleteMusicienById(Integer id) {
        musicienRepository.deleteById(id);
    }

    @Override
    public void updateMusicien(Musicien musicien) {
        Optional<Musicien> oldMusicien = musicienRepository.findById(musicien.getId());
        if (null != oldMusicien) {
            musicienRepository.save(musicien);
        }
    }
}
