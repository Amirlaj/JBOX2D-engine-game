package game.entities;

import city.cs.engine.*;
import game.characters.Player1;
import org.jbox2d.common.Vec2;

/**
 * Jumper is a power-up platform that grants Player1 a jetpack on contact.
 */
public class Jumper extends StaticBody implements CollisionListener {

    private static final Shape shape = new BoxShape(0.5f, 0.0000000000001f);

    /**
     * Constructs a Jumper in the given world.
     * @param world the game world
     */
    public Jumper(World world) {
        super(world, shape);
        addImage(new BodyImage("data/Jumper.png", 2f));
        this.addCollisionListener(this);
    }

    /**
     * Constructs a Jumper at a specified position.
     * @param world the game world
     * @param position the position to place the jumper
     */
    public Jumper(World world, Vec2 position) {
        this(world);
        setPosition(position);
    }

    /**
     * Called when another body collides with the jumper.
     * Grants jetpack to Player1 and destroys itself.
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Player1) {
            Player1 player = (Player1) e.getOtherBody();
            player.enableJetpack();
            this.destroy();
        }
    }
}
