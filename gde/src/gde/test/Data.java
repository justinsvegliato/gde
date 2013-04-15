package gde.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;
import gde.service.RequestHandler;
import gde.models.CapturedData;
import gde.models.Developer;
import gde.models.Field;
import gde.models.Field.FieldType;
import gde.models.Game;
import gde.models.Instance;
import gde.service.util.Request;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        MongoCollection developersCollection = jongo.getCollection("developers");
        MongoCollection gamesCollection = jongo.getCollection("games");
        MongoCollection instancesCollection = jongo.getCollection("instances");
        MongoCollection fieldsCollection = jongo.getCollection("fields");
        MongoCollection capturedDataCollection = jongo.getCollection("captureddata");
        developersCollection.drop();
        gamesCollection.drop();
        instancesCollection.drop();
        fieldsCollection.drop();
        capturedDataCollection.drop();
        
        Developer developer = new Developer("justin", "svegliato", "Svegabytes", "a", "a");
        developersCollection.save(developer);  
        List<String> developers = new LinkedList<String>();
        developers.add(developer.getKey().toString());
        
        Game game = new Game("Diablo 2", "ARPG", developers);
        gamesCollection.save(game);
        
        Field field = new Field("Strength" , FieldType.INTEGER, game.getKey().toString());
        fieldsCollection.save(field);
        field = new Field("Dextarity" , FieldType.INTEGER, game.getKey().toString());
        fieldsCollection.save(field);
        field = new Field("Vitality" , FieldType.INTEGER, game.getKey().toString());
        fieldsCollection.save(field);
        field = new Field("Energy" , FieldType.INTEGER, game.getKey().toString());
        fieldsCollection.save(field);
//        field = new Field("Class" , FieldType.TEXT, game.getKey().toString());
//        fieldsCollection.save(field);
        
        for (int i = 0; i < 100; i++) {
            Instance instance = new Instance("Revulsion" + i, game.getKey().toString());
            instancesCollection.save(instance);
            for (int j = 0; j < (Math.random() * 100) + 1; j++) {
                Map<String, String> data = new HashMap<String, String>();
                data.put("strength", ((int) (Math.random() * 50 + 1)) + "");
                data.put("dextarity", ((int) (Math.random() * 50 + 1)) + "");
                data.put("vitality", ((int) (Math.random() * 50 + 1)) + "");
                data.put("energy", ((int) (Math.random() * 50 + 1)) + "");
//                data.put("class", "Assassin");          
                CapturedData capturedData = new CapturedData(data, instance.getKey().toString());
                capturedDataCollection.save(capturedData);
                
            }
        }
    }
}
