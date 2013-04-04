package gde.models;

import java.util.Date;

/**
 * The implementation of the Instance data structure that will be used by
 * MongoDB as well as the application.
 * 
 * @author Justin Svegliato and Andrew Evans
 */
public class Instance extends Entry {

    /** the name of the game instance */
    private String name;
    
    /** the date of when the game instance was initiated */
    private Date started;
    
    /** the total play time of the game instance */
    private Integer playtime;
    
    /** the id of the associated game */
    private Integer gameId;

    /**
     * Instantiates the newly-created Instance object.
     */
    public Instance() {
    }

    /**
     * Instantiates the newly-created Instance object.
     * 
     * @param id the id assigned by MongoDB
     */
    public Instance(Integer id) {
        super(id);
    }
    
    /** 
     * Instantiates the newly-created Instance object.
     * 
     * @param name the name of the game instance 
    * @param started the date of when the game instance was initiated
     * @param playtime the total play time of the game instance
     * @param gameId the id of the associated game
     */
    public Instance(String name, Date started, Integer playtime, Integer gameId) {
        this.name = name;
        this.started = started;
        this.playtime = playtime;
        this.gameId = gameId;
    }
    
    /**
     * Instantiates a newly-created Instance object.
     * 
     * @param name the name of the game instance
     * @param started the date of when the game instance was initiated
     * @param playtime the total play time of the game instance
     */
    public Instance(String name, Date started, Integer playtime) {
        this(name, started, playtime, -1);
    }
    
    /**
     * Gets the name of the instance.
     * 
     * @return the name of the instance
     */
    public String getName() {
        return name;
    }

    /** 
     * Sets the name of the instance.
     * 
     * @param name the name of the instance
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets thedate of when the instance was initiated.
     * 
     * @return the time and date of when the instance was initiated
     */
    public Date getStarted() {
        return started;
    }

    /**
     * Sets the date of when the instance was initiated
     * 
     * @param started the time and date of when the instance was initiated
     */
    public void setStarted(Date started) {
        this.started = started;
    }

    /**
     * Gets the total play time of the game instance.
     * 
     * @return the total play time of the game instance
     */
    public Integer getPlaytime() {
        return playtime;
    }

    /**
     * Sets the total play time of the game instance.
     * 
     * @param playtime the total play time of the game instance
     */
    public void setPlaytime(Integer playtime) {
        this.playtime = playtime;
    }

    /** 
     * Gets the id of the associated game.
     * 
     * @return the id of the associated game
     */
    public Integer getGameId() {
        return gameId;
    }

    /**
     * Sets the id of the associated game.
     * 
     * @param gameId the id of the associated game
     */
    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
}
