package game.gamelevels;

import city.cs.engine.StaticBody;
import city.cs.engine.Shape;
import city.cs.engine.BoxShape;
import game.Enemy;
import game.characters.Player1;

public class HardLevel extends GameLevel {

    public HardLevel() {
        super("Hard Level", "data/hard_background.png", 5000, 25); // Customize the values as needed
    }

    @Override
    public void initialize() {
        super.initialize();

        // Example: Add platforms or obstacles
        Shape platformShape = new BoxShape(3, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new org.jbox2d.common.Vec2(-5, -11));
        addEntity(platform1);

        StaticBody platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new org.jbox2d.common.Vec2(5, -5));
        addEntity(platform2);

        // Add enemies and other custom elements
        createEnemies();
    }

    private void createEnemies() {
        // Add tougher enemies with more HP, different behavior, etc.
        addEntity(new Enemy(this, new org.jbox2d.common.Vec2(0, 5), "data/enemy_hard1.png", -10, 10));
        addEntity(new Enemy(this, new org.jbox2d.common.Vec2(8, -3), "data/enemy_hard2.png", 6, 12));
    }

}