package game.gamelevels;

import city.cs.engine.World;
import game.Player1;
import java.util.ArrayList;
import java.util.List;

public abstract class GameLevel extends World {

    protected String levelName;           // Name of the level
    protected String background;          // Background or theme of this level
    protected int goalScore;              // The score required to complete the level
    protected List<Object> entities;      // List of game objects like enemies or coins
    protected Player1 player;             // The player character

    // Constructor
    public GameLevel(String levelName, String background, int goalScore) {
        this.levelName = levelName;
        this.background = background;
        this.goalScore = goalScore;
        this.entities = new ArrayList<>();
        this.player = new Player1(this);
    }

    // Get the player object
    public Player1 getPlayer() {
        return player;
    }

    // Add an entity (enemy, coin, etc.)
    public void addEntity(Object entity) {
        entities.add(entity);
    }

    // Initialize the level: to be overridden in each level class
    public void initialize() {
        System.out.println("Initializing level: " + levelName);
        System.out.println("Setting background: " + background);
    }

    // Check if the level is complete
    public boolean isLevelComplete() {
        return getPlayer().getScore() >= goalScore;
    }

    // Optional render method (if needed)
    public void render() {
        System.out.println("Rendering the background: " + background);
    }

    // Getters if needed
    public String getLevelName() {
        return levelName;
    }

    public String getBackground() {
        return background;
    }

    public int getGoalScore() {
        return goalScore;
    }

    public List<Object> getEntities() {
        return entities;
    }
}
