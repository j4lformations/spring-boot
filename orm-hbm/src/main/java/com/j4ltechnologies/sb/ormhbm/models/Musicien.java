package com.j4ltechnologies.sb.ormhbm.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe Musicien, créée le 21/05/2021 à 17:48
 * Author: Joachim Zadi
 * Version: 1.0 du 21/05/2021
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = {"prenom", "nom"})
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"prenom", "nom"}))
public class Musicien extends BaseEntity {

    @Column(length = 30, nullable = false)
    @NonNull
    String prenom;

    @Column(length = 20, nullable = false)
    @NonNull
    String nom;

    LocalDate ddn;

    @Transient
    Integer age;

    @OneToMany(mappedBy = "musicien", cascade = CascadeType.ALL)
    Set<Album> albums = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "MUSICIEN_INSTRUMENT",
            joinColumns = {
                    @JoinColumn(name = "MUSICIEN_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "INSTRUMENT_ID")
            }
    )
    Set<Instrument> instruments = new HashSet<>();

    @PostLoad
    private void init() {
        age = ddn.until(LocalDate.now()).getYears();
    }

    public void add(Album album) {
        if (albums == null) {
            albums = new HashSet<>();
        }
        albums.add(album);
    }

    public void add(Instrument instrument) {
        if (instruments == null) {
            instruments = new HashSet<>();
        }
        instruments.add(instrument);
        instrument.getMusiciens().add(this);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" +
                "id: " + getId() + ", " +
                "prenom: " + getPrenom() + ", " +
                "nom: " + getNom() + ", " +
                "age: " + getAge() + " ans]";
    }
}
