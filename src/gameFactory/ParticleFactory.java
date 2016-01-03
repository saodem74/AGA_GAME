/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameFactory;

import com.golden.gamedev.object.SpriteGroup;
import gameModel.particles.Agar;
import gameModel.particles.Light;
import gameModel.particles.Water;

/**
 *
 * @author trung
 */
public class ParticleFactory extends SpriteGroup{

    public ParticleFactory(String string) {
        super(string);
        initAgar(100);
        initLight(100);
        initWater(100);
    }

    private void initAgar(int num){
        for (int i = 0; i < num; i++){
            this.add(new Agar());
        }
    }
    private void initLight(int num){
        for (int i = 0; i < num; i++){
            this.add(new Light());
        }
    }
    private void initWater(int num){
        for (int i = 0; i < num; i++){
            this.add(new Water());
        }
    }
}
