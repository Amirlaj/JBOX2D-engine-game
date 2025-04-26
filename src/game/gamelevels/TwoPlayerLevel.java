package game.gamelevels;

import city.cs.engine.*;
import game.characters.Player1;
import game.characters.Player2;
import org.jbox2d.common.Vec2;

public class TwoPlayerLevel extends GameLevel {

    public TwoPlayerLevel() {
        super("Two Player Mode", "background.png", 0, 6);
    }

    @Override
    public void initialize() {
        Player1 player1 = new Player1(this);
        setPlayer(player1);
        player1.setPosition(new Vec2(-5, -2));

        Shape groundShape = new BoxShape(20, 0.5f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -8));

        Shape platformShape = new BoxShape(4, 0.5f);
        new StaticBody(this, platformShape).setPosition(new Vec2(0, 0));

        // Add second player manually
        Player2 player2 = new Player2(this);
        player2.setPosition(new Vec2(5, -2));
        addEntity(player2);
    }

}
