package game;

import city.cs.engine.*;
import game.characters.Player1;
import game.characters.Player2;
import org.jbox2d.common.Vec2;

public class Bullet extends DynamicBody {

    private static final Shape shape = new BoxShape(0.3f, 0.1f);
    private static final float SPEED = 10f;

    public Bullet(World world, Vec2 position, boolean facingRight) {
        super(world, shape);
        setPosition(position);
        addImage(new BodyImage("data/bullet.png", 0.5f));

        float direction = facingRight ? 1 : -1;
        setLinearVelocity(new Vec2(SPEED * direction, 0));

        setGravityScale(0);
        setBullet(true);

        this.addCollisionListener(new BulletCollision()); // no need to pass players
    }
}
