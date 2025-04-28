package game.gamelevels;

import city.cs.engine.*;
import game.entities.Enemy;
import game.entities.Jumper;
import game.entities.MaxHealthPickup;
import game.characters.Player1;
import org.jbox2d.common.Vec2;

/**MediumLevel*/
public class MediumLevel extends GameLevel {





    public MediumLevel() {
        super("Medium Level", "Background.png",  2);
    }
    /** two enemy, a jetpack, and a health pickup. */
    @Override
    public void initialize() {
        Player1 player = new Player1(this);
        setPlayer(player);
        player.setPosition(new Vec2(-10, -5));
        // Create ground
        Shape groundShape = new BoxShape(20, 0.5f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -7));

        Jumper jumper = new Jumper(this);
        jumper.setPosition(new Vec2(0, -5));
        addEntity(jumper);
        MaxHealthPickup healthPickup = new MaxHealthPickup(this);
        healthPickup.setPosition(new Vec2(10, -5));
        addEntity(healthPickup);
        // Elevated platform
        Shape platformShape = new BoxShape(3, 0.5f);
        StaticBody topRightPlatform = new StaticBody(this, platformShape);
        topRightPlatform.setPosition(new Vec2(12, 3.5f));
        addEntity(topRightPlatform);
        // Stationary enemy on the platform
        Enemy topRightEnemy = new Enemy(this, new Vec2(12, 4), "data/enemy1.png", 12, 12);
        addEntity(topRightEnemy);

        Enemy groundEnemy = new Enemy(this, new Vec2(0, 7), "data/enemy1.png", 4, 8);
        addEntity(groundEnemy);
    }
}
