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

public class RequestHandler {

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

    RequestHandler() {
    }
    
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
