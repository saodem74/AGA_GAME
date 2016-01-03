/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameModel.particles;

import Utils.Constants;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author trung
 */
public class Agar extends Particle {

    public Agar() {
        this.Type = Constants.AGAR;
        BufferedImage image = new BufferedImage(Constants.SIZE_AGAR, Constants.SIZE_AGAR, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.RED);
        graphics.fillOval(0, 0, Constants.SIZE_AGAR, Constants.SIZE_AGAR);
        this.setImage(image);
        
        Random rd = new Random();
        int posX = rd.nextInt(Constants.WIDTH_BACKBROUND) - Constants.SIZE_AGAR;
        int posY = rd.nextInt(Constants.HEIGHT_BACKGROUND) - Constants.SIZE_AGAR;
        if (posX < 0) {
            posX = 0;
        }
        if (posY < 0) {
            posY = 0;
        }
        this.setLocation(posX, posY);
    }
}
