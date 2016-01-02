/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameModel.particles;

import Utils.Constants;
import java.awt.Point;

/**
 *
 * @author trung
 */
public class Water extends Particle {

    public Water(Point position) {
        super(position);
        this.Type = Constants.WATER;
    }
}
