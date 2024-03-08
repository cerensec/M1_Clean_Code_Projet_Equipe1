package com.api.veloconnecte.services.impl;

import org.springframework.stereotype.Service;
import com.api.veloconnecte.services.IDistanceFromWheelService;
import model.poc.IWheel;

@Service
public class DistanceFromWheelService implements
                                      IDistanceFromWheelService<IWheel> {

    
    
    @Override
    public double calculateDistanceInMeters(IWheel wheel, int wheelRevolutions) {
        return Math.PI * wheel.getDiameteres() * wheelRevolutions;
    }
    
    


}
