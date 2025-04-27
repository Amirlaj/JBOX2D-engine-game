package game.characters;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.entities.Enemy;
import game.entities.Jumper;

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
        if (e.getOtherBody() instanceof Enemy) {
            player.decreaseHealth(1);
        } else if (e.getOtherBody() instanceof Jumper) {
            player.enableJetpack();
            e.getOtherBody().destroy();
        }
    }
}

