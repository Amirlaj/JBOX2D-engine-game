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
        platform1.setPosition(new Vec2(-10, -2));

        StaticBody platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(6, 3));

        StaticBody platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(3, 0));

        StaticBody platform4 = new StaticBody(this, platformShape);
        platform4.setPosition(new Vec2(-11, 5));

    }
}
