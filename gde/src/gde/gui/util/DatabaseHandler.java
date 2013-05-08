package gde.gui.util;

import com.mongodb.DB;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import org.jongo.Jongo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The DatabaseHandler class which keeps the database information in one place.
 * 
 * @author Justin Svegliato and Andrew Evans
 */
public class DatabaseHandler {

    /** the Logger object used for logging purposes */
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseHandler.class);
    
    /** the database collection */
    private static final String DATABASE = "gde";
    
    /** the Jongo helper object that allows for easy database interaction */
    private static Jongo jongo;
    
    /**
     * Instantiates a new DatabaseHandler object.
     */
    private DatabaseHandler() {
    }

    /**
     * Returns the Jongo database object with which the handler is associated.
     * 
     * @return the Jongo database object with which the handler is associated
     */
    public static Jongo getDatabase() {
        if (jongo == null) {
            try {
                DB db = new Mongo().getDB(DATABASE);
                jongo = new Jongo(db);
                LOGGER.debug("Instantiated connection to the database [" + DATABASE + "]");
            } catch (UnknownHostException ex) {
                LOGGER.error("Failed to connect to the database [" + DATABASE + "]", ex);
            }
        }
        return jongo;
    }
}
