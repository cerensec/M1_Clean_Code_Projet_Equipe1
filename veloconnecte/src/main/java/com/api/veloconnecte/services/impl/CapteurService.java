package com.api.veloconnecte.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import com.api.veloconnecte.services.ICapteurService;

@Service
public class CapteurService implements ICapteurService {
    
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    
   
    
    int counter = 0;
    
    @Override
    public void sendDistanceFromCapteur(double meters) {      
        messagingTemplate.convertAndSend("/topic/data", meters);
    }

}
