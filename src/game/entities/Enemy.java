package game.entities;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import game.gamelevels.GameLevel;

/**
 * Represents a patrolling or stationary enemy in the game.
 */
public class Enemy extends Walker {

    private float leftBound;
    private float rightBound;
    private float speed = 2f;
    private boolean movingRight = true;

    /**
     * Constructs an Enemy object with patrol bounds and position.
     * If leftBound == rightBound, the enemy is stationary.
     *
     * @param world the game level world
     * @param position starting position
     * @param imagePath image path for appearance
     * @param leftBound left patrol bound
     * @param rightBound right patrol bound
     */
    public Enemy(GameLevel world, Vec2 position, String imagePath, float leftBound, float rightBound) {
        super(world, new BoxShape(0.6f, 1));
        this.setPosition(position);
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        this.addImage(new BodyImage(imagePath, 3));
    }

    /**
     * Controls left-to-right patrol movement between bounds.
     * Only applies if bounds are different.
     */
    public void patrol() {
        if (leftBound != rightBound) {
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
}
