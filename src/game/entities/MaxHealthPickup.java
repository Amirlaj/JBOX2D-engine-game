package game.entities;

import city.cs.engine.*;
import game.characters.Player1;
import game.characters.Player2;

public class MaxHealthPickup extends StaticBody implements CollisionListener {

    private static final Shape shape = new CircleShape(0.00000000000000001f);

    public MaxHealthPickup(World world) {
        super(world, shape);
        addImage(new BodyImage("data/max_health.png", 2f)); // your asset
        this.addCollisionListener(this);
    }

    @Override
    public void collide(CollisionEvent e) {
        Body other = e.getOtherBody();

        if (other instanceof Player1) {
            ((Player1) other).restoreHealth();
            this.destroy();
        } else if (other instanceof Player2) {
            ((Player2) other).restoreHealth();
            this.destroy();
        } else if (other instanceof Bullet) {
            other.destroy(); // absorb the bullet
        }
    }
}
