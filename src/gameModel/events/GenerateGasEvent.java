/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameModel.events;

import java.awt.Point;
import java.util.EventObject;

/**
 *
 * @author trung
 */
public class GenerateGasEvent extends EventObject {

    private String type = "";
    private Point pos;

    public GenerateGasEvent(Object source, String type, Point pos) {
        super(source);
        this.type = type;
        this.pos = pos;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Point getPos() {
        return pos;
    }

}
