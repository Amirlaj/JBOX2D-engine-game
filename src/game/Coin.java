package game;
import city.cs.engine.*;

import game.gamelevels.GameLevel;
import org.jbox2d.common.Vec2;

public class Coin extends DynamicBody {
    public Coin(GameLevel gameWorld, Vec2 position) {
        super(gameWorld, new CircleShape(0.5f));
        this.setPosition(position);
        this.addImage(new BodyImage("data/coin.png", 2));
    }
}
