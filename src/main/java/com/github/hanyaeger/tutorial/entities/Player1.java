package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.tutorial.scenes.GameScene;
import javafx.scene.input.KeyCode;
import java.util.Set;


public class Player1 extends Player{


    public Player1(Coordinate2D location, GameScene gamescene, Scoreboard scoreboard) {
        super(location, gamescene, scoreboard);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {

        double newAngle = angle;

        setMotion(0, angle);

        if (pressedKeys.contains(KeyCode.A)) {
            newAngle = this.angle + rotationIncrement;
            setRotate(newAngle);
        } else if (pressedKeys.contains(KeyCode.D)) {
            newAngle = this.angle - rotationIncrement;
            setRotate(newAngle);

        } else if (pressedKeys.contains(KeyCode.W)) {
            setMotion(3, angle);

        } else if (pressedKeys.contains(KeyCode.S)) {
            setMotion(3, angle + 180);

        } else if (pressedKeys.contains(KeyCode.SPACE)) {
            shoot();
        } else if (pressedKeys.isEmpty()) {
            setSpeed(0);
        }
        this.angle = newAngle;


    }
}
