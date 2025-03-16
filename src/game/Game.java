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


    /**e Initialise a new Game. */
    public Game() {
        GameWorld gameWorld = new GameWorld();

        Player1 player1 = new Player1(gameWorld);

        BackgroundView view = new BackgroundView(gameWorld, 600, 360, player1);

        Coin coin = new Coin(gameWorld, new Vec2(0, -3));

        Enemy enemy1 = new Enemy(gameWorld, new Vec2(3, 3), "data/enemy1.png");
        Enemy enemy2 = new Enemy(gameWorld, new Vec2(-12, -1), "data/enemy2.png");





        //2. populate it with bodies (ex: platforms, collectibles, characters)
        //make a character (with an overlaid image)
//        Shape studentShape = new BoxShape(1,2);
//        DynamicBody student = new DynamicBody(gameWorld, studentShape);
//        student.setPosition(new Vec2(4,-5));
//        student.addImage(new BodyImage("data/student.png", 4));





        //3. make a view to look into the game world
//        UserView view = new UserView(gameWorld, 500, 500);


        //optional: draw a 1-metre grid over the view
        // view.setGridResolution(1);


        //4. create a Java window (frame) and add the game
        //   view to it
        final JFrame frame = new JFrame("City Game");
        frame.add(view);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //optional: uncomment this to make a debugging view
         JFrame debugView = new DebugViewer(gameWorld, 600, 360);



        PlayerController controller = new PlayerController(player1);
        frame.addKeyListener(controller);


        PlayerCollision collisionListener = new PlayerCollision(player1);
        player1.addCollisionListener(collisionListener);


        gameWorld.start();


    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}
