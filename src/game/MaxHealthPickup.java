package game;

import city.cs.engine.*;
import game.characters.Player1;
import game.characters.Player2;

public class MaxHealthPickup extends DynamicBody implements CollisionListener {

    private static final Shape shape = new CircleShape(0.5f);

    public MaxHealthPickup(World world) {
        super(world, shape);
        addImage(new BodyImage("data/max_health.png", 1.0f)); // your health icon
        setGravityScale(0);

        this.addCollisionListener(this); // handle collision within the same class
    }

    @Override
    public void collide(CollisionEvent e) {
        Body other = e.getOtherBody();

        if (other instanceof Player1) {
            ((Player1) other).restoreHealth(); // make sure this method exists
            this.destroy();
        } else if (other instanceof Player2) {
            ((Player2) other).restoreHealth(); // make sure this method exists
            this.destroy();
        }
    }
}
