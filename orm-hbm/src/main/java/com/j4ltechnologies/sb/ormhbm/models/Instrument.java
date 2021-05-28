package com.j4ltechnologies.sb.ormhbm.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
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
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Instrument {

    @Id
    @Column(nullable = false, unique = true, length = 50)
    String nom;

    public Instrument(String nom) {
        this.nom = nom;
        musiciens =  new HashSet<>();
    }

    public Instrument() {
        this(null);
    }

    @ManyToMany(mappedBy = "instruments")
    Set<Musicien> musiciens;

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

    @PostLoad
    @PrePersist
    @PreUpdate
    private void init(){
        nom = StringUtils.capitalize(nom);
    }

    @Override
    public String toString() {
        return nom;
    }
}
