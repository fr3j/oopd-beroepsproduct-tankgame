package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.tutorial.scenes.GameScene;

public interface Shootable {
    void shoot();
    boolean canShoot();
    void setCanShoot(boolean canShoot);
    GameScene getGameScene();
    Bullet getBullet();
    void setBullet(Bullet bullet);

    double getAngle();
}

