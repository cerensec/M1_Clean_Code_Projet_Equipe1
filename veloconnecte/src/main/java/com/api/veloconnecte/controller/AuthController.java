package com.api.veloconnecte.controller;

import com.api.veloconnecte.model.Utilisateur;
import com.api.veloconnecte.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody final Utilisateur utilisateur){
        if(authService.login(utilisateur.getEmail(), utilisateur.getPassword())){
            return new ResponseEntity<String>("Logged in !", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Mot de passe ou email incorrect", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/register")
    public ResponseEntity<Utilisateur> register(@RequestBody final Utilisateur utilisateur){
        return new ResponseEntity<Utilisateur>(authService.register(utilisateur), HttpStatus.OK);
    }
}
