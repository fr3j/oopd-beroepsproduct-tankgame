package nl.github.fr3j.tankgimma.entities;

import com.github.hanyaeger.api.Coordinate2D;
import nl.github.fr3j.tankgimma.core.Scoreboard;
import nl.github.fr3j.tankgimma.handlers.MovementHandler;
import nl.github.fr3j.tankgimma.scenes.GameScene;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class TankPlayer1 extends TankPlayer {
    private final MovementHandler movementHandler;

    public TankPlayer1(Coordinate2D location, GameScene gamescene, Scoreboard scoreboard) {
        super(location, gamescene, scoreboard);
        movementHandler = new MovementHandler(this, KeyCode.W, KeyCode.S, KeyCode.A, KeyCode.D);
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


}
