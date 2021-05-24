package com.j4ltechnologies.sb.ormhbm.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Classe Album, créée le 21/05/2021 à 18:28
 * Author: Joachim Zadi
 * Version: 1.0 du 21/05/2021
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(of = {"titre"})
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Album extends BaseEntity {

    @Column(nullable = false, unique = true, length = 100)
    @NonNull
    String titre;

    LocalDate dds;

    @ManyToOne
    @JoinColumn(name = "MUSICIEN_ID")
    @JsonIgnore
    Musicien musicien;

    public Album(@NonNull String titre, LocalDate dds) {
        this.titre = titre;
        this.dds = dds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Album album = (Album) o;
        return titre.equalsIgnoreCase(album.titre) && musicien.equals(album.musicien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titre, musicien);
    }
}