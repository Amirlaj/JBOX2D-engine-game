package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController implements KeyListener {
    private Player1 player1;

    public PlayerController(Player1 player) {
        this.player1 = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            player1.moveLeft();
        } else if (key == KeyEvent.VK_RIGHT) {
            player1.moveRight();
        } else if (key == KeyEvent.VK_UP) {
            player1.jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            player1.stopMoving();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {} // Not used
}
