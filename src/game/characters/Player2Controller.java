package game.characters;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * same as the player1 controller but differnt button
 */
public class Player2Controller implements KeyListener {

    private Player2 player2;

    public Player2Controller(Player2 player) {
        this.player2 = player;
    }
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
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_D) {
            player2.stopMoving();
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }
}
