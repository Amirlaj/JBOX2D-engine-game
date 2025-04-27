package game.characters;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.entities.Enemy;
import game.entities.Jumper;

/**
 * Handles collisions for Player1.
 * Reduces health on enemy collision, activates jetpack on Jumper contact.
 */
public class PlayerCollision implements CollisionListener {

    private Player1 player;

    /**
     * Constructs a collision listener for Player1.
     * @param player the player instance affected by collisions
     */
    public PlayerCollision(Player1 player) {
        this.player = player;
    }

    /**
     * Handles collision events.
     * @param e the collision event
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Enemy) {
            player.decreaseHealth(1);
        } else if (e.getOtherBody() instanceof Jumper) {
            player.enableJetpack();
            e.getOtherBody().destroy();
        }
    }
}
