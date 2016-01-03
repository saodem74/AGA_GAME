/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameModel.particles;

import Utils.Constants;
import com.golden.gamedev.object.AnimatedSprite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author trung
 */
public class O2 extends Gas {

    public O2() {
        AnimatedSprite aniBooms;
        this.Type = Constants.O2;
        BufferedImage image;
        try {
            //image[ite] = ImageIO.read(new File(model.getPlayer2().getList().get(ite-_count1).getPic()));
            image = ImageIO.read(new File("Images\\co.png"));
            this.setImage(image);
        } catch (IOException ex) {
        }
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
