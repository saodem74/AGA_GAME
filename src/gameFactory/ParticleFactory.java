/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameFactory;

<<<<<<< HEAD
import Utils.Constants;
=======
import com.golden.gamedev.object.AnimatedSprite;
>>>>>>> Lam
import com.golden.gamedev.object.SpriteGroup;
import gameModel.events.GenerateGasEvent;
import gameModel.events.GenerateGasListener;
import gameModel.particles.Agar;
import gameModel.particles.CO2;
import gameModel.particles.Light;
import gameModel.particles.O2;
import gameModel.particles.Water;
import java.util.Random;

/**
 *
 * @author trung
 */
public final class ParticleFactory extends SpriteGroup {

    private final GenerateGasObserver observer = new GenerateGasObserver();

    public GenerateGasObserver getObserver() {
        return observer;
    }

    public ParticleFactory(String string) {
        super(string);
        initAgar(50);
        initLight(50);
        initWater(50);
    }

    public void randParticle(int number) {

        Random rand = new Random();
        initAgar(rand.nextInt(number / 3));
        initLight(rand.nextInt(number / 3));
        initWater(rand.nextInt(number / 3));
    }

    public void initAgar(int num) {
        for (int i = 0; i < num; i++) {
            this.add(new Agar());
            
        }
    }

    private void initLight(int num) {
        for (int i = 0; i < num; i++) {
            this.add(new Light());
        }
    }

    private void initWater(int num) {
        for (int i = 0; i < num; i++) {
            this.add(new Water());
        }
    }
<<<<<<< HEAD

    private void initGas(String type) {
        if (type.equalsIgnoreCase(Constants.CO2)) {
            this.add(new CO2());
        } else {
            this.add(new O2());
        }
    }

    private class GenerateGasObserver implements GenerateGasListener {

        @Override
        public void generateGas(GenerateGasEvent event) {
            initGas(event.getType());
        }

    }

=======
    
>>>>>>> Lam
}
