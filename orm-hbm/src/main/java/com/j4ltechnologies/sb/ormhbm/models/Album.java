package com.j4ltechnologies.sb.ormhbm.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Classe Album, créée le 21/05/2021 à 18:28
 * Author: Joachim Zadi
 * Version: 1.0 du 21/05/2021
 */
@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Album extends BaseEntity {

    @Column(nullable = false, unique = true, length = 100)
    String titre;

    LocalDate dds;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MUSICIEN_ID")
    Musicien musicien;

    public Album(String titre, LocalDate dds) {
        this.titre = titre;
        this.dds = dds;
        musicien = new Musicien();
    }

    public Album() {
        this(null, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Album album = (Album) o;

        return new EqualsBuilder().append(titre, album.titre).append(musicien, album.musicien).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(titre).append(musicien).toHashCode();
    }

    @Override
    public String toString() {
        return "Album[" + titre + ", sortie le " + dds + ", par " + musicien.getPrenom() + " " + musicien.getNom() + "]";
    }
}