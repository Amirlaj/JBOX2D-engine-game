package game;

import city.cs.engine.*;
import game.gamelevels.*;
import game.gamelevels.MediumLevel;
import org.jbox2d.common.Vec2;
import javax.swing.JFrame;
import java.awt.*;

/**
 * Your main game entry point
 */
public class Game {


    private GameLevel currentLevel;
    private BackgroundView view;
    private PlayerController controller;
    private int levelNumber = 1;

    private SoundClip gameMusic;

    /** Initialise a new Game. */
    public Game() {

        // gameWorld initiallization
//        GameWorld gameWorld = new GameWorld();

        loadLevel(levelNumber);

        // player initiallization
        Player1 player1 = currentLevel.getPlayer();

        // main game view
//        view = new BackgroundView(currentLevel, 600, 360, currentLevel.getPlayer());
//        view.setCentre(player1.getPosition());


        // Coin
//        Coin coin = new Coin(currentLevel, new Vec2(0, -3));


        // enemy initialisation and patrol mechanic
        Enemy enemy1 = new Enemy(currentLevel, new Vec2(3, 3), "data/enemy1.png", 1, 6);
        Enemy enemy2 = new Enemy(currentLevel, new Vec2(-12, -1), "data/enemy2.png", -15, -8);
        new javax.swing.Timer(100, e -> {
            enemy1.patrol();
            enemy2.patrol();
        }).start();


        // dynamic body
        DynamicBody bod = new DynamicBody(currentLevel,new PolygonShape(-0.73f,-0.81f, -0.73f,0.54f, -0.02f,1.16f, 0.51f,0.62f, 0.52f,-0.9f, -0.19f,-1.17f));




        //3. make a view to look into the game world
//        UserView view = new UserView(gameWorld, 500, 500);




        //optional: draw a 1-metre grid over the view
         view.setGridResolution(1);


        // create a Java window (frame) and add the game
        final JFrame frame = new JFrame("City Game");
        frame.add(view);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

        //optional: debugging view
         JFrame debugView = new DebugViewer(currentLevel, 600, 360);



         // player cotrller
        controller = new PlayerController(player1);
        frame.addKeyListener(controller);


        // collision handling
        PlayerCollision collisionListener = new PlayerCollision(player1);
        player1.addCollisionListener(collisionListener);

        // playing music
//        try {
//            gameMusic = new SoundClip("data/gametheme.wav");
//            gameMusic.loop();
//        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
//
//            System.out.println(e);
//        }
//


        // starting the game world
        currentLevel.start();
    }


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

        // If view is null (first level), create it
        if (view == null) {
            view = new BackgroundView(currentLevel, 600, 360, player);
        } else {
            view.setWorld(currentLevel);
        }

        controller = new PlayerController(player);
        player.addCollisionListener(new PlayerCollision(player));

        currentLevel.start();
    }


    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}