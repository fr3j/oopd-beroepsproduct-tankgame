package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;


public class Bullet extends DynamicSpriteEntity implements Collider, SceneBorderCrossingWatcher {
    private TankPlayer tankPlayer;

    private long lastBounceTime = 0;
    private static final long BOUNCE_COOLDOWN = 500;

    protected int damage;
    private double bulletAngle;

    private int bulletSpeed;
   public int boundaryCrossings = 0;
   public int nrBounces = 0;

    public Bullet(String sprite, Size size, TankPlayer tankPlayer, int speed, int damage, double angle) {
        super(sprite, tankPlayer.getAnchorLocation(), size);
        this.tankPlayer = tankPlayer;
        this.damage = damage;
        this.bulletSpeed = speed;
        this.bulletAngle = angle;
        setMotion(this.bulletSpeed, bulletAngle);
        setRotate(bulletAngle);
        var firesound = new SoundClip("audio/fire.wav");
        firesound.play();
    }


    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        if (border == SceneBorder.LEFT || border == SceneBorder.RIGHT) {
            mirrorAngle(0);
            boundaryCrossings++;
        } else if (border == SceneBorder.TOP || border == SceneBorder.BOTTOM) {
            mirrorAngle(180);
            boundaryCrossings++;
        }
        checkCountBoundaryCrossings(2);

    }

    public void mirrorAngle(int parameter) {
        double newAngle = parameter-bulletAngle;
        setRotate(newAngle);
        setMotion(3, newAngle);
        this.bulletAngle = newAngle;
        makeBounceSound();
        nrBounces++;
    }

    public void mirrorAngleAgainstWall() {
        double wallNormal;
        if (bulletAngle > 45 && bulletAngle < 135) {
            // bovenste kant
            wallNormal = 90;
        } else if (bulletAngle > 225 && bulletAngle < 315) {
            // onderste kant
             wallNormal = 270;
        } else {
            // links / rechts
            wallNormal = 0;
        }

        double newAngle = bulletAngle - 2 * (bulletAngle - wallNormal);
        setMotion(3, newAngle);
        setRotate(newAngle);
        this.bulletAngle = newAngle;
        makeBounceSound();
        nrBounces++;
    }


    public void makeBounceSound(){
        var bounceSound = new SoundClip("audio/bounce.wav");
        bounceSound.play();
    }
    public void checkCountBoundaryCrossings(int maxBoundaryCrossings) {
        if (boundaryCrossings >= maxBoundaryCrossings) {
            remove();
        }
    }

    public TankPlayer getPlayer(){
        return tankPlayer;
    }

    public boolean canBounce() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastBounceTime > BOUNCE_COOLDOWN) {
            lastBounceTime = currentTime;
            return true;
        }
        return false;
    }

}
