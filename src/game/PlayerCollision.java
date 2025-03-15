package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class PlayerCollision implements CollisionListener {
    private Player1 player;

    public PlayerCollision(Player1 player) {
        this.player = player;
    }


    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Coin) {
            player.increaseScore();
            e.getOtherBody().destroy();
        } else if (e.getOtherBody() instanceof Enemy) {
            player.decreaseHealth();
        }
    }

}
