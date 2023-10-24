package nl.github.fr3j.tankgimma.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import nl.github.fr3j.tankgimma.entities.Bullet;

public class Wall extends SpriteEntity implements Collided, Collider {
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
