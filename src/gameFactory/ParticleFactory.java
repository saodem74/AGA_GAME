/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameFactory;

import Utils.Constants;
import com.golden.gamedev.object.SpriteGroup;
import gameModel.events.GenerateGasEvent;
import gameModel.events.GenerateGasListener;
import gameModel.particles.Agar;
import gameModel.particles.CO2;
import gameModel.particles.Light;
import gameModel.particles.O2;
import gameModel.particles.Particle;
import gameModel.particles.Water;
import java.util.Random;

/**
 *
 * @author trung
 */
public final class ParticleFactory extends SpriteGroup {

    private final GenerateGasObserver observer = new GenerateGasObserver();
    private int numberGas = 0;
    private int numberNormal = 0;

    public GenerateGasObserver getObserver() {
        return observer;
    }

    public int getNumberNormal() {
        return numberNormal;
    }

    public void updateNumberNormal() {
        numberNormal--;
    }

    public ParticleFactory(String string) {
        super(string);
        initAgar(50);
        initLight(50);
        initWater(50);
    }

    public void randParticle(int number) {

        System.out.println("randParticle");

        Random rand = new Random();
        initAgar(rand.nextInt(number / 3));
        initLight(rand.nextInt(number / 3));
        initWater(rand.nextInt(number / 3));

    }

    public void initAgar(int num) {
        for (int i = 0; i < num; i++) {
            this.add(new Agar());
        }

        numberNormal += num;
    }

    private void initLight(int num) {
        for (int i = 0; i < num; i++) {
            this.add(new Light());
        }

        numberNormal += num;
    }

    private void initWater(int num) {
        for (int i = 0; i < num; i++) {
            this.add(new Water());
        }

        numberNormal += num;
    }

    private void initGas(GenerateGasEvent event) {
        if (event.getType().equalsIgnoreCase(Constants.CO2)) {
            this.add(new CO2(event.getPos()));
        } else {
            this.add(new O2(event.getPos()));
        }
        numberGas++;

        int numDel = 0;

        if (numberGas < 100) {
            return;
        }

        for (int i = 0; i < this.getSize() && numDel < 50; i++) {
            Particle par = (Particle) this.getSprites()[i];

            if (par.getType().equalsIgnoreCase(Constants.CO2)
                    || par.getType().equalsIgnoreCase(Constants.CO2)) {
                par.setActive(false);
                this.remove(par);
                System.out.println("delete Gas");
                i--;
                numDel++;
            }
        }

    }

    private class GenerateGasObserver implements GenerateGasListener {

        @Override
        public void generateGas(GenerateGasEvent event) {
            initGas(event);
        }

    }
}
