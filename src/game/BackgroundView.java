package game;

import city.cs.engine.World;
import city.cs.engine.UserView;

import javax.swing.*;
import java.awt.*;

class BackgroundView extends UserView {
    private Image background;
    private Player1 player;
    private Image heartIcon;
    private Image coinIcon;

    public BackgroundView(World world, int width, int height, Player1 player) {
        super(world, width, height);
        this.player = player;
        background = new ImageIcon("data/background.png").getImage();
        heartIcon = new ImageIcon("data/heart.png").getImage();
        coinIcon = new ImageIcon("data/coin.png").getImage();
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        // Draw player's health as heart icons
        for (int i = 0; i < player.getHealth(); i++) {
            g.drawImage(heartIcon, 10 + (i * 30), 10, 25, 25, null);
        }

        // Display collected coin count with an icon
        g.drawImage(coinIcon, 10, 50, 25, 25, null);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.setColor(Color.WHITE);
        g.drawString("x " + player.getScore(), 40, 70);
    }
}
