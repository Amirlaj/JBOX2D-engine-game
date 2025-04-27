package game;

import javax.swing.*;

public class GameOverManager {
    public static void declareWinner(String winner) {
        JOptionPane.showMessageDialog(null, winner + " Wins!");
        System.exit(0); // close the game
    }
}
