package com.j4ltechnologies.sb.ormhbm.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Classe Instrument, créée le 21/05/2021 à 18:41
 * Author: Joachim Zadi
 * Version: 1.0 du 21/05/2021
 */
@Entity
@Getter
@Setter
@ToString(of = {"nom"})
@EqualsAndHashCode(of = {"nom"})
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Instrument {

    @Id
    @Column(nullable = false, unique = true)
    String nom;

    @ManyToMany(mappedBy = "instruments")
    List<Musicien> musiciens;
}
