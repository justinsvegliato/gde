package gde.models;

/**
 * The implementation of the Developer data structure that will be used by
 * MongoDB as well as the application.
 * 
 * @author Justin Svegliato and Andrew Evans
 */
public class Developer extends Entry {
    
    public enum AccountType {
        DEVELOPER, ADMINISTRATOR;
    }

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
    
    private AccountType accountType;

    /**
     * Instantiates a newly-created Developer object.
     */
    public Developer() {
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
    public Developer(String firstName, String lastName, String company, String username, String password, AccountType accountType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.username = username;
        this.password = password;
        this.accountType = accountType;
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
    
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
