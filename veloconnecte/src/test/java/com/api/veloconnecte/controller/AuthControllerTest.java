package com.api.veloconnecte.controller;

import com.api.veloconnecte.model.Utilisateur;
import com.api.veloconnecte.services.AuthService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AuthControllerTest {

    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthController controller;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoginSuccess(){
        // Arrange
        Mockito.when(authService.login(Mockito.anyString(), Mockito.anyString())).thenReturn(true);

        Utilisateur utilisateur = new Utilisateur("test@example.com", "password");

        // Act
        final ResponseEntity<String> response = controller.login(utilisateur);

        // Assert
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals("Logged in !", response.getBody());

    }

    @Test
    public void testLoginFailure(){
        // Arrange
        Mockito.when(authService.login(Mockito.anyString(), Mockito.anyString())).thenReturn(false);

        Utilisateur utilisateur = new Utilisateur("test@example.com", "password");

        // Act
        final ResponseEntity<String> response = controller.login(utilisateur);

        // Verify the result
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        Assertions.assertEquals("Mot de passe ou email incorrect", response.getBody());
    }
}
