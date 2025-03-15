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
            e.getOtherBody().destroy(); // Remove coin from the world
            System.out.println("Coin collected!");
        } else if (e.getOtherBody() instanceof Enemy) {
            player.decreaseHealth(); // Decrease player's health
            System.out.println("Hit by enemy! Health: " + player.getHealth());
        }
    }
}
