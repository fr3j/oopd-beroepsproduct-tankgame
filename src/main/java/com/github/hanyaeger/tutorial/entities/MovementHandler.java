package com.github.hanyaeger.tutorial.entities;

import javafx.scene.input.KeyCode;

import java.util.Set;

public class MovementHandler {
    private final IMoveable mover;
    private double angle;
    private final KeyCode upKey;
    private final KeyCode downKey;
    private final KeyCode leftKey;
    private final KeyCode rightKey;

    public MovementHandler(IMoveable mover, double angle, KeyCode upKey, KeyCode downKey, KeyCode leftKey, KeyCode rightKey) {
        this.mover = mover;
        this.angle = angle;
        this.upKey = upKey;
        this.downKey = downKey;
        this.leftKey = leftKey;
        this.rightKey = rightKey;
    }

    public void handleMovement(Set<KeyCode> pressedKeys) {
        double newAngle = angle;

        mover.setMotion(0, angle);

        if (pressedKeys.contains(upKey)) {
            mover.setMotion(3, angle);
        } else if (pressedKeys.contains(downKey)) {
            mover.setMotion(3, angle + 180);
        } else if (pressedKeys.contains(leftKey)) {
            newAngle = angle + TankPlayer.ROTATION_INCREMENT;
            mover.setRotate(newAngle);
        } else if (pressedKeys.contains(rightKey)) {
            newAngle = angle - TankPlayer.ROTATION_INCREMENT;
            mover.setRotate(newAngle);
        } else if (pressedKeys.isEmpty()) {
            mover.setSpeed(0);
        }

        mover.setAngle(newAngle);
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getAngle() {
        return angle;
    }
}
