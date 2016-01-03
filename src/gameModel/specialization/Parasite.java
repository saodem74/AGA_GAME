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
public class Parasite extends SimplePlant {

    public Parasite(int weight) {
        super(weight);
        this.Name = Constants.PARASITE;
    }

    @Override
    public boolean canEat(Specialization other) {
        return other.getType().equalsIgnoreCase(Constants.PLANT)
                && (1.5 * this.weight > other.getWeight());
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
