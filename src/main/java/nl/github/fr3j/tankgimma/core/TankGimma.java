package nl.github.fr3j.tankgimma.core;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.api.Size;
import nl.github.fr3j.tankgimma.scenes.GameScene;
import nl.github.fr3j.tankgimma.scenes.GameoverScene;
import nl.github.fr3j.tankgimma.scenes.TitleScene;
public class TankGimma extends YaegerGame {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("TankGimma");
        setSize(new Size(800, 600));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new GameScene(this));
        addScene(2, new GameoverScene(this));
    }
}
