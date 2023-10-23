package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Size;
import javafx.scene.input.KeyCode;

import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class ShootingHandler {
    private final Shootable shooter;
    private final KeyCode shootingKey;
    private Timer shootTimer = new Timer();

    public ShootingHandler(Shootable shooter, KeyCode shootingKey) {
        this.shooter = shooter;
        this.shootingKey = shootingKey;
    }

    public void handleShooting(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(shootingKey)) {
            shoot();
        }
    }

    private void shoot() {
        if (shooter.canShoot()) {
            double tankAngle = shooter.getAngle();
            Bullet bullet = new Bullet("sprites/bullet.png", new Size(30, 30), (TankPlayer) shooter, 4, 1, tankAngle);
            shooter.getGameScene().addEntityToScene(bullet);
            shooter.setBullet(bullet);
            disableShootingTemporarily();
        }
    }


    private void disableShootingTemporarily() {
        shooter.setCanShoot(false);
        shootTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                shooter.setCanShoot(true);
            }
        }, 1000);
    }
}
