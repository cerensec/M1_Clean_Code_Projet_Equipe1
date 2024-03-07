package model.poc.impl;

import lombok.AllArgsConstructor;
import model.poc.IWheel;

@AllArgsConstructor
public class WheelPoc extends
                      WheelAbsractPoc
                      implements
                      IWheel {
    
    private String nameModel;

    @Override
    public double getDiameteres() {
        return WHEEL_DIAMETER;
    }


}
