package nl.github.fr3j.tankgimma.interfaces;

import nl.github.fr3j.tankgimma.entities.Bullet;
import nl.github.fr3j.tankgimma.scenes.GameScene;

public interface Shootable {
    void shoot();
    boolean canShoot();
    void setCanShoot(boolean canShoot);
    GameScene getGameScene();
    Bullet getBullet();
    void setBullet(Bullet bullet);

    double getAngle();
}

