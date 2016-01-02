/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameFactory;

import com.golden.gamedev.object.SpriteGroup;
import gameModel.particles.Agar;

/**
 *
 * @author trung
 */
public class ParticleFactory extends SpriteGroup{

    public ParticleFactory(String string) {
        super(string);
        initAgar(200);
    }

    private void initAgar(int num){
        for (int i = 0; i < num; i++){
            this.add(new Agar());
        }
    }
}
