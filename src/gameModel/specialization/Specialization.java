/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameModel.specialization;

import gameModel.particles.Particle;
import Utils.Constants;
import com.golden.gamedev.object.Sprite;
import gameModel.events.GenerateGasListener;
import java.awt.Point;

/**
 *
 * @author trung
 */
public abstract class Specialization extends Sprite {

    protected String Type = Constants.SPECIALIZATION;
    protected String Name = Constants.SPECIALIZATION;
    protected int weight = 0;
    protected GenerateGasListener gasListener;

    public void addGasListener(GenerateGasListener listener) {
        this.gasListener = listener;
    }

    public GenerateGasListener getListener() {
        return gasListener;
    }

    public Specialization(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public abstract boolean canEat(Specialization other);

    public abstract boolean canEat(Particle particle);

    public abstract void generateGas(Point pos);

    public abstract String getType();

    public abstract String getName();
}
