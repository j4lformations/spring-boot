package com.j4ltechnologies.sb.ormhbm.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Classe Musicien, créée le 21/05/2021 à 17:48
 * Author: Joachim Zadi
 * Version: 1.0 du 21/05/2021
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id", "prenom", "nom", "age"})
@EqualsAndHashCode(of = {"prenom", "nom"})
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"prenom", "nom"}))
public class Musicien extends BaseEntity {

    @Column(length = 30, nullable = false)
    String prenom;

    @Column(length = 20, nullable = false)
    String nom;

    LocalDate ddn;

    @Transient
    Integer age;

    @OneToMany(mappedBy = "musicien")
    List<Album> albums;

    @ManyToMany
    List<Instrument> instruments;
}
