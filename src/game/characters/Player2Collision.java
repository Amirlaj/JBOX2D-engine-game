package game.characters;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.entities.Enemy;

/** same as player 1 collision*/
public class Player2Collision implements CollisionListener {
    private Player2 player;

    public Player2Collision(Player2 player) {
        this.player = player;
    }
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Enemy) {
            player.decreaseHealth(1);
        }
    }
}