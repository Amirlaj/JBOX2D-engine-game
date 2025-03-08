package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {

    public GameWorld() {
        super();
        //make a ground platform
        Shape shape = new BoxShape(30, 3f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

        // make a suspended platform
        Shape platformShape = new BoxShape(3, 0.5f);

        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-8, -4f));
//        platform1.addImage(new BodyImage("data/platform.png", 1f));

        // make another platform
        StaticBody platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(8, -4f));

        // make another platform
        StaticBody platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(5, -2f)); // Adjust placement


    }
}
