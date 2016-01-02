/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aga_game;

import gameFactory.BactoriumFactory;
import Utils.Constants;
import com.golden.gamedev.Game;
import com.golden.gamedev.GameLoader;
import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.background.ColorBackground;
import com.golden.gamedev.object.background.ImageBackground;
import gameFactory.ParticleFactory;
import gameModel.hero.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/**
 *
 * @author trung
 */
public class AGA_GAME extends Game {

    private static final Dimension dimesion = new Dimension(1024, 750);
    Background background;

    private BactoriumFactory heroGroup;
    private ParticleFactory partGroup;

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
        background = new ImageBackground(getImage("../Images/background2.jpg"), Constants.WIDTH_BACKBROUND, Constants.HEIGHT_BACKGROUND);
        partGroup = new ParticleFactory("Particle");
        partGroup.setBackground(background);

        heroGroup = new BactoriumFactory("HERO");
        heroGroup.setBackground(background);
        heroGroup.setPrFac(partGroup);
    }

    @Override
    public void update(long elapsedTime) {
        // update background
        background.update(elapsedTime);
        heroGroup.update(elapsedTime);
        partGroup.update(elapsedTime);
        heroGroup.update();
        KeyListener();
    }

    @Override
    public void render(Graphics2D g) {
        // rend background
        background.render(g);
        heroGroup.render(g);
        partGroup.render(g);
    }

    private void KeyListener() {
        double speedX = 0, speedY = 0;

        int outside = outsideBackground(heroGroup.getSprites()[0]);

        if (keyDown(KeyEvent.VK_LEFT)
                && !(outside == -4 || outside == -41 || outside == -34)) {
            speedX = -Constants.SPEED_HERO;
        }
        if (keyDown(KeyEvent.VK_RIGHT)
                && !(outside == -2 || outside == -12 || outside == -23)) {
            speedX = Constants.SPEED_HERO;
        }
        if (keyDown(KeyEvent.VK_UP)
                && !(outside == -1 || outside == -12 || outside == -41)) {
            speedY = -Constants.SPEED_HERO;
        }
        if (keyDown(KeyEvent.VK_DOWN)
                && !(outside == -3 || outside == -23 || outside == -34)) {
            speedY = Constants.SPEED_HERO;
        }

        heroGroup.getSprites()[0].setSpeed(speedX, speedY);
        // set sprite1 (the one we control) as the center of the background
        background.setToCenter(heroGroup.getSprites()[0]);
    }

    /* return  0  - sprite is inside
     -1  - sprite touched the top
     -2  - sprite touched the right
     -3  - sprite touched the bottom
     -4  - sprite touched the left
     -12 - sprite touched the top-right corner
     -23 - sprite touched the right-bottom corner
     -34 - sprite touched the bottom-left corner
     -41 - sprite touched the left-top corner
     */
    public static int outsideBackground(Sprite sp) {

        double heroX = sp.getX();
        double heroY = sp.getY();
        int W = sp.getWidth();
        int H = sp.getHeight();
        int outside = 0;

        if (heroY < 0) {
            outside = -1;
        }
        if (heroX + W > Constants.WIDTH_BACKBROUND) {
            outside = -2;
        }
        if (heroY + H > Constants.HEIGHT_BACKGROUND) {
            outside = -3;
        }
        if (heroX < 0) {
            outside = -4;
        }
        if (heroY < 0 && heroX + W > Constants.WIDTH_BACKBROUND) {
            outside = -12;
        }
        if (heroX + W > Constants.HEIGHT_BACKGROUND
                && heroY + H > Constants.HEIGHT_BACKGROUND) {
            outside = -23;
        }
        if (heroY + H > Constants.HEIGHT_BACKGROUND && heroX < 0) {
            outside = -34;
        }
        if (heroX < 0 && heroY < 0) {
            outside = -41;
        }

        return outside;

    }

}
