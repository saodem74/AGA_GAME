/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameModel.hero;

import Utils.Constants;
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

    protected double speedX = Constants.SPEED_HERO;
    protected double speedY = Constants.SPEED_HERO;
    protected Specialization specialization;
    protected int score = 0;

    public String typeToString(){
        return (this.specialization.getType());
    }
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

    public void setSpeedXY(double spX, double spY) {
        this.speedX = spX;
        this.speedY = spY;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    
    public void updateSpeed() {
        speedX = speedX - speedX * Constants.PERCENT_SPEED;
        speedY = speedY - speedY * Constants.PERCENT_SPEED;
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
