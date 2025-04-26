package game.characters;

import city.cs.engine.Walker;
import city.cs.engine.*;
import game.Bullet;
import game.gamelevels.GameLevel;
import org.jbox2d.common.Vec2;

public class Player2 extends Walker {

    private static final float SPEED = 5;
    private static final float JUMP = 8;
    private int health = 3;
    private int score = 0;

    private BodyImage rightImage;
    private BodyImage leftImage;
    private BodyImage currentImage; // Track the currently applied image

    private int enemyKills = 0;


    public Player2(GameLevel gameWorld) {
        super(gameWorld, new BoxShape(0.6f, 1));
        this.setPosition(new Vec2(4, -5));

        rightImage = new BodyImage("data/player1.png", 3.5f);
        leftImage = new BodyImage("data/player1_left.png", 3.5f); // Ensure this file exists

        currentImage = rightImage;
        this.addImage(currentImage);
    }

    public void moveLeft() {
        this.setLinearVelocity(new Vec2(-SPEED, this.getLinearVelocity().y));
        faceLeft();
    }

    public void moveRight() {
        this.setLinearVelocity(new Vec2(SPEED, this.getLinearVelocity().y));
        faceRight();
    }

    public void jump() {
        if (this.getLinearVelocity().y == 0) {
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
            this.destroy();
        }
    }

    public int getHealth() {
        return health;
    }

    public void increaseScore() {
        score++;
    }

    public int getScore() {
        return score;
    }

    private void faceLeft() {
        if (currentImage != leftImage) {
            this.removeAllImages();
            this.addImage(leftImage);
            currentImage = leftImage;
        }
    }

    private void faceRight() {
        if (currentImage != rightImage) {
            this.removeAllImages();
            this.addImage(rightImage);
            currentImage = rightImage;
        }
    }

    public void shoot() {
        Vec2 position = getPosition().add(currentImage == rightImage ? new Vec2(1.2f, 0) : new Vec2(-1.2f, 0));
        boolean facingRight = currentImage == rightImage;
        new Bullet(this.getWorld(), position, facingRight);
    }

    public void incrementKills() {
        enemyKills++;
    }

    public int getEnemyKills() {
        return enemyKills;
    }


}
