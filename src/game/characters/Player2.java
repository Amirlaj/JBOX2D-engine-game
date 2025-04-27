package game.characters;

import city.cs.engine.*;
import game.entities.Bullet;
import game.gamelevels.GameLevel;
import game.view.GameOverManager;
import org.jbox2d.common.Vec2;

/**
 * Player2 represents the second player in two-player mode.
 * Includes movement, shooting, health tracking, and sprite orientation.
 */
public class Player2 extends Walker {

    private static final float SPEED = 5;
    private static final float JUMP = 13;

    private int health = 3;
    private int score = 0;
    private int enemyKills = 0;

    private BodyImage rightImage;
    private BodyImage leftImage;
    private BodyImage currentImage;

    /**
     * Constructs a Player2 in the given game world.
     */
    public Player2(GameLevel gameWorld) {
        super(gameWorld, new BoxShape(0.6f, 1));
        this.setPosition(new Vec2(4, -5));

        rightImage = new BodyImage("data/player1.png", 3.5f);
        leftImage = new BodyImage("data/player1_left.png", 3.5f);
        currentImage = rightImage;

        this.addImage(currentImage);
    }

    // Movement Controls
    public void moveLeft() {
        this.setLinearVelocity(new Vec2(-SPEED, this.getLinearVelocity().y));
        faceLeft();
    }

    public void moveRight() {
        this.setLinearVelocity(new Vec2(SPEED, this.getLinearVelocity().y));
        faceRight();
    }

    public void stopMoving() {
        this.setLinearVelocity(new Vec2(0, this.getLinearVelocity().y));
    }

    public void jump() {
        if (this.getLinearVelocity().y == 0) {
            this.setLinearVelocity(new Vec2(this.getLinearVelocity().x, JUMP));
        }
    }

    // Combat
    public void shoot() {
        Vec2 position = getPosition().add(currentImage == rightImage ? new Vec2(1.2f, 0) : new Vec2(-1.2f, 0));
        boolean facingRight = currentImage == rightImage;
        new Bullet(this.getWorld(), position, facingRight);
    }

    // Health and Score
    public void decreaseHealth(int amount) {
        health -= amount;
        if (health <= 0) {
            System.out.println("Player 2 is dead!");
            this.destroy();
            GameOverManager.declareWinner("Player 2");
        }
    }

    public void restoreHealth() {
        health = 3;
        System.out.println("Health fully restored!");
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

    public void incrementKills() {
        enemyKills++;
    }

    public int getEnemyKills() {
        return enemyKills;
    }

    // Sprite Orientation
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
}
