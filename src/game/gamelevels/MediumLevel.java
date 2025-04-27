package game.gamelevels;

import city.cs.engine.*;
import game.entities.Enemy;
import game.entities.Jumper;
import game.entities.MaxHealthPickup;
import game.characters.Player1;
import org.jbox2d.common.Vec2;

public class MediumLevel extends GameLevel {

    public MediumLevel() {
        super("Medium Level", "Medium_Background.png", 0, 1);
    }

    @Override
    public void initialize() {
        Player1 player = new Player1(this);
        setPlayer(player);
        player.setPosition(new Vec2(-10, -5));

        Shape groundShape = new BoxShape(20, 0.5f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -8));


        new Jumper(this).setPosition(new Vec2(0, -6));
        new MaxHealthPickup(this).setPosition(new Vec2(7, -6));

        Shape topRightPlatformShape = new BoxShape(3, 0.5f);
        StaticBody topRightPlatform = new StaticBody(this, topRightPlatformShape); // ✅ different name
        topRightPlatform.setPosition(new Vec2(12, 3.5f));
        addEntity(topRightPlatform);


// Stable enemy (no patrol)
        Enemy topRightEnemy = new Enemy(this, new Vec2(12, 4), "data/enemy1.png", 0, 0); // bounds won't matter since no patrol
        addEntity(topRightEnemy);




    }


}