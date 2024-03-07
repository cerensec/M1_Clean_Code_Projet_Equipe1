package com.api.veloconnecte.services;

import com.api.veloconnecte.model.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface UtilisateurService {

    public Optional<Utilisateur> findByEmail(String email);

    public List<Utilisateur> findAll();

    public Utilisateur save(Utilisateur utilisateur);
}
