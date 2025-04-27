package game.gamelevels;

import city.cs.engine.*;
import game.Jetpack;
import game.characters.Player1;
import game.characters.Player2;
import org.jbox2d.common.Vec2;

import java.util.Random;

public class TwoPlayerLevel extends GameLevel {

    private Player2 player2; // ✅ store reference to Player2

    public TwoPlayerLevel() {
        super("Two Player Mode", "background.png", 0, 6);
    }

    @Override
    public void initialize() {
        super.initialize();

        Player1 player1 = new Player1(this);
        setPlayer(player1);
        player1.setPosition(new Vec2(-5, -2));

        Shape groundShape = new BoxShape(20, 0.5f);
        new StaticBody(this, groundShape).setPosition(new Vec2(0, -8));

        Shape platformShape = new BoxShape(4, 0.5f);
        new StaticBody(this, platformShape).setPosition(new Vec2(0, 0));

        player2 = new Player2(this);
        player2.setPosition(new Vec2(5, -2));
        addEntity(player2);
    }


    // ✅ Getter so Game.java can access it
    public Player2 getPlayer2() {
        return player2;
    }



}

