package gde.models;

/**
 * The implementation of the Instance data structure that will be used by
 * MongoDB as well as the application.
 *
 * @author Justin Svegliato and Andrew Evans
 */
public class Instance extends Entry {

    /** the identifier of the game instance */
    private String identifier;
    
    /** the id of the associated game */
    private String gameId;

    /**
     * Instantiates the newly-created Instance object.
     */
    public Instance() {
    }

    /**
     * Instantiates the newly-created Instance object.
     *
     * @param identifier the identifier of the game instance
     * @param gameId the id of the associated game
     */
    public Instance(String name, String gameId) {
        this.identifier = name;
        this.gameId = gameId;
    }

    /**
     * Gets the identifier of the instance.
     *
     * @return the identifier of the instance
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Sets the identifier of the instance.
     *
     * @param identifier the identifier of the instance
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Gets the id of the associated game.
     *
     * @return the id of the associated game
     */
    public String getGameId() {
        return gameId;
    }

    /**
     * Sets the id of the associated game.
     *
     * @param gameId the id of the associated game
     */
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
}
