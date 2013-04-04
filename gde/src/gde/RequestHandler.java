package gde;

import gde.util.Request;
import com.fasterxml.jackson.databind.ObjectMapper;
import gde.models.CapturedData;
import gde.util.MongoHelper;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestHandler {

    private static final Logger logger = LoggerFactory.getLogger(RequestHandler.class);

    RequestHandler() {
    }

    public void handleRequest(String clientRequest) {
        ObjectMapper mapper = new ObjectMapper();
        Request request;
        try {
            request = mapper.readValue(clientRequest, Request.class);
            CapturedData data = new CapturedData(null,
                    request.getFrameNumber(),
                    request.getData(),
                    request.getInstanceId());
            logger.debug("Created mongo database object from request");
            

            MongoHelper.setDB("gde");
            if (!MongoHelper.save(data, "captureddata")) {
                logger.error("Failed to write data to database");
            } else {
                logger.debug("Wrote data to database");
            }
        } catch (IOException ex) {
            logger.error("Received malformed request");
        }
    }
}
