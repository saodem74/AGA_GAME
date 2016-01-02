/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameModel.hero;

import java.awt.Point;
import javafx.util.Pair;

/**
 *
 * @author trung
 */
public class Bacterium {
    private Point position;
    private double speedX;
    private double speedY;
    private int size;
    
    public int getSize(){
        return size;
    }
    
    public double getSpeedX(){
        return speedX;
    }
    
    public double getSpeedY(){
        return speedY;
    }
    
    public void setSpeedX(double spX){
        speedX = spX;
    }
    
    public void setSpeedY(double spY){
        speedY = spY;
    }
    
    public void upgrade(){
        
    }
}
