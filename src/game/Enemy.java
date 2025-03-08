package game;
import city.cs.engine.*;

import org.jbox2d.common.Vec2;

public class Enemy extends Walker {
    public Enemy(GameWorld gameWorld, Vec2 position, String imagePath) {
        super(gameWorld, new BoxShape(1, 1));
        this.setPosition(position);
        this.addImage(new BodyImage(imagePath, 3));
    }
}
