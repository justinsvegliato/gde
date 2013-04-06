package gde.models;

/**
 * The implementation of the Game data structure that will be used by
 * MongoDB as well as the application.
 * 
 * @author Justin Svegliato and Andrew Evans
 */
public class Game extends Entry {

    /** the title of the game */
    private String title;
    
    /** the genre of the game */
    private String genre;

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
     * @param developerId the id of the associated developer
     */
    public Game(String title, String genre) {
        this.title = title;
        this.genre = genre;
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
}
