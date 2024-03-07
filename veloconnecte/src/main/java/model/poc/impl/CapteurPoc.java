package model.poc.impl;

import java.util.Random;
import model.poc.ICapteur;

public class CapteurPoc implements
                        ICapteur {

    @Override
    public int getNomberRatation() {

        int maxValue = 10; 

        Random random = new Random();

        int randomNumber = random.nextInt(maxValue) + 1;
        
        return randomNumber;
    }


}
