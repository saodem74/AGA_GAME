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
    
    public CO2() {
        super();
        this.path_img = "../Images/C02.jpg";
        this.Type = Constants.CO2;
    }
    
}
