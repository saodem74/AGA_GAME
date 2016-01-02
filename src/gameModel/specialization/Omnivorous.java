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
public class Omnivorous extends Protozoan {

    public Omnivorous(int weight) {
        super(weight);
        this.Name = Constants.OMNIVOROUS;
        this.Type = Constants.OMNIVOROUS;
    }

    @Override
    public boolean canEat(Specialization other) {
        String type = other.getType();

        return (type.equalsIgnoreCase(Constants.PLANT)
                && 1.25 * this.weight > other.getWeight())
                || ((type.equalsIgnoreCase(Constants.OMNIVOROUS)
                || type.equalsIgnoreCase(Constants.RAPACIOUS)
                || type.equalsIgnoreCase(Constants.PHYTOPHAGOUS))
                && (2 * this.weight > other.getWeight()));
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
