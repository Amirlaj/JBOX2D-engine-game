package game;

import city.cs.engine.*;
import game.characters.Player1;
import game.characters.Player2;
import game.gamelevels.GameLevel;

public class BulletCollision implements CollisionListener {

    @Override
    public void collide(CollisionEvent e) {
        Body other = e.getOtherBody();
        Body bullet = e.getReportingBody();

        if (other instanceof Enemy) {
            other.destroy();
            bullet.destroy();

            GameLevel level = (GameLevel) bullet.getWorld();
            level.getPlayer().incrementKills();

            if (level.isLevelComplete()) {
                System.out.println("Level Complete! Moving to next level...");
            }
        } else if (other instanceof Player1) {
            ((Player1) other).decreaseHealth(1);
            bullet.destroy();
        } else if (other instanceof Player2) {
            ((Player2) other).decreaseHealth(1);
            bullet.destroy();
        } else {
            bullet.destroy();
        }
    }
}

//package game;
//
//import city.cs.engine.*;
//import game.gamelevels.GameLevel;
//
//public class BulletCollision implements CollisionListener {
//
//    @Override
//    public void collide(CollisionEvent e) {
//        Body other = e.getOtherBody();
//        Body bullet = e.getReportingBody();
//
//        if (other instanceof Enemy) {
//            other.destroy();   // Destroy the enemy
//            bullet.destroy();  // Destroy the bullet
//
//            // Cast the world to GameLevel to access the player
//            GameLevel level = (GameLevel) bullet.getWorld();
//            level.getPlayer().incrementKills();
//
//            // Check if the level is now complete
//            if (level.isLevelComplete()) {
//                System.out.println("Level Complete! Moving to next level...");
//                // The actual level switch is handled in Game.java
//            }
//
//        } else {
//            bullet.destroy();  // If it hits something else, just destroy the bullet
//        }
//    }
//}
