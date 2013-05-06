package gde.service;

import gde.service.util.Request;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;
import gde.models.CapturedData;
import gde.models.Instance;
import java.io.IOException;
import java.net.UnknownHostException;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The RequestHandler receives requests and subsequently handles the request
 * accordingly by persisting the data to the database and creating the associated
 * instance if it does not yet exist.
 * 
 * @author Justin Svegliato and Andrew Evans
 */
public class RequestHandler {

    /** the Logger object that will be used for logging purposes */
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestHandler.class);
    
    /** the database the request handler to which will be wrote */
    private static final String DATABASE = "gde";
    
    /** an Jongo object that will be used to persist data */
    private static Jongo jongo;

    /** 
     * A static initializer that will create the database and subsequently 
     * instantiate the Jongo object.
     */
    static {
        try {
            DB db = new Mongo().getDB(DATABASE);
            jongo = new Jongo(db);
            LOGGER.debug("Instantiated connection to the database [" + DATABASE + "]");
        } catch (UnknownHostException ex) {
            LOGGER.error("Failed to connect to the database [" + DATABASE + "]", ex);
        }
    }

    /**
     * Creates a newly-instantiated RequestHandler object.
     */
    RequestHandler() {
    }
    
    /**
     * Handles a request by creating an instance if it does not yet exist and 
     * thereafter persisting the frame data associated with this instance to the database.
     * 
     * @param clientRequest the request to be handled.
     */
    public void handleRequest(String clientRequest) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Request request = mapper.readValue(clientRequest, Request.class);

            LOGGER.debug("Retrieving the Instance object from the database");
            MongoCollection instances = jongo.getCollection("instances");
            String query = String.format("{identifier: '%s', gameId: '%s'}", request.getIdentifier(), request.getGameId());
            Instance instance;
            if ((instance = instances.findOne(query).as(Instance.class)) == null) {
                LOGGER.debug("Creating a new Instance object since it could not be found");
                instance = new Instance(request.getIdentifier(), request.getGameId());
                WriteResult result = instances.save(instance);
                if (!result.getLastError().ok()) {
                    LOGGER.error("Failed to write the Instance object to the database");
                    return;
                }
                LOGGER.debug("Wrote the new Instance object to the database");
            }

            LOGGER.debug("Writing the CapturedData object to the database");
            MongoCollection capturedData = jongo.getCollection("captureddata");
            CapturedData data = new CapturedData(request.getData(), instance.getKey().toString());
            WriteResult result = capturedData.save(data);
            if (!result.getLastError().ok()) {
                LOGGER.error("Failed to write the CapturedData object to the database");
                return;
            }
            LOGGER.debug("Wrote the CapturedData object to the database");
        } catch (IOException ex) {
            LOGGER.error("Received malformed request: " + clientRequest);
        }
    }
}
