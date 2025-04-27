package game;

import game.characters.*;
import game.gamelevels.*;
import game.view.BackgroundView;

import javax.swing.*;
import java.awt.*;

/** * Main class to launch and control the Game.
 * Handles GUI, menu navigation, and switching between single and two-player modes. */
public class Game {
    private GameLevel currentLevel;  // (easy, Medium, or TwoPlayer)
    private BackgroundView view; // ui overlays
    private PlayerController controller1;
    private Player2Controller controller2;
    private JFrame frame; // game window
    private JPanel mainPanel; // menu, game views, ppause button panel
    private CardLayout cardLayout; // switching between menu and game views
    private JPanel bottomPanel; // pause area in the middle of the game;
    private JButton pauseButton; // pause button in the menu
    private static final int VIEW_WIDTH = 600; // width of view
    private static final int VIEW_HEIGHT = 360; // height of view
    private final String MENU = "Menu"; // view for menu
    private final String GAME = "Game"; // vuew for 1p mode
    private final String TWO_PLAYER = "TwoPlayer"; // menu for 2p mode
    private int levelNumber = 1; // the level that is currently loaded
    private boolean isPaused = false ; // whether the game is paused

    public static void main(String[] args) {
        new Game();
    }
    /** Constructor sets up the window, menu, and listeners. */
    public Game() {
        frame = new JFrame("City Game");

        // Setup layout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.add(createMenuPanel(), MENU);
        // Wrap main and bottom panel in container
        JPanel container = new JPanel(new BorderLayout());
        container.add(mainPanel, BorderLayout.CENTER);
        // Setup pause button panel (hidden in menu)
        bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pauseButton = new JButton("Pause");
        pauseButton.setFocusable(false);
        pauseButton.addActionListener(e -> togglePause());
        bottomPanel.add(pauseButton);
        bottomPanel.setVisible(false);
        container.add(bottomPanel, BorderLayout.SOUTH);
        // Frame settings
        frame.setContentPane(container);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(VIEW_WIDTH, VIEW_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        // Keyboard pause toggle
        frame.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == java.awt.event.KeyEvent.VK_P) {
                    togglePause();
                }
            }
        });

        cardLayout.show(mainPanel, MENU);
    }
    /** Pauses and unpauses current level.*/
    private void togglePause() {
        if (isPaused) {
            currentLevel.start();
            pauseButton.setText("Pause");
            isPaused = false;
        } else {
            currentLevel.stop();
            pauseButton.setText("Resume");
            isPaused = true;
        }
    }

    /**  start menu with two buttons*/
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
    /** Starts a single player game */
    private void startSinglePlayer() {
        loadLevel(levelNumber);
        Player1 player = currentLevel.getPlayer();

        setupPlayer1(player);
        loadViewForLevel(currentLevel, player);
        setupCollision(player);
        bottomPanel.setVisible(true);
        currentLevel.start();

        new javax.swing.Timer(1000, e -> {
            if (currentLevel.isLevelComplete()) {
                levelNumber++;
                loadLevel(levelNumber);
                setupPlayer1(currentLevel.getPlayer());
                loadViewForLevel(currentLevel, currentLevel.getPlayer());
                setupCollision(currentLevel.getPlayer());
                bottomPanel.setVisible(true);
                currentLevel.start();
            }
        }).start();
    }
    /** Starts a two-player mode game. */
    private void startTwoPlayer() {
        currentLevel = new TwoPlayerLevel();
        currentLevel.initialize();

        Player1 player1 = currentLevel.getPlayer();
        Player2 player2 = ((TwoPlayerLevel) currentLevel).getPlayer2();

        setupPlayer1(player1);
        setupPlayer2(player2);
        loadViewForLevel(currentLevel, player1);
        setupCollision(player1);
        bottomPanel.setVisible(true);

        currentLevel.start();
    }

    /**Loads the appropriate level */
    private void loadLevel(int levelNum) {
        if (currentLevel != null) {
            currentLevel.stop();
        }
        if (levelNum == 1) {
            currentLevel = new EasyLevel();
        } else if (levelNum == 2) {
            currentLevel = new MediumLevel();
        } else if (levelNum == 3) {
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
    /**
     * Loads the BackgroundView with correct player(s) for the current level*/
    private void loadViewForLevel(GameLevel level, Player1 player) {
        Player2 player2 = (level instanceof TwoPlayerLevel) ? ((TwoPlayerLevel) level).getPlayer2() : null;
        view = new BackgroundView(level, VIEW_WIDTH, VIEW_HEIGHT, player, player2);

        mainPanel.add(view, level instanceof TwoPlayerLevel ? TWO_PLAYER : GAME);
        cardLayout.show(mainPanel, level instanceof TwoPlayerLevel ? TWO_PLAYER : GAME);
        frame.requestFocus();
    }
    private void setupCollision(Player1 player) {
        player.addCollisionListener(new PlayerCollision(player));
    }
}
