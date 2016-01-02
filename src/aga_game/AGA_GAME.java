/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aga_game;

import com.golden.gamedev.Game;
import com.golden.gamedev.GameLoader;
import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.GameFont;
import com.golden.gamedev.object.background.ColorBackground;
import com.golden.gamedev.object.background.ImageBackground;
import java.awt.Color;
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
    GameFont font;
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
        //background = new ColorBackground(Color.GRAY, 1024, 768);
        background = new ImageBackground(getImage("../Images/background2.jpg"), WIDTH_BACKBROUND, HEIGHT_BACKGROUND);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
         // make font
//        font = fontManager.getFont(getImages("font.png", 20, 3),
//                                   " !            .,0123" +
//                                   "456789:   -? ABCDEFG" +
//                                   "HIJKLMNOPQRSTUVWXYZ ");
    }

    @Override
    public void update(long elapsedTime) {
        // update background
        background.update(elapsedTime);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(Graphics2D g) {
        // rend background
        background.render(g);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
