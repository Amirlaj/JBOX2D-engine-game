package game.gamelevels;

import game.Coin;
import game.Enemy;
import org.jbox2d.common.Vec2;

public class EasyLevel extends GameLevel {

    public EasyLevel() {
        super("Easy Level", "easy_background.png", 5); // name, background, goalScore
    }

    @Override
    public void initialize() {
        super.initialize(); // Print info and background setup

        // Add entities like coins and enemies
        addEntity(new Coin(null, new Vec2(0, -3))); // Replace `null` with the game world
        addEntity(new Enemy(null, new Vec2(3, 3), "data/enemy1.png", 1, 6)); // Same here
    }
}
