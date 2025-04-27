package game.view;

import javax.swing.*;

/**
 * Utility class for handling game-over messages.
 */
public class GameOverManager {

    /**
     * Displays a dialog box declaring the winner.
     * @param winner the name of the winning player
     */
    public static void declareWinner(String winner) {
        JOptionPane.showMessageDialog(null, winner + " won!");
    }
}
