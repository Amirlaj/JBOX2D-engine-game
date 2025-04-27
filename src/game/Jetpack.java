package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Jetpack extends StaticBody {

    private static final Shape shape = new BoxShape(0.5f, 0.5f);

    public Jetpack(World world, Vec2 position) {
        super(world, shape);
        addImage(new BodyImage("data/books.png", 1f));
        setPosition(position);
    }
}
