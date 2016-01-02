/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameModel.particles;

import Utils.Constants;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import java.awt.Point;

/**
 *
 * @author trung
 */
public class Particle extends Sprite {

    private Point position;
    protected String path_img;
    protected String Type = Constants.PARTICLE;

    public void setPos(Point pos) {
        this.position = pos;
    }

    public Point getPosition() {
        return position;
    }

    public String getPath_img() {
        return path_img;
    }

    public String getType() {
        return Type;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
}
