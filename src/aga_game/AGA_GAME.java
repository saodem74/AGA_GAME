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
import com.golden.gamedev.object.Timer;
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
    private boolean gameFinish = false;
    private int cTime = 0;
    private BactoriumFactory heroGroup;
    private ParticleFactory partGroup;
    Timer countDownTimer;
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
        background = new ImageBackground(getImage("Images/background2.jpg"), Constants.WIDTH_BACKBROUND, Constants.HEIGHT_BACKGROUND);
        partGroup = new ParticleFactory("Particle");
        partGroup.setBackground(background);

        heroGroup = new BactoriumFactory("HERO");
        heroGroup.setBackground(background);
        heroGroup.setPrFac(partGroup);

        countDownTimer = new Timer(1000);
        // set font
        font = fontManager.getFont(getImages("Images/font.png", 20, 3),
                " !            .,0123"
                + "456789:   -? ABCDEFG"
                + "HIJKLMNOPQRSTUVWXYZ ");
    }

    @Override
    public void update(long elapsedTime) {
        // update background
        //System.out.println("here update");
        if (gameFinish) {
            return;
        }

        background.update(elapsedTime);
        heroGroup.update(elapsedTime);
        partGroup.update(elapsedTime);
        heroGroup.update();
        KeyListener();
        if (countDownTimer.action(elapsedTime)) {
            cTime++;
        }
    }

    @Override
    public void render(Graphics2D g) {

        if (gameFinish) {
            return;
        }
        //System.out.println("here render");
        // rend background
        background.render(g);
        heroGroup.render(g);
        partGroup.render(g);

        int res = ((Player) heroGroup.getSprites()[0]).getScore();
        font.drawString(g, "SCORE : " + res, 10, 10);
        //font.drawString(g, "TYPE  : " + "B", 10, 30);
        font.drawString(g, "TIME  : " + cTime, 10, 50);

        int W = heroGroup.getSprites()[0].getWidth();
        int H = heroGroup.getSprites()[0].getHeight();
        int heroX = (int) heroGroup.getSprites()[0].getX();
        int heroY = (int) heroGroup.getSprites()[0].getY();
        int screenX = (int) heroGroup.getSprites()[0].getScreenX();
        int screenY = (int) heroGroup.getSprites()[0].getScreenY();
        font.drawString(g, heroGroup.getBacterium(0).getSpecialization().getName(), screenX + W / 3, screenY + H / 2);

        if (!heroGroup.getSprites()[0].isActive()) {
            gameFinish = true;
        }
        // game finishes
        if (gameFinish) {
            font.drawString(g, "MISSION FAILED ", (int) dimesion.getWidth() / 2 - 150, (int) dimesion.getHeight() / 2);
        }
    }

    private void KeyListener() {
        double speedX = 0, speedY = 0;

        Player player = (Player) heroGroup.getSprites()[0];

        int outside = Constants.outsideBackground(heroGroup.getSprites()[0]);

        if (keyDown(KeyEvent.VK_LEFT)
                && !(outside == -4 || outside == -41 || outside == -34)) {
            speedX = -player.getSpeedX();
        }
        if (keyDown(KeyEvent.VK_RIGHT)
                && !(outside == -2 || outside == -12 || outside == -23)) {
            speedX = player.getSpeedX();
        }
        if (keyDown(KeyEvent.VK_UP)
                && !(outside == -1 || outside == -12 || outside == -41)) {
            speedY = -player.getSpeedY();
        }
        if (keyDown(KeyEvent.VK_DOWN)
                && !(outside == -3 || outside == -23 || outside == -34)) {
            speedY = player.getSpeedY();
        }

        heroGroup.getSprites()[0].setSpeed(speedX, speedY);
        // set sprite1 (the one we control) as the center of the background
        background.setToCenter(heroGroup.getSprites()[0]);
    }

}
