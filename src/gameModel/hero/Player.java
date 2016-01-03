/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameModel.hero;

import Utils.Constants;
import gameModel.specialization.BasicBacterium;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author trung
 */
public class Player extends Bacterium {

    private static final String name = "Play";
    private int score = 0;

    public Player() {
        BufferedImage image = new BufferedImage(Constants.SIZE_HERO, Constants.SIZE_HERO, BufferedImage.TYPE_INT_ARGB);
        this.setImage(image);
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.BLUE);
        graphics.fillOval(0, 0, Constants.SIZE_HERO, Constants.SIZE_HERO);
        this.setLocation(50, 200);
        this.setSpeed(0, 0);
        this.setSpecialization(new BasicBacterium(this.width));
    }

 
    
    @Override
    public boolean isPlayer() {
        return true;
    }

    @Override
    public void updateSize() {
        this.updateSpeed();
        int W = this.getWidth() + Constants.SIZE_INCREASED;
        int H = this.getHeight() + Constants.SIZE_INCREASED;
        BufferedImage image_ = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = (Graphics2D) image_.getGraphics();
        graphics.setColor(Color.BLUE);
        graphics.fillOval(0, 0, W, H);
        this.setImage(image_);
        this.getSpecialization().setWeight(this.getWidth());
    }

    
}
