package game;

import city.cs.engine.*;
import game.gamelevels.*;
import org.jbox2d.common.Vec2;
import javax.swing.*;
import java.awt.*;

/**
 * Your main game entry point with integrated start menu.
 */
public class Game {

    private GameLevel currentLevel;
    private BackgroundView view;
    private PlayerController controller;
    private SoundClip gameMusic;

    private JFrame frame;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    private final String MENU = "Menu";
    private final String GAME = "Game";
    private int levelNumber = 1;

    /** Launch the game */
    public static void main(String[] args) {
        new Game();
    }

    /** Constructor: builds menu and game container */
    public Game() {
        frame = new JFrame("City Game");
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add menu panel to the layout
        mainPanel.add(createMenuPanel(), MENU);

        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 360);
        frame.setLocationRelativeTo(null); // center on screen
        frame.setResizable(false);
        frame.setVisible(true);

        cardLayout.show(mainPanel, MENU); // show menu first
    }

    /** Build the start menu panel */
    private JPanel createMenuPanel() {
        JPanel menuPanel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("City Game", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 32));
        menuPanel.add(title, BorderLayout.NORTH);

        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.PLAIN, 24));
        startButton.addActionListener(e -> {
            loadGamePanel();                       // load game content
            cardLayout.show(mainPanel, GAME);      // switch to game screen
        });

        menuPanel.add(startButton, BorderLayout.CENTER);
        return menuPanel;
    }

    /** Load the game logic and UI into the panel */
    private void loadGamePanel() {
        loadLevel(levelNumber);
        setupView();
        setupInput();
        setupEnemies();
        setupDebugView();
        setupCollisionHandling();
        view.setGridResolution(1);
        currentLevel.start();

        mainPanel.add(view, GAME); // Add game view as a card
        frame.addKeyListener(controller); // Controls now work
    }

    /** Load a level (Easy, Medium, etc.) */
    public void loadLevel(int levelNum) {
        if (levelNum == 1) {
            currentLevel = new EasyLevel();
        } else if (levelNum == 2) {
            currentLevel = new MediumLevel();
        } else {
            System.out.println("Game completed. Thank you for playing!");
            System.exit(0);
        }

        currentLevel.initialize();

        Player1 player = currentLevel.getPlayer();
        if (view == null) {
            view = new BackgroundView(currentLevel, 600, 360, player);
        } else {
            view.setWorld(currentLevel);
        }
    }

    /** Setup the camera and display */
    private void setupView() {
        view.setGridResolution(1);
    }

    /** Setup input for player control */
    private void setupInput() {
        Player1 player = currentLevel.getPlayer();
        controller = new PlayerController(player);
    }

    /** Add and animate enemies */
    private void setupEnemies() {
        Enemy enemy1 = new Enemy(currentLevel, new Vec2(3, 3), "data/enemy1.png", 1, 6);
        Enemy enemy2 = new Enemy(currentLevel, new Vec2(-12, -1), "data/enemy2.png", -15, -8);

        new javax.swing.Timer(100, e -> {
            enemy1.patrol();
            enemy2.patrol();
        }).start();
    }

    /** Show debug view (optional) */
    private void setupDebugView() {
        new DebugViewer(currentLevel, 600, 360);
    }

    /** Setup collisions for coins/enemies */
    private void setupCollisionHandling() {
        Player1 player = currentLevel.getPlayer();
        player.addCollisionListener(new PlayerCollision(player));
    }

    /** Optional: Play background music */
    private void setupMusic() {
        try {
            gameMusic = new SoundClip("data/gametheme.wav");
            gameMusic.loop();
        } catch (Exception e) {
            System.err.println("Error loading music: " + e.getMessage());
        }
    }
}
