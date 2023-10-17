package com.github.hanyaeger.tutorial.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.tutorial.entities.Bullet;

public class Wall extends SpriteEntity implements Collided {

    public Wall(Coordinate2D initialPosition, Size size, String sprite) {
        super(sprite, initialPosition, size);
    }


    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Bullet bullet) {
            if (bullet.canBounce()) {
                bullet.mirrorAngleAgainstWall();
            }
        }
    }
}
