package game.gamelevels;

import city.cs.engine.*;
import game.Enemy;
import game.characters.Player1;
import org.jbox2d.common.Vec2;

/**
 * MediumLevel sets up a moderately challenging level with multiple enemies.
 */
public class MediumLevel extends GameLevel {

    public MediumLevel() {
        super("Medium Level", "medium_background.png", 0, 6); // harder kill goal
    }
    Player1 player = new Player1(this);

    @Override
    public void initialize() {
        // === PLAYER SETUP ===
        Player1 player = new Player1(this);
        setPlayer(player);
        player.setPosition(new Vec2(-10, -5));

        // === GROUND PLATFORM ===
        Shape groundShape = new BoxShape(20, 0.5f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -8));

        // === FLOATING PLATFORMS ===
        Shape platformShape = new BoxShape(4, 0.5f);

        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(0, 0));

        StaticBody platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(-8, -2));

        StaticBody platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(8, 2));

        // === ENEMIES ===
        new Enemy(this, new Vec2(3, -5), "data/enemy1.png", 2, 7);
        new Enemy(this, new Vec2(-5, 0), "data/enemy2.png", -6, -2);
        new Enemy(this, new Vec2(5, 2), "data/enemy1.png", 4, 8);
    }
}
