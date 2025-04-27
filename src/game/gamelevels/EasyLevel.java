package game.gamelevels;

import city.cs.engine.*;
import game.entities.Enemy;
import game.characters.Player1;
import org.jbox2d.common.Vec2;

public class EasyLevel extends GameLevel {

    public EasyLevel() {
        super("Easy Level", "Background.png", 0, 2);
    }

    @Override
    public void initialize() {
        Player1 player = new Player1(this);
        setPlayer(player);
        player.setPosition(new Vec2(0, -5));

        Shape groundShape = new BoxShape(15, 0.5f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -8));

        Enemy enemy1 = new Enemy(this, new Vec2(4, -6), "data/enemy1.png", 2, 7);
        Enemy enemy2 = new Enemy(this, new Vec2(-6, -6), "data/enemy2.png", -8, -4);


    }


}