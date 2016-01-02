/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameModel.particles;

import java.awt.Point;

/**
 *
 * @author trung
 */
public class Particle {

    private Point position;
    protected String path_img;
    protected String Type = "Particle";

    public Particle(Point position, String path) {
        this.position = position;
        this.path_img = path;
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
