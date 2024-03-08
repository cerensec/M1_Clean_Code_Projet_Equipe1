package com.api.veloconnecte.services.impl;

import com.api.veloconnecte.services.AuthService;
import com.api.veloconnecte.services.UtilisateurService;
import lombok.AllArgsConstructor;
import com.api.veloconnecte.model.Utilisateur;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private UtilisateurService utilisateurService;

    private static final String SALT = BCrypt.gensalt(12);

    @Override
    public Utilisateur register(Utilisateur utilisateur) {
        if(utilisateurService.findByEmail(utilisateur.getEmail()).isPresent()){

            return null;
        }
        // On hash le MDP
        utilisateur.setPassword(BCrypt.hashpw(utilisateur.getPassword(), SALT));
        return utilisateurService.save(utilisateur);
    }

    @Override
    public Boolean login(String email, String password) {
        final Utilisateur utilisateur = utilisateurService.findByEmail(email).get();

        return utilisateur != null && BCrypt.checkpw(password, utilisateur.getPassword());
    }
}
