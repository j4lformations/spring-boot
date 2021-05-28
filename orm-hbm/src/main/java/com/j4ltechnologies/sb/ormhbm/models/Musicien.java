package com.j4ltechnologies.sb.ormhbm.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
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

    @OneToMany(
            mappedBy = "musicien",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.REMOVE, CascadeType.MERGE}
    )
    Set<Album> albums = new HashSet<>();

    @ManyToMany
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

    public Musicien(@NonNull String prenom, @NonNull String nom, LocalDate ddn) {
        this.prenom = prenom;
        this.nom = nom;
        this.ddn = ddn;
    }

    @PostLoad
    @PrePersist
    @PreUpdate
    private void init() {
        prenom = StringUtils.capitalize(prenom);
        nom = nom.toUpperCase();
        age = ddn.until(LocalDate.now()).getYears();
    }

    public void add(Album album) {
        album.setMusicien(this);
        getAlbums().add(album);
    }

    public void removeAlbum(Album album) {
        getAlbums().remove(album);
    }

    public void add(Instrument instrument) {
        instrument.getMusiciens().add(this);
        instruments.add(instrument);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Musicien musicien = (Musicien) o;

        return new EqualsBuilder().append(prenom, musicien.prenom).append(nom, musicien.nom).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(prenom).append(nom).toHashCode();
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
