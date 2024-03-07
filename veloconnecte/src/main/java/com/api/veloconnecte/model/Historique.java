package com.api.veloconnecte.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "historique")
@Getter
@Setter
public class Historique {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur user;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "parcours_id")
    private Parcours parcours;
}
