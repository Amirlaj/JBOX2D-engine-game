package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import javax.swing.JFrame;
import java.awt.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Your main game entry point
 */
public class Game {

    private SoundClip gameMusic;
    /** Initialise a new Game. */
    public Game() {
        GameWorld gameWorld = new GameWorld();

        Player1 player1 = new Player1(gameWorld);

        BackgroundView view = new BackgroundView(gameWorld, 600, 360, player1);
//        view.setCentre(player1.getPosition());

        Coin coin = new Coin(gameWorld, new Vec2(0, -3));

        Enemy enemy1 = new Enemy(gameWorld, new Vec2(3, 3), "data/enemy1.png", 1, 6);
        Enemy enemy2 = new Enemy(gameWorld, new Vec2(-12, -1), "data/enemy2.png", -15, -8);
        new javax.swing.Timer(100, e -> {
            enemy1.patrol();
            enemy2.patrol();
        }).start();

        DynamicBody bod = new DynamicBody(gameWorld,new PolygonShape(-0.73f,-0.81f, -0.73f,0.54f, -0.02f,1.16f, 0.51f,0.62f, 0.52f,-0.9f, -0.19f,-1.17f));


        //3. make a view to look into the game world
//        UserView view = new UserView(gameWorld, 500, 500);


        //optional: draw a 1-metre grid over the view
         view.setGridResolution(1);


        //4. create a Java window (frame) and add the game
        final JFrame frame = new JFrame("City Game");
        frame.add(view);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

        //optional: uncomment this to make a debugging view
         JFrame debugView = new DebugViewer(gameWorld, 600, 360);



        PlayerController controller = new PlayerController(player1);
        frame.addKeyListener(controller);


        PlayerCollision collisionListener = new PlayerCollision(player1);
        player1.addCollisionListener(collisionListener);


//        try {
//            gameMusic = new SoundClip("data/gametheme.wav");
//            gameMusic.loop();
//        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
//
//            System.out.println(e);
//        }
//

        gameWorld.start();


    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}
