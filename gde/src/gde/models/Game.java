package gde.models;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the Game data structure that will be used by MongoDB as
 * well as the application.
 *
 * @author Justin Svegliato and Andrew Evans
 */
public class Game extends Entry {

    /**
     * the title of the game
     */
    private String title;
    /**
     * the genre of the game
     */
    private String genre;
    /**
     * the ids of the associated games
     */
    private List<String> developerIds = new ArrayList<String>();

    /**
     * Instantiates a newly-created Game object.
     */
    public Game() {
    }

    /**
     * Instantiates a newly-created Game object.
     *
     * @param title the title of the game
     * @param genre the genre of the game
     * @param developerIds the ids of the associated developers
     */
    public Game(String title, String genre, List<String> developerIds) {
        this.title = title;
        this.genre = genre;
        this.developerIds = developerIds;
    }

    /**
     * Gets the title of the game.
     *
     * @return the title of the game
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the game.
     *
     * @param title the title of the game
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the genre of the game.
     *
     * @return the genre of the game
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the genre of the game.
     *
     * @param genre the genre of the game
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<String> getDeveloperIds() {
        return developerIds;
    }

    public void setDeveloperIds(List<String> developerIds) {
        this.developerIds = developerIds;
    }

    @Override
    public String toString() {
        return title;
    }
}
