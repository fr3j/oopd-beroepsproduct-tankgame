package nl.github.fr3j.tankgimma.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import nl.github.fr3j.tankgimma.core.TankGimma;
import nl.github.fr3j.tankgimma.ui.buttons.StartButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleScene extends StaticScene {

    private final TankGimma game;
    public TitleScene(TankGimma game) {
        this.game = game;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background.jpeg");
    }

    @Override
    public void setupEntities(){
        var gameText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "YaegerTanks"
        );
        gameText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        gameText.setFill(Color.WHITE);
        gameText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(gameText);

        var startButton = new StartButton(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 100), game);
        startButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        addEntity(startButton);
    }
}
