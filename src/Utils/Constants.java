/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import com.golden.gamedev.object.Sprite;
import static java.lang.Math.*;
import java.util.Random;

/**
 *
 * @author trung
 */
public class Constants {

    public static final String AGAR = "AGAR";
    public static final String CO2 = "CO2";
    public static final String GAS = "GAS";
    public static final String LIGHT = "LIGHT";
    public static final String O2 = "O2";
    public static final String PARTICLE = "PARTICLE";
    public static final String WATER = "WATER";

    public static final String SPECIALIZATION = "SPECIALIZATION";

    public static final String BASIC_BACTERIUM = "BASIC";

    //Простейшее Растений
    public static final String PLANT = "PLANT";
    //Мох
    public static final String MOSS = "MOSS";
    //Паразит
    public static final String PARASITE = "PARASITE";
    //Хищник
    public static final String PREDATOR = "PREDATOR";

    //Простейшее Живот
    public static final String PROTOZOAN = "PROTOZOAN";
    //Всеядное
    public static final String OMNIVOROUS = "OMNIVOROUS";
    //Хищное
    public static final String RAPACIOUS = "RAPACIOUS";
    //Тигр
    public static final String TIGER = "TIGER";
    //Растениеядное
    public static final String PHYTOPHAGOUS = "PHYTOPHAGOUS";
    //Буйвол
    public static final String BUFFALO = "BUFFALO";

    public static final int SIZE_HERO = 32;

    public static double SPEED_HERO = 0.3;

    public static final int WIDTH_BACKBROUND = 2560;
    public static final int HEIGHT_BACKGROUND = 1600;

    public static final int SIZE_AGAR = 16;

    public static final int SIZE_INCREASED = 2;

    public static final double PERCENT_SPEED = 0.05;

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

    public static void changeSpeedSprite(Sprite sprite) {
        double spX = 0;
        double spY = 0;
        double sp = SPEED_HERO * sqrt(2);
        Random rd = new Random();

        int k = (sprite.getHeight() - SIZE_HERO) / 2;

        for (int i = 0; i < abs(k); i++) {
            sp = (sp - sp * PERCENT_SPEED * k / (abs(k)));
        }

        spX = pow(-1.0, rd.nextInt(2)) * rd.nextDouble() * sp;
        spY = pow(-1.0, rd.nextInt(2)) * sqrt(sp * sp - spX * spX);

        sprite.setSpeed(spX, spY);
    }

}
