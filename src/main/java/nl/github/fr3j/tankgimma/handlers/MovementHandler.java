package nl.github.fr3j.tankgimma.handlers;

import javafx.scene.input.KeyCode;
import nl.github.fr3j.tankgimma.entities.TankPlayer;
import nl.github.fr3j.tankgimma.interfaces.IMoveable;

import java.util.Set;

public class MovementHandler {
    private final IMoveable mover;
    private final KeyCode upKey;
    private final KeyCode downKey;
    private final KeyCode leftKey;
    private final KeyCode rightKey;

    public MovementHandler(IMoveable mover, KeyCode upKey, KeyCode downKey, KeyCode leftKey, KeyCode rightKey) {
        this.mover = mover;
        this.upKey = upKey;
        this.downKey = downKey;
        this.leftKey = leftKey;
        this.rightKey = rightKey;
    }

    public void handleMovement(Set<KeyCode> pressedKeys) {
        double angle = mover.getAngle();

        mover.setMotion(0, angle);

        if (pressedKeys.contains(upKey)) {
            mover.setMotion(3, angle);
        } else if (pressedKeys.contains(downKey)) {
            mover.setMotion(3, angle + 180);
        } else if (pressedKeys.contains(leftKey)) {
            angle += TankPlayer.ROTATION_INCREMENT;
            mover.setRotate(angle);
        } else if (pressedKeys.contains(rightKey)) {
            angle -= TankPlayer.ROTATION_INCREMENT;
            mover.setRotate(angle);
        } else if (pressedKeys.isEmpty()) {
            mover.setSpeed(0);
        }

        mover.setAngle(angle);
    }


}
