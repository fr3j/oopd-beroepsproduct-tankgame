package nl.github.fr3j.tankgimma.core;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Scoreboard extends TextEntity {

    public Scoreboard(Coordinate2D initialLocation) {
        super(initialLocation);
        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.BLACK);
    }

    public void setLives(int lives) {
        setText("Lives: " + lives);
    }
}