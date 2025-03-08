package game;

import city.cs.engine.World;
import city.cs.engine.UserView;

import javax.swing.*;
import java.awt.*;

class BackgroundView extends UserView {
    private Image background;

    public BackgroundView(World world, int width, int height) {
        super(world, width, height);
        background = new ImageIcon("data/background.png").getImage(); // Ensure the path is correct
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 130, this);
    }
}
