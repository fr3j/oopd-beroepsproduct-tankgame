package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.tutorial.scenes.GameScene;
import javafx.scene.input.KeyCode;

import java.util.Set;


public class TankPlayer2 extends TankPlayer {
    private final MovementHandler movementHandler;

    public TankPlayer2(Coordinate2D location, GameScene gamescene, Scoreboard scoreboard) {
        super(location, gamescene, scoreboard);
        movementHandler = new MovementHandler(this, angle, KeyCode.UP, KeyCode.DOWN, KeyCode.LEFT, KeyCode.RIGHT);
    }
    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        shootingHandler.handleShooting(pressedKeys);
        beforeMove();
        movementHandler.handleMovement(pressedKeys);

        if (pressedKeys.contains(KeyCode.SHIFT)) {
            activateShield();
        }

        adjustShieldPosition();
    }
    @Override
    protected KeyCode getShootingKey() {
        return KeyCode.ENTER;
    }

    @Override
    public void setAngle(double angle) {
        this.angle = angle;
    }
}