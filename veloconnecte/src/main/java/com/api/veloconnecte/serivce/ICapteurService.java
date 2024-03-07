package com.api.veloconnecte.serivce;

import org.springframework.scheduling.annotation.Scheduled;

public interface ICapteurService {
        
    @Scheduled(fixedRate = 1000)
    public void getWheelRotationEverySeconde();
    
}
