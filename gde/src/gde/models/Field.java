package gde.models;

/**
 * The implementation of the Field data structure that is used by MongoDB
 * as well as the application.
 *
 * @author Justin Svegliato and Andrew Evans
 */
public class Field extends Entry {

    /** an enumerated field containing the types supported by the system */
    public enum FieldType {

        INTEGER,
        DECIMAL,
        TEXT,
        BOOLEAN;

        @Override
        public String toString() {
            return name().substring(0, 1).toUpperCase() + name().substring(1).toLowerCase();
        }
    }
    
    /** the name of the field */
    private String name;
    
    /** the type of the field */
    private FieldType type;
    
    /** the id of the associated game */
    private String gameId;

    /**
     * Instantiates a newly-created Field object.
     */
    public Field() {
    }

    /**
     * Instantiates a newly-created Field object.
     *
     * @param name the name of the field
     * @param type the type of the field
     * @param gameId the id of the associated game
     */
    public Field(String name, FieldType type, String gameId) {
        this.name = name;
        this.type = type;
        this.gameId = gameId;
    }

    /**
     * Gets the name of the field.
     *
     * @return the name of the field
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the field.
     *
     * @param the name of the field
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the type of the field.
     *
     * @return the type of the field
     */
    public FieldType getType() {
        return type;
    }

    /**
     * Sets the type of the field.
     *
     * @param type the type of the field
     */
    public void setType(FieldType type) {
        this.type = type;
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

    /**
     * Gets the string representation, specifically the name, of the field.
     * 
     * @return the string representation, specifically the name, of the field
     */
    @Override
    public String toString() {
        return name;
    }
    
    /**
     * Returns true if the objects have the same exact values for the fields,
     * otherwise false.
     * 
     * @param obj the object to be compared
     * @return true if the objects have the same exact values for the fields,
     * otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        final Field other = (Field) obj;

        return this.name.equals(other.name) && (this.type == other.type) && this.gameId.equals(other.gameId);
    }

    /**
     * Returns an unique identifier for this field based on the field members.
     * 
     * @return an unique identifier for this field based on the field members.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 53 * hash + (this.type != null ? this.type.hashCode() : 0);
        hash = 53 * hash + (this.gameId != null ? this.gameId.hashCode() : 0);
        return hash;
    }
}
