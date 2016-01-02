/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameModel.specialization;

import Utils.Constants;
import gameModel.particles.Particle;

/**
 *
 * @author trung
 */
public class Rapacious extends Protozoan {

    public Rapacious(int weight) {
        super(weight);
        this.Name = Constants.RAPACIOUS;
        this.Type = Constants.RAPACIOUS;
    }

    @Override
    public boolean canEat(Specialization other) {
        return false;
    }

    @Override
    public boolean canEat(Particle particle) {

        String type = particle.getType();
        return type.equalsIgnoreCase(Constants.WATER)
                || type.equalsIgnoreCase(Constants.O2);
    }

    @Override
    public void produceGas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
