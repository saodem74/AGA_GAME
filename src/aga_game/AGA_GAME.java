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
import com.golden.gamedev.object.GameFont;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.text.Font.font;

/**
 *
 * @author trung
 */
public class AGA_GAME extends Game {

    private static final Dimension dimesion = new Dimension(1024, 750);
    Background background;
    private GameFont font;
    private boolean gameFinish = false;

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

        if (gameFinish) {
            return;
        }

        background.update(elapsedTime);
        heroGroup.update(elapsedTime);
        partGroup.update(elapsedTime);
        heroGroup.update();
        KeyListener();
    }

    @Override
    public void render(Graphics2D g) {

        if (gameFinish) {
            return;
        }
        
        // rend background
        background.render(g);
        heroGroup.render(g);
        partGroup.render(g);

        if (!heroGroup.getSprites()[0].isActive()) {
            //finish();
            gameFinish = true;

            return;
        }
    }

    private void KeyListener() {
        double speedX = 0, speedY = 0;

        int outside = Constants.outsideBackground(heroGroup.getSprites()[0]);

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

}
