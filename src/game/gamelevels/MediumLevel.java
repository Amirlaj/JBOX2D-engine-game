package game.gamelevels;

import city.cs.engine.*;
import game.entities.Enemy;
import game.entities.Jumper;
import game.entities.MaxHealthPickup;
import game.characters.Player1;
import org.jbox2d.common.Vec2;

/**
 * MediumLevel introduces more complexity with powerups and elevated platforms.
 */
public class MediumLevel extends GameLevel {

    /**
     * Constructs a new MediumLevel.
     */
    public MediumLevel() {
        super("Medium Level", "Medium_Background.png", 0, 1);
    }

    /**
     * Initializes the level with player, one enemy, a jetpack, and a health pickup.
     */
    @Override
    public void initialize() {
        // Create and position Player 1
        Player1 player = new Player1(this);
        setPlayer(player);
        player.setPosition(new Vec2(-10, -5));

        // Create ground
        Shape groundShape = new BoxShape(20, 0.5f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -8));

        // Powerups
        Jumper jumper = new Jumper(this);
        jumper.setPosition(new Vec2(0, -6));
        addEntity(jumper);

        MaxHealthPickup healthPickup = new MaxHealthPickup(this);
        healthPickup.setPosition(new Vec2(7, -6));
        addEntity(healthPickup);

        // Elevated platform
        Shape platformShape = new BoxShape(3, 0.5f);
        StaticBody topRightPlatform = new StaticBody(this, platformShape);
        topRightPlatform.setPosition(new Vec2(12, 3.5f));
        addEntity(topRightPlatform);

        // Stationary enemy on the platform
        Enemy topRightEnemy = new Enemy(this, new Vec2(12, 4), "data/enemy1.png", 0, 0);
        addEntity(topRightEnemy);
    }
}
