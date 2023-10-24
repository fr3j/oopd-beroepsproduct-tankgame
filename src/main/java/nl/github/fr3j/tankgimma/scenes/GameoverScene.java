package nl.github.fr3j.tankgimma.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.github.fr3j.tankgimma.core.Game;
import nl.github.fr3j.tankgimma.ui.buttons.StartButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameoverScene extends DynamicScene {
    public final Game game;

    public GameoverScene(Game game) {
        this.game = game;
    }

    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        var gameovertext = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Game Over"
        );
        gameovertext.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        gameovertext.setFill(Color.WHITE);
        gameovertext.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(gameovertext);

        var startButton = new StartButton(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 100), game);
        startButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        addEntity(startButton);
    }

}
