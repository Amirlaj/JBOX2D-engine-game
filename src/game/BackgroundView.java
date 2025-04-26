package game;

import city.cs.engine.World;
import city.cs.engine.UserView;
import game.characters.Player1;
import game.characters.Player2;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
class BackgroundView extends UserView {
    private Image background;
    private Player1 player;
    private Image coinIcon;

    private Player2 player2; // null unless in two player mode

    // Constructor for both modes
    public BackgroundView(World world, int width, int height, Player1 player1, Player2 player2) {
        super(world, width, height);
        this.player = player1;
        this.player2 = player2; // can be null
        background = new ImageIcon("data/background.png").getImage();
        coinIcon = new ImageIcon("data/coin.png").getImage();
    }

    @Override
    public Vec2 getCentre() {
        Vec2 pos = player.getPosition();
        return new Vec2(pos.x + 2f, pos.y); // shift the view 2 units ahead
    }


    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        // Health bar for Player1
        int maxHealth = 3;
        int currentHealth = player.getHealth();
        int barWidth = 150;
        int barHeight = 20;
        int x = 10;
        int y = 10;

        g.setColor(Color.GRAY);
        g.fillRect(x, y, barWidth, barHeight);

        int currentBarWidth = (int) ((currentHealth / (float) maxHealth) * barWidth);

        if (currentHealth > 2) {
            g.setColor(Color.GREEN);
        } else if (currentHealth == 2) {
            g.setColor(Color.YELLOW);
        } else {
            g.setColor(Color.RED);
        }

        g.fillRect(x, y, currentBarWidth, barHeight);
        g.setColor(Color.WHITE);
        g.drawString("Player one: " + currentHealth + " / " + maxHealth, x + 40, y + 15);

        // Health bar for Player2 (if it exists)
        if (player2 != null) {
            int player2Health = player2.getHealth();
            int player2BarWidth = (int) ((player2Health / (float) maxHealth) * barWidth);
            int player2Y = y + barHeight + 10; // Position below Player1's health bar

            g.setColor(Color.GRAY);
            g.fillRect(x, player2Y, barWidth, barHeight);

            if (player2Health > 2) {
                g.setColor(Color.GREEN);
            } else if (player2Health == 2) {
                g.setColor(Color.YELLOW);
            } else {
                g.setColor(Color.RED);
            }

            g.fillRect(x, player2Y, player2BarWidth, barHeight);
            g.setColor(Color.WHITE);
            g.drawString("Player two: " + player2Health + " / " + maxHealth, x + 40, player2Y + 15);
        }
    }

}
