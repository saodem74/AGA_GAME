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
public class Predator extends SimplePlant {

    public Predator(int weight) {
        super(weight);
        this.Name = Constants.PREDATOR;
        this.Type = Constants.PREDATOR;
    }

    @Override
    public boolean canEat(Specialization other) {

        String type = other.getType();

        return (type.equalsIgnoreCase(Constants.OMNIVOROUS)
                || type.equalsIgnoreCase(Constants.RAPACIOUS)
                || type.equalsIgnoreCase(Constants.PHYTOPHAGOUS))
                && (this.weight > 2 * other.getWeight());
    }

    @Override
    public boolean canEat(Particle particle) {

        String type = particle.getType();

        return type.equalsIgnoreCase(Constants.WATER)
                || type.equalsIgnoreCase(Constants.CO2)
                || type.equalsIgnoreCase(Constants.LIGHT);
    }

    @Override
    public void produceGas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return this.Name;
    }

}
