package game.entities;

import city.cs.engine.*;
import game.characters.Player1;
import game.characters.Player2;

/**A health pickup object that restores a player's health to full */
public class MaxHealthPickup extends StaticBody implements CollisionListener {
    private static final Shape shape = new CircleShape(0.00000000000000001f);

    /** @param world the world to place the pickup in*/
    public MaxHealthPickup(World world) {
        super(world, shape);
        addImage(new BodyImage("data/max_health.png", 2f));
        this.addCollisionListener(this);
    }
    /** Called when another body collides with this pickup. Heals players and is destroyed on contact. Absorbs bullets.
     * @param e the collision event */
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
        }}
}