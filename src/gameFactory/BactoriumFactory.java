/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameFactory;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.collision.BasicCollisionGroup;
import gameModel.hero.Bacterium;
import gameModel.hero.Computer;
import gameModel.hero.Player;
import gameModel.particles.Particle;
import java.util.Random;

/**
 *
 * @author trung
 */
public class BactoriumFactory extends SpriteGroup {

    private final Player player;
    private ParticleFactory prFac;

    public BactoriumFactory(String string) {
        super(string);

        player = new Player();
        this.add(player);
        initBoss(20);

        HeroCollider collider = new HeroCollider();
        collider.setCollisionGroup(this, this);

        ParticleCollider prCollider = new ParticleCollider();
        prCollider.setCollisionGroup(this, prFac);
    }

    public void setPrFac(ParticleFactory prFac) {
        this.prFac = prFac;
    }

    private void initBoss(int number) {
        for (int i = 0; i < number; i++) {
            this.add(new Computer());
        }
    }

    private class HeroCollider extends BasicCollisionGroup {

        public HeroCollider() {
            pixelPerfectCollision = true;
        }

        @Override
        public void collided(Sprite sprite, Sprite sprite1) {

            Player player = null;
            Computer computer1 = null, computer2 = null;

            if (sprite instanceof Player) {
                player = (Player) sprite;
                computer1 = (Computer) sprite1;
            } else {
                if (sprite1 instanceof Player) {
                    computer1 = (Computer) sprite;
                    player = (Player) sprite1;
                } else {
                    computer1 = (Computer) sprite;
                    computer2 = (Computer) sprite1;
                }
            }

            if (player != null) {
                if (player.getSpecialization().canEat(computer1.getSpecialization())) {
                    computer1.setActive(false);
                    BactoriumFactory.this.remove(computer1);
                    player.updateSize();
                }
            } else {
                if (computer1.getSpecialization().canEat(computer2.getSpecialization())) {
                    computer2.setActive(false);
                    BactoriumFactory.this.remove(computer1);
                    computer2.updateSize();

                } else if (computer2.getSpecialization().canEat(computer1.getSpecialization())) {
                    computer2.setActive(false);
                    BactoriumFactory.this.remove(computer2);
                    computer1.updateSize();
                }

            }
        }

    }

    private class ParticleCollider extends BasicCollisionGroup {

        public ParticleCollider() {
            pixelPerfectCollision = true;
        }

        @Override
        public void collided(Sprite sprite, Sprite sprite1) {
            Bacterium br = (Bacterium) sprite;
            Particle pr = (Particle) sprite1;
            if (br.getSpecialization().canEat(pr)) {
                pr.setActive(false);
                br.updateSize();
            }
        }

    }

}
