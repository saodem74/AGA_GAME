/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameModel.specialization;

import Utils.Constants;
import gameModel.events.GenerateGasEvent;
import gameModel.particles.Particle;

/**
 *
 * @author trung
 */
public class BasicBacterium extends Specialization {

    public BasicBacterium(int weight) {
        super(weight);
        this.Name = Constants.BASIC_BACTERIUM;
        this.Type = Constants.BASIC_BACTERIUM;
    }

    @Override
    public boolean canEat(Specialization other) {
        return this.getType().equalsIgnoreCase(other.getType())
                && this.weight > other.weight;
    }

    @Override
    public boolean canEat(Particle particle) {
        String type = particle.getType();
        return type.equalsIgnoreCase(Constants.WATER)
                || type.equalsIgnoreCase(Constants.AGAR)
                || type.equalsIgnoreCase(Constants.LIGHT);
    }

    @Override
    public void generateGas() {
        gasListener.generateGas(new GenerateGasEvent(new Object(), Constants.CO2));
    }

    @Override
    public String getType() {
        return this.Type;
    }

    @Override
    public String getName() {
        return this.Name;
    }

}
