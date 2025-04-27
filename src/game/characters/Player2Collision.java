package game.characters;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.entities.Enemy;

/**
 * Collision handler for Player2. Reduces health on contact with enemies.
 */
public class Player2Collision implements CollisionListener {

    private Player2 player;

    /**
     * Creates a collision listener for Player2.
     * @param player the player to apply damage to
     */
    public Player2Collision(Player2 player) {
        this.player = player;
    }

    /**
     * Called when Player2 collides with another object.
     * Decreases health if the other body is an enemy.
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Enemy) {
            player.decreaseHealth(1);
        }
    }
}