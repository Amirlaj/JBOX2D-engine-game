package game.entities;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import game.gamelevels.GameLevel;

/** @param world the game level world
 * @param position starting position
 * @param imagePath image path for appearance
 * @param leftBound patrol left limit (if same as rightBound, enemy is stationary)
 * @param rightBound patrol right limit */
/**Represents a patrolling or stationary enemy in the game.*/
public class Enemy extends Walker implements StepListener {
    private float leftBound;
    private float rightBound;
    private float speed = 2f;
    private boolean movingRight = true;
    public Enemy(GameLevel world, Vec2 position, String imagePath, float leftBound, float rightBound) {
        super(world, new BoxShape(0.6f, 1));
        this.setPosition(position);
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        this.addImage(new BodyImage(imagePath, 3));
        world.addStepListener(this);
    }
    /** movement between bounds*/
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
        } else {
            // Stay still if leftBound == rightBound
            this.setLinearVelocity(new Vec2(0, getLinearVelocity().y));}
    }
    @Override
    public void preStep(StepEvent stepEvent) {
        patrol();
    }
    @Override
    public void postStep(StepEvent stepEvent) {}
}
