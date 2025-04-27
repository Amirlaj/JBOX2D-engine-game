package game.view;

import city.cs.engine.World;
import city.cs.engine.UserView;
import game.characters.Player1;
import game.characters.Player2;
import org.jbox2d.common.Vec2;
import javax.swing.*;
import java.awt.*;

/** * Displays player health bars and tracks the camera based on Player1. */
public class BackgroundView extends UserView {
    private Image background;
    private Player1 player;
    private Player2 player2; // optional var, it can be null
    /**
     * Constructs a new BackgroundView.
     * @param world the world to render
     * @param width the view width
     * @param height the view height
     * @param player1 the main player to track and render
     * @param player2 the second player */
    public BackgroundView(World world, int width, int height, Player1 player1, Player2 player2) {
        super(world, width, height);
        this.player = player1;
        this.player2 = player2;
        background = new ImageIcon("data/background.png").getImage();
    }
    /** background image. */
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);
    }
    /**health bars for Player1 and Player2 (if exists)*/
    @Override
    protected void paintForeground(Graphics2D g) {
        // Health bar for Player1
        drawHealthBar(g, player.getHealth(), 10, 10, "Player one");
        // Health bar for Player2 (if it exists)
        if (player2 != null) {
            drawHealthBar(g, player2.getHealth(), 10, 40, "Player two");
        }
    }











    /**method to draw a health bar.
     * @param g the graphics context
     * @param currentHealth current health value
     * @param x x position of the bar
     * @param y y position of the bar
     * @param label player label*/


    private void drawHealthBar(Graphics2D g, int currentHealth, int x, int y, String label) {
        int maxHealth = 3;
        int barWidth = 150;
        int barHeight = 20;
        int currentBarWidth = (int) ((currentHealth / (float) maxHealth) * barWidth);
        g.setColor(Color.GRAY);
        g.fillRect(x, y, barWidth, barHeight);
        if (currentHealth > 2) {
            g.setColor(Color.GREEN);
        } else if (currentHealth == 2) {
            g.setColor(Color.YELLOW);
        } else {
            g.setColor(Color.RED);
        }
        g.fillRect(x, y, currentBarWidth, barHeight);
        g.setColor(Color.WHITE);
        g.drawString(label + ": " + currentHealth + "/ " + maxHealth, x + 40, y + 15);
    }
}