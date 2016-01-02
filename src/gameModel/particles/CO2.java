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
public class CO2 extends Gas {

    public CO2(Point position, String path) {
        super(position, path);
        this.path_img = path;
        this.Type = Constants.CO2;
    }

}
