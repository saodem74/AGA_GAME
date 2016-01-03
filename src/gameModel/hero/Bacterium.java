/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameModel.hero;

import Utils.Constants;
import com.golden.gamedev.object.Sprite;
import gameModel.specialization.BasicBacterium;
import gameModel.specialization.Buffalo;
import gameModel.specialization.Moss;
import gameModel.specialization.Omnivorous;
import gameModel.specialization.Parasite;
import gameModel.specialization.Predator;
import gameModel.specialization.Specialization;
import gameModel.specialization.Tiger;
import java.awt.Color;
import java.awt.Graphics2D;
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
    
    public void upgrade(){
       
        if (score >= 50)
        {
            this.setSpecialization(new Tiger(this.width));
        }
        else
        if (score >= 35)
        {
            this.setSpecialization(new Omnivorous(this.width));
        }
        else
        if (score >= 25)
        {
            this.setSpecialization(new Buffalo(this.width));
        }
        else
        if (score >= 20)
        {
            this.setSpecialization(new Predator(this.width));
        }
        else
        if (score >= 15)
        {
            this.setSpecialization(new Parasite(this.width));
        }
        else
        if (score >= 10)
        {
            this.setSpecialization(new Moss(this.width));
        }
        
        updateColor();
    }
    void updateColor(){
        BufferedImage image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        
        if (this instanceof Player)
            graphics.setColor(Color.BLUE);
        else 
            graphics.setColor(Color.YELLOW);
        
        if (this.getSpecialization() instanceof Tiger)
        {
            graphics.setColor(Color.RED);
        }
        else
        if (this.getSpecialization() instanceof Buffalo)
        {
            graphics.setColor(Color.PINK);
        }
        else
        if (this.getSpecialization() instanceof Omnivorous)
        {
            graphics.setColor(Color.ORANGE);
        }
        else
        if (this.getSpecialization() instanceof Predator)
        {
            graphics.setColor(Color.black);
        }
        else
        if (this.getSpecialization() instanceof Parasite)
        {
            graphics.setColor(Color.magenta);
        }
        else
        if (this.getSpecialization() instanceof Moss)
        {
            graphics.setColor(Color.CYAN);
        }
        
        graphics.fillOval(0, 0, this.getWidth(), this.getHeight());
        this.setImage(image);
    }
}
