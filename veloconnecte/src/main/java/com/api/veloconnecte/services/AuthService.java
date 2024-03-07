package com.api.veloconnecte.services;

import com.api.veloconnecte.model.Utilisateur;

public interface AuthService {

    public Utilisateur register(Utilisateur utilisateur);

    public Boolean login(String email, String password);
}
