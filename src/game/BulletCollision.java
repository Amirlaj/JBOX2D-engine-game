package game;

import city.cs.engine.*;
import game.gamelevels.GameLevel;

public class BulletCollision implements CollisionListener {

    @Override
    public void collide(CollisionEvent e) {
        Body other = e.getOtherBody();
        Body bullet = e.getReportingBody();

        if (other instanceof Enemy) {
            other.destroy();   // Destroy the enemy
            bullet.destroy();  // Destroy the bullet

            // Cast the world to GameLevel to access the player
            GameLevel level = (GameLevel) bullet.getWorld();
            level.getPlayer().incrementKills();

            // Check if the level is now complete
            if (level.isLevelComplete()) {
                System.out.println("Level Complete! Moving to next level...");
                // The actual level switch is handled in Game.java
            }

        } else {
            bullet.destroy();  // If it hits something else, just destroy the bullet
        }
    }
}
