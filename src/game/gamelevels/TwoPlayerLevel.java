package game.gamelevels;

import city.cs.engine.*;
import game.entities.Jumper;
import game.entities.MaxHealthPickup;
import game.characters.Player1;
import game.characters.Player2;
import org.jbox2d.common.Vec2;

/**two-player mode, includes multiple platforms, powerups, and spawns both players. */
public class TwoPlayerLevel extends GameLevel {
    private Player2 player2; // Player 2 reference
    /**Constructs a new TwoPlayerLevel.*/
    public TwoPlayerLevel() {
        super("Two Player Mode", "background.png",  3);
    }

    /** Initializes the level, placing both players, platforms, and pickups*/
    @Override
    public void initialize() {
        super.initialize();
        // Create Player 1
        Player1 player1 = new Player1(this);
        setPlayer(player1);
        player1.setPosition(new Vec2(-5, -2));
        // Ground
        Shape groundShape = new BoxShape(20, 0.5f);
        new StaticBody(this, groundShape).setPosition(new Vec2(0, -7));
        // Platforms
        Shape platformShape = new BoxShape(4, 0.2f);
        new StaticBody(this, platformShape).setPosition(new Vec2(-10, -4));
        new StaticBody(this, platformShape).setPosition(new Vec2(6, 5));
        new StaticBody(this, platformShape).setPosition(new Vec2(5, 0));
        new StaticBody(this, platformShape).setPosition(new Vec2(7, -4));
        new StaticBody(this, platformShape).setPosition(new Vec2(-8, 2));

        // Create Player 2
        player2 = new Player2(this);
        player2.setPosition(new Vec2(5, -2));
        addEntity(player2);
        // max health
        MaxHealthPickup pickup = new MaxHealthPickup(this);
        pickup.setPosition(new Vec2(6, -3));
        addEntity(pickup);
        Jumper jetpack = new Jumper(this, new Vec2(-3, -1));
        addEntity(jetpack);
    }
    /** Accessor for Player 2.
     * @return the Player2 instance */
    public Player2 getPlayer2() {
        return player2;
    }
}
