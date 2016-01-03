/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameModel.hero;

import Utils.Constants;
import aga_game.AGA_GAME;
import gameModel.specialization.BasicBacterium;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author trung
 */
public class Computer extends Bacterium {

    public Computer() {
        RandSize();
        BufferedImage image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.YELLOW);
        graphics.fillOval(0, 0, this.getWidth(), this.getHeight());
        this.setLocation(50, 200);
        this.setSpeed(0, 0);
        initPosSpeed();
        this.setSpecialization(new BasicBacterium(this.width));
        this.setImage(image);
    }

    @Override
    public boolean isPlayer() {
        return false;
    }

    private void initPosSpeed() {
        Random randPos = new Random();
        int posX = randPos.nextInt(Constants.WIDTH_BACKBROUND) - this.width;
        int posY = randPos.nextInt(Constants.HEIGHT_BACKGROUND) - this.width;
        if (posX < 0) {
            posX = 0;
        }
        if (posY < 0) {
            posY = 0;
        }
        this.setLocation(posX, posY);
        Constants.changeSpeedSprite(this);
    }

    private void RandSize() {
        Random randPos = new Random();
        this.height = this.width = 20 + 2 * randPos.nextInt(10);
    }

    @Override
    public void update(long l) {
        super.update(l);

        while (Constants.outsideBackground(this) != 0) {
            Constants.changeSpeedSprite(this);
            this.forceX(this.getOldX() + this.getHorizontalSpeed());
            this.forceY(this.getOldY() + this.getVerticalSpeed());
        }

        this.setLocation(this.getX(), this.getY());
    }

    @Override
    public void updateSize() {
        int W = this.getWidth() + Constants.SIZE_INCREASED;
        int H = this.getHeight() + Constants.SIZE_INCREASED;
        BufferedImage image_ = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = (Graphics2D) image_.getGraphics();
        graphics.setColor(Color.YELLOW);
        graphics.fillOval(0, 0, W, H);
        this.setImage(image_);
        this.getSpecialization().setWeight(this.getWidth());
    }
    
    
}
