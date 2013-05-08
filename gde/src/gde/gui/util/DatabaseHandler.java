package gde.gui.util;

import com.mongodb.DB;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import org.jongo.Jongo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseHandler.class);
    private static final String DATABASE = "gde";
    private static Jongo jongo;
    
    /**
     * Instantiates a new DatabaseHandler object.
     */
    private DatabaseHandler() {
    }

    /**
     * Returns the Jongo database object with which the handler is associated.
     * @return The Jongo database object with which the handler is associated.
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
