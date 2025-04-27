package game.entities;

import city.cs.engine.*;
import game.characters.Player1;
import org.jbox2d.common.Vec2;

public class Jumper extends StaticBody implements CollisionListener {

    private static final Shape shape = new BoxShape(0.5f, 0.0000000000001f);

    public Jumper(World world) {
        super(world, shape);
        addImage(new BodyImage("data/Jumper.png", 2f)); // replace with proper image path
        this.addCollisionListener(this);
    }

    // ✅ Add this constructor to allow setting position directly
    public Jumper(World world, Vec2 position) {
        this(world);
        setPosition(position);
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Player1) {
            Player1 player = (Player1) e.getOtherBody();
            player.enableJetpack(); // Make sure this exists in Player1
            this.destroy();
        }
    }
}
