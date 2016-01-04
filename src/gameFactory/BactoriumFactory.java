/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameFactory;

import Utils.Constants;
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
    private ParticleCollider prCollider;
    private final HeroCollider collider;

    public BactoriumFactory(String string) {
        super(string);

        player = new Player();
        this.add(player);

        collider = new HeroCollider();
        collider.setCollisionGroup(this, this);
    }

    public Bacterium getBacterium(int i) {
        return (Bacterium) this.getSprites()[i];
    }

    public void setPrFac(ParticleFactory prFac) {
        this.prFac = prFac;
        prCollider = new ParticleCollider();
        prCollider.setCollisionGroup(this, prFac);

        player.getSpecialization().addGasListener(prFac.getObserver());
        initBoss(20);
    }

    public void update() {
        collider.checkCollision();

        try {

            prCollider.checkCollision();
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.err.println(exc.toString());
        }
    }

    private void initBoss(int number) {
        for (int i = 0; i < number; i++) {
            Computer comp = new Computer();
            this.add(comp);
            comp.getSpecialization().addGasListener(prFac.getObserver());
        }
    }

    @Override
    public void update(long l) {
        super.update(l); //To change body of generated methods, choose Tools | Templates.
    }

    private class HeroCollider extends BasicCollisionGroup {

        Random rand = new Random();

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
                    player.updateSize(true);
                    player.setScore(player.getScore() + 3);
                    player.upgrade();
                } else {
                    if (computer1.getSpecialization().canEat(player.getSpecialization())) {
                        player.setActive(false);
                    }
                }
            } else {
                if (computer1.getSpecialization().canEat(computer2.getSpecialization())) {
                    computer2.setActive(false);
                    BactoriumFactory.this.remove(computer2);
                    computer1.updateSize(true);
                    computer1.setScore(computer1.getScore() + 3);
                    computer1.upgrade();

                } else if (computer2.getSpecialization().canEat(computer1.getSpecialization())) {
                    computer1.setActive(false);
                    BactoriumFactory.this.remove(computer1);
                    computer2.updateSize(true);
                    computer2.setScore(computer2.getScore() + 3);
                    computer2.upgrade();;
                }
            }

            if (BactoriumFactory.this.getSize() < 10) {
                initBoss(rand.nextInt(10));
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

                BactoriumFactory.this.prFac.remove(pr);
                boolean x = !(pr.getType().equalsIgnoreCase(Constants.CO2)
                        || pr.getType().equalsIgnoreCase(Constants.O2));

                if (x) {
                    BactoriumFactory.this.prFac.updateNumberNormal();
                }

                br.setScore(br.getScore() + (x ? 1 : 0));
                br.updateSize(x);

                br.upgrade();
                System.out.print(BactoriumFactory.this.prFac.getNumberNormal() + " -> ");

                if (BactoriumFactory.this.prFac.getNumberNormal() < 80) {
                    BactoriumFactory.this.prFac.randParticle(20);
                }
                System.out.println(BactoriumFactory.this.prFac.getNumberNormal());
            }
        }
    }
}
