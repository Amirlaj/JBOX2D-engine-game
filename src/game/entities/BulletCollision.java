package game.entities;

import city.cs.engine.*;
import game.characters.Player1;
import game.characters.Player2;
import game.gamelevels.GameLevel;

/**Handles collision logic for bullets.
 * Destroys enemies, players, or the bullet itself depending on the collision target*/
public class BulletCollision implements CollisionListener {
    /** when a bullet hits another object.
     * @param e the collision event */
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
                System.out.println("testing level complted");
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
