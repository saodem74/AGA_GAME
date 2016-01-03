/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameModel.particles;

import Utils.Constants;
import com.golden.gamedev.object.AnimatedSprite;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author trung
 */
public class CO2 extends Gas {

    public CO2(Point pos) {
        this.Type = Constants.CO2;
        BufferedImage image;
        try {
            //image[ite] = ImageIO.read(new File(model.getPlayer2().getList().get(ite-_count1).getPic()));
            image = ImageIO.read(new File("Images\\co2.png"));
            this.setImage(image);
        } catch (IOException ex) {
        }

        this.setLocation(pos.x, pos.y);
    }

}
