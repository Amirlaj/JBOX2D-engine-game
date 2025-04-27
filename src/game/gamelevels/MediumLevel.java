package game.gamelevels;

import city.cs.engine.*;
import game.Enemy;
import game.characters.Player1;
import org.jbox2d.common.Vec2;

public class MediumLevel extends GameLevel {

    public MediumLevel() {
        super("Medium Level", "medium_background.png", 0, 6);
    }

    @Override
    public void initialize() {
        Player1 player = new Player1(this);
        setPlayer(player);
        player.setPosition(new Vec2(-10, -5));

        Shape groundShape = new BoxShape(20, 0.5f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -8));

//        Shape platformShape = new BoxShape(4, 0.5f);
//        StaticBody platform1 = new StaticBody(this, platformShape);
//        platform1.setPosition(new Vec2(0, 0));
//        StaticBody platform2 = new StaticBody(this, platformShape);
//        platform2.setPosition(new Vec2(-8, -2));
//        StaticBody platform3 = new StaticBody(this, platformShape);
//        platform3.setPosition(new Vec2(8, 2));

    }
}