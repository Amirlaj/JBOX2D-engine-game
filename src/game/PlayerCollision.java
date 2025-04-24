package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * Handles collisions for the player, excluding coins.
 */
public class PlayerCollision implements CollisionListener {
    private Player1 player;

    public PlayerCollision(Player1 player) {
        this.player = player;
    }

    @Override
    public void collide(CollisionEvent e) {
        // Handle enemy collision only
        if (e.getOtherBody() instanceof Enemy) {
            player.decreaseHealth();
        }
    }
}
