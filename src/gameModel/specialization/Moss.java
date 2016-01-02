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
public class Moss extends SimplePlant {

    public Moss(int weight) {
        super(weight);
        this.Name = "Moss";
    }

    @Override
    public boolean canEat(Specialization other) {
        return false;
    }

    @Override
    public boolean canEat(Particle particle) {
        return true;
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
