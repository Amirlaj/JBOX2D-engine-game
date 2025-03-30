package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {

    public GameWorld() {
        super();

        Shape shape = new BoxShape(30, 5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

        Shape platformShape = new BoxShape(4, 0.2f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-10, -4));

        StaticBody platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(6, 5));

        StaticBody platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(5, 0));

        StaticBody platform4 = new StaticBody(this, platformShape);
        platform4.setPosition(new Vec2(-11, 7));

        StaticBody platform5 = new StaticBody(this, platformShape);
        platform5.setPosition(new Vec2(-8, 2));
    }
}
