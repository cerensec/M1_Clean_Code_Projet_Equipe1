package com.api.veloconnecte.services.impl;

import com.api.veloconnecte.repository.UtilisateurRepository;
import com.api.veloconnecte.services.UtilisateurService;
import lombok.AllArgsConstructor;
import com.api.veloconnecte.model.Utilisateur;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Log4j2
public class UtilisateurServiceImpl implements UtilisateurService {

    private UtilisateurRepository utilisateurRepository;

    @Override
    public Optional<Utilisateur> findByEmail(String email) {
        return utilisateurRepository.findByEmailIgnoreCase(email);
    }

    @Override
    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur save(Utilisateur utilisateur) {
        log.info("Sauvegarde de l'utilisateur");
        return utilisateurRepository.save(utilisateur);
    }
}
