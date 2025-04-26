package game.characters;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player2Controller implements KeyListener {
    private Player2 player2;

    public Player2Controller(Player2 player) {
        this.player2 = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_A) {
            player2.moveLeft();
        } else if (key == KeyEvent.VK_D) {
            player2.moveRight();
        } else if (key == KeyEvent.VK_W) {
            player2.jump();
        } else if (key == KeyEvent.VK_F) {
            player2.shoot();
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
    public void keyTyped(KeyEvent e) {}
}
