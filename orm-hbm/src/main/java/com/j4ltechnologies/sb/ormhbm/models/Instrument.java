package com.j4ltechnologies.sb.ormhbm.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Classe Instrument, créée le 21/05/2021 à 18:41
 * Author: Joachim Zadi
 * Version: 1.0 du 21/05/2021
 */
@Entity
@Getter
@Setter
@ToString(of = {"nom"})
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Instrument {

    @Id
    @Column(nullable = false, unique = true, length = 50)
    @NonNull
    String nom;

    public Instrument(@NonNull String nom) {
        this.nom = nom;
    }

    @ManyToMany(mappedBy = "instruments")
    @JsonIgnore
    Set<Musicien> musiciens = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Instrument that = (Instrument) o;
        return nom.equalsIgnoreCase(that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }
}
