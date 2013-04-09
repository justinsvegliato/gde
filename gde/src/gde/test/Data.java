package gde.test;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;
import gde.RequestHandler;
import gde.models.CapturedData;
import gde.models.Developer;
import java.net.UnknownHostException;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author justinsvegliato
 */
public class Data {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestHandler.class);
    private static final String DATABASE = "gde";
    private static Jongo jongo;

    static {
        try {
            DB db = new Mongo().getDB(DATABASE);
            jongo = new Jongo(db);
            LOGGER.debug("Instantiated connection to the database [" + DATABASE + "]");
        } catch (UnknownHostException ex) {
            LOGGER.error("Failed to connect to the database [" + DATABASE + "]", ex);
        }
    }

    public static void main(String[] args) {
        MongoCollection developers = jongo.getCollection("developers");
        Developer developer;
        Developer data = new Developer("justin", "svegliato", "Svegabytes", "revulsion", "password");
        WriteResult result = developers.save(data);
        if (!result.getLastError().ok()) {
            LOGGER.error("Failed to write the CapturedData object to the database");
            return;
        }
    }
}
