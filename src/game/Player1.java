package game;

import city.cs.engine.Walker;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Player1 extends Walker {

    private static final float SPEED = 5;
    private static final float JUMP = 10;
    private int health = 3;
    private int score = 0;

    public Player1(GameWorld gameWorld) {
        super(gameWorld, new BoxShape(1, 3));
        this.setPosition(new Vec2(4, -5));
        this.addImage(new BodyImage("data/player1.png", 4));
    }

    public void moveLeft() {
        this.setLinearVelocity(new Vec2(-SPEED, this.getLinearVelocity().y));
    }

    public void moveRight() {
        this.setLinearVelocity(new Vec2(SPEED, this.getLinearVelocity().y));
    }

    public void jump() {
        if (this.getLinearVelocity().y == 0) { // Ensure jumping only when on the ground
            this.setLinearVelocity(new Vec2(this.getLinearVelocity().x, JUMP));
        }
    }

    public void stopMoving() {
        this.setLinearVelocity(new Vec2(0, this.getLinearVelocity().y));
    }

    public void decreaseHealth() {
        health--;
        if (health <= 0) {
            System.out.println("Player is dead!");
            this.destroy(); // Remove the player if health is 0
        }
    }

    public int getHealth() {
        return health;
    }


}


