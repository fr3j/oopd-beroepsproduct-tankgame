package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.tutorial.scenes.GameScene;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class TankPlayer1 extends TankPlayer {
    private final MovementHandler movementHandler;

    public TankPlayer1(Coordinate2D location, GameScene gamescene, Scoreboard scoreboard) {
        super(location, gamescene, scoreboard);
        movementHandler = new MovementHandler(this, angle, KeyCode.W, KeyCode.S, KeyCode.A, KeyCode.D);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        shootingHandler.handleShooting(pressedKeys);
        beforeMove();
        movementHandler.handleMovement(pressedKeys);

        if (pressedKeys.contains(KeyCode.Q)) {
            activateShield();
        }

        adjustShieldPosition();
    }

    @Override
    protected KeyCode getShootingKey() {
        return KeyCode.SPACE;
    }

    @Override
    public void setAngle(double angle) {
    this.angle = angle;
    }
}
