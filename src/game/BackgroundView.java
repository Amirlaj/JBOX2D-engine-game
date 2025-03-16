package game;

import city.cs.engine.World;
import city.cs.engine.UserView;

import javax.swing.*;
import java.awt.*;

class BackgroundView extends UserView {
    private Image background;
    private Player1 player;
    private Image coinIcon;

    public BackgroundView(World world, int width, int height, Player1 player) {
        super(world, width, height);
        this.player = player;
        background = new ImageIcon("data/background.png").getImage();
        coinIcon = new ImageIcon("data/coin.png").getImage();
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
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
        g.drawString("Health: " + currentHealth + " / " + maxHealth, x + 40, y + 15);

        g.drawImage(coinIcon, 10, 50, 25, 25, null);
        g.setColor(Color.WHITE);
        g.drawString("x " + player.getScore(), 40, 70);
    }
}
