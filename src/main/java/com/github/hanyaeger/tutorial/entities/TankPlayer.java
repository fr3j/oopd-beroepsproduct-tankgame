package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.entities.map.Wall;
import com.github.hanyaeger.tutorial.scenes.GameScene;
import javafx.scene.input.KeyCode;

import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public abstract class TankPlayer extends DynamicSpriteEntity implements IMoveable, Shootable, SceneBorderCrossingWatcher, KeyListener, Collided {

    private static final int INITIAL_LIVES = 3;
    protected static final double ROTATION_INCREMENT = 10;

    protected double angle = 0;
    private GameScene gameScene;
    private int lives = INITIAL_LIVES;
    private Scoreboard scoreboard;
    private Coordinate2D previousPosition;
    private Coordinate2D lastPositionBeforeMove;
    private BasicShield tankShield;
    private boolean usedShieldInThisLife = false;
    private boolean canShoot = true;
    private Timer shootTimer = new Timer();
    protected ShootingHandler shootingHandler;
    private Bullet bullet;


    public TankPlayer(Coordinate2D location, GameScene gameScene, Scoreboard scoreboard) {
        super("sprites/tank.png", location, new Size(40, 40));
        this.gameScene = gameScene;
        this.scoreboard = scoreboard;
        initializePlayer();
    }

    private void initializePlayer() {
        scoreboard.setLives(lives);
        tankShield = new BasicShield(getAnchorLocation());
        gameScene.addEntityToScene(tankShield);
        shootingHandler = new ShootingHandler(this, getShootingKey());
    }

    protected abstract KeyCode getShootingKey();

    @Override
    public abstract void onPressedKeysChange(Set<KeyCode> pressedKeys);

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorLocationX(getSceneWidth());
        setAnchorLocationY(getSceneHeight());
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Bullet) {
            handleBulletCollision((Bullet) collider);
        } else if (collider instanceof Wall) {
            handleWallCollision();
        }
    }

    private void handleBulletCollision(Bullet bullet) {
        if (bullet.getPlayer() != this) {
            bullet.remove();

            if (tankShield.isActive()) {
                tankShield.deactivate();
            } else {
                lives--;
                scoreboard.setLives(lives);
                playExplosionSound();
                if (lives == 0) {
                    remove();
                    gameScene.gameOver();
                } else {
                    resetPlayerPosition();
                }
            }
        }
    }

    private void playExplosionSound() {
        SoundClip explosionSound = new SoundClip("audio/explosion.wav");
        explosionSound.play();
    }

    private void handleWallCollision() {
        setAnchorLocation(lastPositionBeforeMove);
    }

    @Override
    public void shoot() {
        if (canShoot) {
            double tankAngle = this.getAngle();
            Bullet bullet = new Bullet("sprites/bullet.png", new Size(30, 30), this, 4, 1, tankAngle);
            gameScene.addEntityToScene(bullet);
            disableShootingTemporarily();
        }
    }


    private void disableShootingTemporarily() {
        canShoot = false;
        shootTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                canShoot = true;
            }
        }, 1000);
    }

    public void resetPlayerPosition() {
        Coordinate2D newPosition = generateRandomPosition();
        while (newPosition.equals(previousPosition)) {
            newPosition = generateRandomPosition();
        }
        setAnchorLocation(newPosition);
        previousPosition = newPosition;
    }

    private Coordinate2D generateRandomPosition() {
        int random = (int) (Math.random() * 4);
        return switch (random) {
            case 0 -> new Coordinate2D(100, 100);
            case 1 -> new Coordinate2D(100, 500);
            case 2 -> new Coordinate2D(700, 100);
            case 3 -> new Coordinate2D(700, 500);
            default -> throw new IllegalStateException("Unexpected random value: " + random);
        };
    }

    public void activateShield() {
        if (!tankShield.isActive() && !usedShieldInThisLife) {
            tankShield.activate();
            usedShieldInThisLife = true;
        }
    }

    public void adjustShieldPosition() {
        tankShield.setAnchorLocation(this.getAnchorLocation());
    }

    protected void beforeMove() {
        lastPositionBeforeMove = getAnchorLocation();
    }

    @Override
    public void setCanShoot(boolean canShoot) {
        this.canShoot = canShoot;
    }

    @Override
    public GameScene getGameScene() {
        return this.gameScene;
    }

    @Override
    public Bullet getBullet() {
        return this.bullet;
    }

    @Override
    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    @Override
    public boolean canShoot() {
        return this.canShoot;
    }

    @Override
    public void setMotion(double speed, double direction) {
        super.setMotion(speed, direction);
    }

    @Override
    public void setRotate(double angle) {
        super.setRotate(angle);
    }

    @Override
    public void setSpeed(double speed) {
        super.setSpeed(speed);
    }
    @Override
    public double getAngle(){
        return this.angle;
    }

    @Override
    public void setAngle(double angle){
        this.angle = angle;
    }
}


