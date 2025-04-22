package game.gamelevels;

import java.util.ArrayList;
import java.util.List;

public class GameLevel {
    protected String levelName; // Name of the level
    protected String background; // Background or theme of this level
    protected int goalScore; // The score required to complete the level
    protected List<Object> entities; // List of game objects like enemies or coins

    // Constructor
    public GameLevel(String levelName, String background, int goalScore) {
        this.levelName = levelName;
        this.background = background;
        this.goalScore = goalScore;
        this.entities = new ArrayList<>(); // Initialize the entity list
    }

    // Initialize the level: setup background and any other settings
    public void initialize() {
        System.out.println("Initializing level: " + levelName);
        System.out.println("Setting background: " + background);
    }

    // Check if the level is complete
    public boolean isLevelComplete(int playerScore) {
        return playerScore >= goalScore;
    }

    // Render the level
    public void render() {
        System.out.println("Rendering the background: " + background);
    }




    // Add an entity (enemy, coin, etc.)
    public void addEntity(Object entity) {
        entities.add(entity);
    }
}