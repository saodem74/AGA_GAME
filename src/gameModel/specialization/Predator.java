/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameModel.specialization;

import gameModel.particles.Particle;

/**
 *
 * @author trung
 */
public class Predator extends SimplePlant {

    public Predator(int weight) {
        super(weight);
        this.Name = "Predator";
    }

    @Override
    public boolean canEat(Specialization other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void produceGas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return this.Name;
    }

    @Override
    public boolean canEat(Particle particle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
