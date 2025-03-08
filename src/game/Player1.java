package game;

import city.cs.engine.Walker;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Player1 extends Walker {
        public Player1(GameWorld gameWorld) {
            super(gameWorld, new BoxShape(1, 2));
            this.setPosition(new Vec2(4, -5));
        }
}
