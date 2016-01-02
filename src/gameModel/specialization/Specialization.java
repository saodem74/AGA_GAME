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
public abstract class Specialization {

    protected String Type = "Specialization";
    protected String Name = "Specialization";
    protected int weight = 0;

    public Specialization(int weight) {
        this.weight = weight;
    }

    public abstract boolean canEat(Specialization other);

    public abstract boolean canEat(Particle particle);

    public abstract void produceGas();

    public abstract String getType();

    public abstract String getName();
}
