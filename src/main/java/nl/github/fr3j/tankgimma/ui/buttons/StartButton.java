package nl.github.fr3j.tankgimma.ui.buttons;

import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import nl.github.fr3j.tankgimma.core.TankGimma;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import com.github.hanyaeger.api.Coordinate2D;

public class StartButton extends TextEntity implements MouseButtonPressedListener {
    private final TankGimma game;
    public StartButton (Coordinate2D initialLocation, TankGimma game){
        super(initialLocation,"Play game");
        this.game = game;
        setFill(Color.BEIGE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 48));
        setStrokeColor(Color.BLACK);
        setStrokeWidth(2);
    }


    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        game.setActiveScene(1);
    }
}
