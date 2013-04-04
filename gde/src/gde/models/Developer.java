package gde.models;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the Developer data structure that will be used by
 * MongoDB as well as the application.
 * 
 * @author Justin Svegliato and Andrew Evans
 */
public class Developer extends Entry {

    /** the first name of the developer */
    private String firstName;
    
    /** the last name of the developer */
    private String lastName;
    
    /** the company for which the developer works */
    private String company;
    
    /** the username of the developer */
    private String username;
    
    /** the password of the developer's username */
    private String password;
    
    /** the ids of the associated developers */
    private List<Integer> gameIds = new ArrayList<Integer>();

    /**
     * Instantiates a newly-created Developer object.
     */
    public Developer() {
    }

    /**
     * Instantiates a newly-created Developer object.
     * 
     * @param id the id assigned by MongoDB
     */
    public Developer(Integer id) {
        super(id);
    }

    /**
     * Instantiates a newly-created Developer object.
     *
     * @param firstName the first name of the developer
     * @param lastName the last name of the developer
     * @param company the company for which the developer works
     * @param username the username of the developer
     * @param password the password of the developer's username
     */
    public Developer(String firstName, String lastName, String company, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.username = username;
        this.password = password;
    }

    /**
     * Gets the first name of the Developer object.
     *
     * @return the first name of the developer
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the developer.
     *
     * @param firstName the first name of the developer
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the developer.
     *
     * @return the last name of the developer
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the developer.
     *
     * @param lastName the last name of the developer
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the company for which the developer works.
     *
     * @return the company for which the developer works
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the company for which the developer works.
     *
     * @param company the company for which the developer works
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Gets the username of the developer.
     *
     * @return the username of the developer
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the developer.
     *
     * @param username the username of the developer
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of the developer's username.
     *
     * @return the password of the developer's username
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the password of the developer's username.
     *
     * @param password the password of the developer's username
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Gets the id of the associated games.
     * 
     * @return the id of the associated games
     */
    public List<Integer> getGameIds() {
        return gameIds;
    }
    
    /**
     * Sets the id of the associated games.
     * 
     * @param gameIds the id of the associated games
     */
    public void setGameIds(List<Integer> gameIds) {
        this.gameIds = gameIds;
    }
}
