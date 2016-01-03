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

/**
 *
 * @author trung
 */
public class BactoriumFactory extends SpriteGroup {

    private final Player player;
    private ParticleFactory prFac;
    private ParticleCollider prCollider;
    private final HeroCollider collider;

    public BactoriumFactory(String string) {
        super(string);

        player = new Player();
        this.add(player);
        initBoss(20);

        collider = new HeroCollider();
        collider.setCollisionGroup(this, this);
    }

    public Bacterium getBacterium(int i){
        return (Bacterium)this.getSprites()[i];
    }
    
    public void setPrFac(ParticleFactory prFac) {
        this.prFac = prFac;
        prCollider = new ParticleCollider();
        prCollider.setCollisionGroup(this, prFac);

    }

    public void update() {
        collider.checkCollision();
        prCollider.checkCollision();
    }

    private void initBoss(int number) {
        for (int i = 0; i < number; i++) {
            this.add(new Computer());
        }
    }

    @Override
    public void update(long l) {
        super.update(l); //To change body of generated methods, choose Tools | Templates.
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
                    player.setScore(player.getScore() + 3);
                } else {
                    player.setActive(false);
                }
            } else {
                if (computer1.getSpecialization().canEat(computer2.getSpecialization())) {
                    computer2.setActive(false);
                    BactoriumFactory.this.remove(computer2);
                    computer1.updateSize();

                } else if (computer2.getSpecialization().canEat(computer1.getSpecialization())) {
                    computer1.setActive(false);
                    BactoriumFactory.this.remove(computer1);
                    computer2.updateSize();
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
                BactoriumFactory.this.prFac.remove(pr);
                if (br instanceof Player){
                    br.setScore(br.getScore() + 1);
                }
            }
        }

    }

}
