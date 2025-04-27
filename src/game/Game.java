package game;

import city.cs.engine.*;
import game.characters.*;
import game.gamelevels.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Game {

    private GameLevel currentLevel;
    private BackgroundView view;
    private PlayerController controller1;
    private Player2Controller controller2;

    private JFrame frame;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    private static final int VIEW_WIDTH = 600;
    private static final int VIEW_HEIGHT = 360;

    private final String MENU = "Menu";
    private final String GAME = "Game";
    private final String TWO_PLAYER = "TwoPlayer";

    private int levelNumber = 1;

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        frame = new JFrame("City Game");
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(createMenuPanel(), MENU);

        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(VIEW_WIDTH, VIEW_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        cardLayout.show(mainPanel, MENU);
    }

    private JPanel createMenuPanel() {
        JPanel menuPanel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("City Game", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 32));
        menuPanel.add(title, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setOpaque(false);

        JButton startButton = new JButton("Learning mode (one player)");
        startButton.setFont(new Font("Arial", Font.PLAIN, 24));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.addActionListener(e -> startSinglePlayer());

        JButton twoPlayerButton = new JButton("Two Player");
        twoPlayerButton.setFont(new Font("Arial", Font.PLAIN, 24));
        twoPlayerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        twoPlayerButton.addActionListener(e -> startTwoPlayer());

        buttonPanel.add(startButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        buttonPanel.add(twoPlayerButton);

        menuPanel.add(buttonPanel, BorderLayout.CENTER);

        return menuPanel;
    }

    private void startSinglePlayer() {
        loadLevel(levelNumber);
        Player1 player = currentLevel.getPlayer();

        setupPlayer1(player);
        loadViewForLevel(currentLevel, player);
        setupEnemiesWithPatrol();
        setupCollision(player);
        currentLevel.start();

        new javax.swing.Timer(1000, e -> {
            if (currentLevel.isLevelComplete()) {
                levelNumber++;
                loadLevel(levelNumber);
                setupPlayer1(currentLevel.getPlayer());
                loadViewForLevel(currentLevel, currentLevel.getPlayer());
                setupEnemiesWithPatrol();
                setupCollision(currentLevel.getPlayer());
                currentLevel.start();
            }
        }).start();
    }

    private void startTwoPlayer() {
        currentLevel = new TwoPlayerLevel();
        currentLevel.initialize();

        Player1 player1 = currentLevel.getPlayer();
        Player2 player2 = ((TwoPlayerLevel) currentLevel).getPlayer2();

        setupPlayer1(player1);
        setupPlayer2(player2);
        loadViewForLevel(currentLevel, player1);
        setupCollision(player1);
        setupCollision(player1);
        player1.addCollisionListener(new PlayerCollision(player1));

        player2.addCollisionListener(new Player2Collision(player2));


        currentLevel.start();
    }

    private void loadLevel(int levelNum) {
        if (currentLevel != null) {
            currentLevel.stop();
        }

        if (levelNum == 1) {
            currentLevel = new EasyLevel();
        } else if (levelNum == 2) {
            currentLevel = new MediumLevel();
        } else if (levelNum == 3) {
            currentLevel = new HardLevel();
        } else {
            JOptionPane.showMessageDialog(frame, "Game completed. Thank you for playing!");
            System.exit(0);
            return;
        }

        currentLevel.initialize();
    }

    private void setupPlayer1(Player1 player) {
        controller1 = new PlayerController(player);
        frame.addKeyListener(controller1);
    }

    private void setupPlayer2(Player2 player) {
        controller2 = new Player2Controller(player);
        frame.addKeyListener(controller2);
    }

    private void loadViewForLevel(GameLevel level, Player1 player) {
        if (view == null) {
            Player2 player2 = (level instanceof TwoPlayerLevel) ? ((TwoPlayerLevel) level).getPlayer2() : null;
            view = new BackgroundView(level, VIEW_WIDTH, VIEW_HEIGHT, player, player2);
            mainPanel.add(view, level instanceof TwoPlayerLevel ? TWO_PLAYER : GAME);
        } else {
            view.setWorld(level);
        }
        cardLayout.show(mainPanel, level instanceof TwoPlayerLevel ? TWO_PLAYER : GAME);
        frame.requestFocus();
    }

    private void setupCollision(Player1 player) {
        player.addCollisionListener(new PlayerCollision(player));
    }

    private void setupEnemiesWithPatrol() {
        Enemy enemy1 = new Enemy(currentLevel, new Vec2(3, 3), "data/enemy1.png", 1, 6);
        Enemy enemy2 = new Enemy(currentLevel, new Vec2(-12, -1), "data/enemy2.png", -15, -8);

        new javax.swing.Timer(100, e -> {
            enemy1.patrol();
            enemy2.patrol();
        }).start();
    }
}