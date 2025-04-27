package game.gamelevels;

import city.cs.engine.*;
import game.Enemy;
import game.characters.Player1;
import org.jbox2d.common.Vec2;

public class EasyLevel extends GameLevel {

    public EasyLevel() {
        super("Easy Level", "easy_background.png", 0, 3);
    }

    @Override
    public void initialize() {
        Player1 player = new Player1(this);
        setPlayer(player);
        player.setPosition(new Vec2(0, -5));

        Shape groundShape = new BoxShape(15, 0.5f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -8));

        new Enemy(this, new Vec2(4, 0), "data/enemy1.png", 2, 7);
    }
}