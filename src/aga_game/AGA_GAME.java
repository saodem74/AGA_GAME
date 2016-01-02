/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aga_game;

import com.golden.gamedev.Game;
import com.golden.gamedev.GameLoader;
import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.background.ImageBackground;
import java.awt.Dimension;
import java.awt.Graphics2D;

/**
 *
 * @author trung
 */
public class AGA_GAME extends Game{

    private static final Dimension dimesion = new Dimension(1024, 750);
    Background background;
    private final int WIDTH_BACKBROUND = 2560;
    private final int HEIGHT_BACKGROUND = 1600;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        GameLoader game = new GameLoader();
        game.setup(new AGA_GAME(), dimesion, false);
        game.start();
        
    }

    @Override
    public void initResources() {
        //background = new ImageBackground(getImage("background2.jpg"), WIDTH_BACKBROUND, HEIGHT_BACKGROUND);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(long l) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(Graphics2D gd) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
