package game.entities;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**Represents a bullet shot by a player.*/
public class Bullet extends DynamicBody {
    private static final Shape shape = new BoxShape(0.3f, 0.1f);
    private static final float SPEED = 10f;

    /** @param world the world the bullet is in
     * @param position the initial position of the bullet
     * @param facingRight true if bullet should go right, false for left*/
    public Bullet(World world, Vec2 position, boolean facingRight) {
        super(world, shape);
        setPosition(position);
        addImage(new BodyImage("data/bullet.png", 1));
        float direction = facingRight ? 1 : -1;
        setLinearVelocity(new Vec2(SPEED * direction, 0));
        setGravityScale(0);
        setBullet(true);

        this.addCollisionListener(new BulletCollision());
    }
}
