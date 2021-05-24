package com.j4ltechnologies.sb.ormhbm.services.impls;

import com.j4ltechnologies.sb.ormhbm.models.Instrument;
import com.j4ltechnologies.sb.ormhbm.repositories.InstrumentRepository;
import com.j4ltechnologies.sb.ormhbm.services.IInstrumentService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Classe InstrumentService, créée le 23/05/2021 à 14:28
 * Author: Joachim Zadi
 * Version: 1.0 du 23/05/2021
 */
@Service
public class InstrumentService implements IInstrumentService {
    private final InstrumentRepository repository;

    public InstrumentService(InstrumentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<Instrument> allInstruments() {
        Set<Instrument> instruments = new HashSet<>();
        Iterable<Instrument> instrumentIterable = repository.findAll();
        instrumentIterable.forEach(i -> instruments.add(i));
        return instruments;
    }

    @Override
    public Instrument findByNom(String nom) {
        return repository.findByNom(nom);
    }

    @Override
    public Instrument addInstrument(Instrument instrument) {
        Set<Instrument> instruments = allInstruments();
        if (!instruments.contains(instrument)) {
            return repository.save(instrument);
        }
        return findByNom(instrument.getNom());
    }
}