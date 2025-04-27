package game.gamelevels;

import city.cs.engine.World;
import game.characters.Player1;
import java.util.ArrayList;
import java.util.List;

/**
 * Base class for all levels in the game.
 * Stores level-specific attributes and common logic for completion.
 */
public abstract class GameLevel extends World {
    protected String levelName;
    protected String background;
    protected List<Object> entities;
    protected Player1 player;
    protected int requiredKills;
    protected String levelMessage = "";
    private List<String> levelMessages = new ArrayList<>();
    /**  GameLevel with metadata
     *  requirement.
     * @param levelName name of the level
     * @param background path to background image
     * @param requiredKills number of kills to complete the level
     */
    public GameLevel(String levelName, String background, int requiredKills) {
        this.levelName = levelName;
        this.background = background;
        this.entities = new ArrayList<>();
        this.requiredKills = requiredKills;
    }
    public void setPlayer(Player1 player) {
        this.player = player;
    }
    public Player1 getPlayer() {
        return player;
    }
    public void addEntity(Object entity) {
        entities.add(entity);
    }
    /**Called when the level is loaded. Use to set up game objects.*/
    public void initialize() {
        System.out.println("Initializing level: " + levelName);
        System.out.println("Setting background: " + background);
    }
    /** Checks if the level's required kill count has been met.
     * @return true if completed*/
    public boolean isLevelComplete() {
        return player.getEnemyKills() >= requiredKills;
    }
    public void render() {
        System.out.println("Rendering the background: " + background);
    }
    public String getLevelName() {
        return levelName;
    }
    public String getBackground() {
        return background;
    }
    public List<Object> getEntities() {
        return entities;
    }
    public String getLevelMessage() {
        return levelMessage;
    }
    public void setLevelMessage(String levelMessage) {
        this.levelMessage = levelMessage;
    }
    public void addLevelMessage(String message) {
        levelMessages.add(message);
    }

    public List<String> getLevelMessages() {
        return levelMessages;
    }
}
