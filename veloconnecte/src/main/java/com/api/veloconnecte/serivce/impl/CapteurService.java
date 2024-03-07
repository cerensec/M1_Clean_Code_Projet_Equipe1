package com.api.veloconnecte.serivce.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import com.api.veloconnecte.serivce.ICapteurService;

public class CapteurService implements ICapteurService {
    
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    
    int counter = 0;

    @Override
    @Scheduled(fixedRate = 1000)
    public void getWheelRotationEverySeconde() {
        counter++;
        messagingTemplate.convertAndSend("/topic/data", "Counter: " + counter);
    }
    
    
    
}
