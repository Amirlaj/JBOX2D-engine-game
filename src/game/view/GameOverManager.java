package game.view;

import javax.swing.*;

public class GameOverManager {
    public static void declareWinner(String winner) {
        JOptionPane.showMessageDialog(null, winner + " won!");
    }
}
