/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameModel.specialization;

import Utils.Constants;
import gameModel.events.GenerateGasEvent;
import gameModel.particles.Particle;
import java.awt.Point;

/**
 *
 * @author trung
 */
public class Moss extends SimplePlant {

    public Moss(int weight) {
        super(weight);
        this.Name = Constants.MOSS;
        //this.Type = Constants.MOSS;
    }

    @Override
    public boolean canEat(Specialization other) {
        //return  other.getType().equalsIgnoreCase(Constants.BASIC_BACTERIUM);    
        return false;
    }

    @Override
    public boolean canEat(Particle particle) {
        String type = particle.getType();
        return type.equalsIgnoreCase(Constants.WATER)
                || type.equalsIgnoreCase(Constants.CO2)
                || type.equalsIgnoreCase(Constants.LIGHT);

    }

    @Override
    public String getName() {
        return this.Name;
    }

}
