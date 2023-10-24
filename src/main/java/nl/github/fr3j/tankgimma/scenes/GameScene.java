package nl.github.fr3j.tankgimma.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import nl.github.fr3j.tankgimma.core.Game;
import nl.github.fr3j.tankgimma.entities.TankPlayer1;
import nl.github.fr3j.tankgimma.entities.TankPlayer2;
import nl.github.fr3j.tankgimma.core.Scoreboard;
import nl.github.fr3j.tankgimma.ui.map.WallTileMap;

public class GameScene extends DynamicScene implements TileMapContainer {
    public final Game game;
    public GameScene(Game game) {
        this.game = game;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/gameaudio.mp3");
    }

    @Override
    public void setupEntities() {
        var scoreboard1 = new Scoreboard(new Coordinate2D(100, 50));
        addEntity(scoreboard1);
        var player1 = new TankPlayer1(new Coordinate2D(100, 100), this, scoreboard1);
        addEntity(player1);

        var scoreboard2 = new Scoreboard(new Coordinate2D(700, 450));
        addEntity(scoreboard2);
        var player2 = new TankPlayer2(new Coordinate2D(700, 500), this, scoreboard2);
        addEntity(player2);


    }


    public void gameOver() {
        game.setActiveScene(2);
    }


    public void addEntityToScene(YaegerEntity entity) {
        addEntity(entity);
    }


    @Override
    public void setupTileMaps() {
        addTileMap(new WallTileMap());
    }
}
