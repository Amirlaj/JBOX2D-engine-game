package game.characters;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Handles keyboard input for controlling Player2 using WASD and F keys.
 */
public class Player2Controller implements KeyListener {

    private Player2 player2;

    /**
     * Creates a key listener for Player2.
     * @param player the Player2 instance to control
     */
    public Player2Controller(Player2 player) {
        this.player2 = player;
    }

    /**
     * Handles key press events.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_A -> player2.moveLeft();
            case KeyEvent.VK_D -> player2.moveRight();
            case KeyEvent.VK_W -> player2.jump();
            case KeyEvent.VK_F -> player2.shoot();
        }
    }

    /**
     * Handles key release events.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_D) {
            player2.stopMoving();
        }
    }

    /**
     * Not used but required by interface.
     */
    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }
}
