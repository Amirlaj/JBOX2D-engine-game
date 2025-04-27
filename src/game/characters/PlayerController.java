package game.characters;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**Handles keyboard input for Player1 using arrow keys and space. */
public class PlayerController implements KeyListener {
    private Player1 player1;

    /**Creates a controller for Player1.
     * @param player the Player1 instance to control*/
    public PlayerController(Player1 player) {
        this.player1 = player;
    }

    /** Handles key press events for movement and shooting. */
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT -> player1.moveLeft();
            case KeyEvent.VK_RIGHT -> player1.moveRight();
            case KeyEvent.VK_UP -> player1.jump();
            case KeyEvent.VK_SPACE -> player1.shoot();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            player1.stopMoving();
        }
    }
    public void keyTyped(KeyEvent e) {
        // Not used
    }
}