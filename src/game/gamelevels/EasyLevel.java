package game.gamelevels;

import city.cs.engine.*;
import game.Enemy;
import game.characters.Player1;
import org.jbox2d.common.Vec2;

/**
 * EasyLevel sets up a simple level with coins and one enemy.
 */
public class EasyLevel extends GameLevel {

    public EasyLevel() {
        super("Easy Level", "easy_background.png", 0, 3); // now using kill goal only
    }
    Player1 player = new Player1(this);

    @Override
    public void initialize() {
        Player1 player = new Player1(this); // ✅ create player
        setPlayer(player);                  // ✅ assign it
        player.setPosition(new Vec2(0, -5)); // now safe to use

        // Ground platform
        Shape groundShape = new BoxShape(15, 0.5f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -8));

        // Add a single enemy
        new Enemy(this, new Vec2(4, 0), "data/enemy1.png", 2, 7);
    }

}
