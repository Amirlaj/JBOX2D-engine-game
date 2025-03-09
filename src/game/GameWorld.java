package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {

    public GameWorld() {

        super();
        Shape shape = new BoxShape(30, 3f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

        Shape platformShape = new BoxShape(3, 0.5f);

        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-8, -4f));

        StaticBody platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(8, -4f));

        StaticBody platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(5, -2f)); // Adjust placement

    }
}
