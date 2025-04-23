package game.gamelevels;

import city.cs.engine.*;
import game.Coin;
import game.Enemy;
import org.jbox2d.common.Vec2;

public class MediumLevel extends GameLevel {

    public MediumLevel() {
        super("Medium Level", "medium_background.png", 8); // higher goalScore
    }

    @Override
    public void initialize() {
        // Set the player's start position
        getPlayer().setPosition(new Vec2(-10, -10));

        // Add ground
        Shape groundShape = new BoxShape(15, 0.5f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11));

        // Add more coins
        new Coin(this, new Vec2(-10, -5));
        new Coin(this, new Vec2(-5, -5));
        new Coin(this, new Vec2(0, -5));
        new Coin(this, new Vec2(5, -5));
        new Coin(this, new Vec2(10, -5));

        // Add two enemies with different patrol ranges
        new Enemy(this, new Vec2(2, 0), "data/enemy1.png", 1, 6);
        new Enemy(this, new Vec2(-6, 0), "data/enemy2.png", -8, -2);
    }
}
