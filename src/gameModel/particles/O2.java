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

    public O2(Point pos) {
        
        this.Type = Constants.O2;
        BufferedImage image;
        try {
            image = ImageIO.read(new File("Images/o2.png"));
            this.setImage(image);
        } catch (IOException ex) {
        }
        
        this.setLocation(pos.x, pos.y);
    }
}
