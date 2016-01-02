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
        this.setImage(image);
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.YELLOW);
        graphics.fillOval(0, 0, this.getWidth(), this.getHeight());
        this.setLocation(50, 200);
        this.setSpeed(0, 0);
        initPosSpeed();
        this.setSpecialization(new BasicBacterium(this.width));
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
        this.setSpeed(randPos.nextDouble() / 5 - randPos.nextDouble() / 5,
                randPos.nextDouble() / 5 - randPos.nextDouble() / 5);
    }

    private void RandSize() {
        Random randPos = new Random();
        this.height = this.width = randPos.nextInt(30) + 30;
    }

    @Override
    public void update(long l) {
        super.update(l);

        Random randSpeed = new Random();
        double spX = this.getHorizontalSpeed(), spY = this.getVerticalSpeed();
        while (AGA_GAME.outsideBackground(this) != 0) {
            spX = randSpeed.nextDouble() / 5 - randSpeed.nextDouble() / 5;
            spY = randSpeed.nextDouble() / 5 - randSpeed.nextDouble() / 5;
            this.forceX(this.getOldX() + spX);
            this.forceY(this.getOldY() + spY);
        }
        this.setSpeed(spX, spY);
        this.setLocation(this.getX(), this.getY());
    }

     @Override
    public void updateSize() {
        int W = this.getWidth() + 5;
        int H = this.getHeight() + 5;
        BufferedImage image_ = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = (Graphics2D) image_.getGraphics();
        graphics.setColor(Color.BLUE);
        graphics.fillOval(0, 0, W, H);
        this.setImage(image_);
    }
}
