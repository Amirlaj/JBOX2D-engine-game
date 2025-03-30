package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Enemy extends Walker {

    private float leftBound;
    private float rightBound;
    private float speed = 2f;
    private boolean movingRight = true;

    public Enemy(GameWorld world, Vec2 position, String imagePath, float leftBound, float rightBound) {
        super(world, new BoxShape(0.6f, 1));  // enemy size
        this.setPosition(position);
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        this.addImage(new BodyImage(imagePath, 3));
    }

    public void patrol() {
        // Switch direction if enemy hits bounds
        if (movingRight) {
            this.setLinearVelocity(new Vec2(speed, getLinearVelocity().y));
            if (this.getPosition().x > rightBound) {
                movingRight = false;
            }
        } else {
            this.setLinearVelocity(new Vec2(-speed, getLinearVelocity().y));
            if (this.getPosition().x < leftBound) {
                movingRight = true;
            }
        }
    }
}
