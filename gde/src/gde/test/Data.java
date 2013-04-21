package gde.test;

import com.mongodb.DB;
import com.mongodb.Mongo;
import gde.service.RequestHandler;
import gde.models.CapturedData;
import gde.models.Developer;
import gde.models.Field;
import gde.models.Field.FieldType;
import gde.models.Game;
import gde.models.Instance;
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

        Field field = new Field("Level", FieldType.INTEGER, game.getKey().toString());
        fieldsCollection.save(field);
        field = new Field("Strength", FieldType.INTEGER, game.getKey().toString());
        fieldsCollection.save(field);
        field = new Field("Dexterity", FieldType.INTEGER, game.getKey().toString());
        fieldsCollection.save(field);
        field = new Field("Vitality", FieldType.INTEGER, game.getKey().toString());
        fieldsCollection.save(field);
        field = new Field("Energy", FieldType.INTEGER, game.getKey().toString());
        fieldsCollection.save(field);
        field = new Field("Class", FieldType.TEXT, game.getKey().toString());
        fieldsCollection.save(field);
        field = new Field("Race", FieldType.TEXT, game.getKey().toString());
        fieldsCollection.save(field);

        for (int i = 0; i < 100; i++) {
            Instance instance = new Instance("Revulsion" + i, game.getKey().toString());
            instancesCollection.save(instance);
            double scaleFactor = (Math.random() * 30) + 5;
            String race = (Math.random() > 0.5) ? "Elf" : "Human";
            String clss = (Math.random() > 0.5) ? "Warrior" : "Rogue";
            for (int j = 0; j < (Math.random() * 100) + 10; j++) {
                Map<String, String> data = new HashMap<String, String>();
                data.put("level", String.valueOf(j));
                data.put("strength", (int) ((((int) (Math.random() * 5)) + (j * 5)) * scaleFactor) + "");
                data.put("dextarity", (int) ((((int) (Math.random() * 5)) + (j * 5)) * scaleFactor) + "");
                data.put("vitality", (int) ((((int) (Math.random() * 5)) + (j * 5)) * scaleFactor) + "");
                data.put("energy", (int) ((((int) (Math.random() * 5)) + (j * 5)) * scaleFactor) + "");
                data.put("class", clss);
                data.put("race", race);
                CapturedData capturedData = new CapturedData(data, instance.getKey().toString());
                capturedDataCollection.save(capturedData);
            }
        }
    }
}
