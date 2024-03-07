package com.api.veloconnecte.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "parcours")
@Getter
@Setter
public class Parcours {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "destination")
    private String destination;

    @Column(name = "distance")
    private float distance;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "owner_id")
    private Utilisateur owner;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "parcours_id")
    private List<Utilisateur> participants = new ArrayList<>();

}
