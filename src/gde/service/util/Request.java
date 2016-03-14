package gde.service.util;

import java.util.Map;

/**
 * The data structure that contains information regarding the JSON request that 
 * the listener receives from the game client.
 * 
 * @author Justin Svegliato and Andrew Evans
 */
public class Request {

    /** the id of the game contained in the JSON request */
    private String gameId;
    
    /** the identifier, namely the player, contained in the JSON request */
    private String identifier;
    
    /** the map containing the data associated with the identifier contained in the JSON request */
    private Map<String, String> data;

    /**
     * Instantiates a newly-created Request object.
     */
    public Request() {
    }

    /**
     * Gets the game id of the associated game.
     * 
     * @return the game id of the associated game
     */
    public String getGameId() {
        return gameId;
    }
    
    /**
     * Sets the game id of the associated game.
     * 
     * @param gameId the game id of the associated game
     */
    public void setGameId(String gameId) {
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
     * Gets the map of the data associated with the identifier.
     * 
     * @return the map of the data associated with the instance
     */
    public Map<String, String> getData() {
        return data;
    }

    /**
     * Sets the map of the data associated with the identifier.
     * 
     * @param data the map of the data associated with the identifier.
     */
    public void setData(Map<String, String> data) {
        this.data = data;
    }
}
