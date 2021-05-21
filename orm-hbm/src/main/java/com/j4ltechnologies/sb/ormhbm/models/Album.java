package com.j4ltechnologies.sb.ormhbm.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

/**
 * Classe Album, créée le 21/05/2021 à 18:28
 * Author: Joachim Zadi
 * Version: 1.0 du 21/05/2021
 */
@Entity
@Getter
@Setter
@ToString(of = {"titre"})
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"titre"})
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Album extends BaseEntity {

    @Column(nullable = false, unique = true, length = 100)
    String titre;

    LocalDate dds;

    @ManyToOne
    @JoinColumn(name = "musicienId")
    Musicien musicien;
}
