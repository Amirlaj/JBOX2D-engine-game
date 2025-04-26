package game.gamelevels;

import city.cs.engine.World;
import game.characters.Player1;
import java.util.ArrayList;
import java.util.List;

public abstract class GameLevel extends World {

    protected String levelName;
    protected String background;
    protected int goalScore;
    protected List<Object> entities;
    protected Player1 player;
    protected int requiredKills;


    public GameLevel(String levelName, String background, int goalScore, int requiredKills) {

        this.levelName = levelName;
        this.background = background;
        this.goalScore = goalScore;
        this.entities = new ArrayList<>();
        this.requiredKills = requiredKills;


    }

    public void setPlayer(Player1 player) {
        this.player = player;
    }

    // Get the player object
    public Player1 getPlayer() {
        return player;
    }

    public void addEntity(Object entity) {
        entities.add(entity);
    }

    public void initialize() {
        System.out.println("Initializing level: " + levelName);
        System.out.println("Setting background: " + background);
    }

    public boolean isLevelComplete() {
        return player.getEnemyKills() >= requiredKills;
    }


    // Optional render method (if needed)
    public void render() {
        System.out.println("Rendering the background: " + background);
    }

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
