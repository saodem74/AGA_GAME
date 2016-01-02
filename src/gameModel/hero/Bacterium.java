/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameModel.hero;

import com.golden.gamedev.object.Sprite;
import gameModel.specialization.Specialization;
import java.awt.Point;
import java.awt.image.BufferedImage;
import javafx.util.Pair;

/**
 *
 * @author trung
 */
public abstract class Bacterium extends Sprite {

    private double speedX;
    private double speedY;
    protected Specialization specialization;

    public double getSpeedX() {
        return speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedX(double spX) {
        speedX = spX;
    }

    public void setSpeedY(double spY) {
        speedY = spY;
    }

    public abstract boolean isPlayer();

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization spez) {
        this.specialization = spez;
    }
    
    public abstract void updateSize();
}
