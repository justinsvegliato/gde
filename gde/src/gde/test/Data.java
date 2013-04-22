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

        Game game2 = new Game("Dragons [Alpha]", "ARPG", developers);
        gamesCollection.save(game2);

        field = new Field("X Position", FieldType.INTEGER, game2.getKey().toString());
        fieldsCollection.save(field);
        field = new Field("Y Position", FieldType.INTEGER, game2.getKey().toString());
        fieldsCollection.save(field);

        for (int i = 0; i < 100; i++) {
            Instance instance = new Instance("Revulsion" + i, game.getKey().toString());
            instancesCollection.save(instance);
            double scaleFactor = Math.random() + 2.5;
            String race = getRaceName();
            String clss = getClassName();
            double exponent = Math.random() > .94 ? 1.5 : 1.2;
            for (int j = 1; j < (Math.random() * 100) + 15; j++) {
                Map<String, String> data = new HashMap<String, String>();
                data.put("level", String.valueOf(j));
                data.put("strength", (int) (Math.pow(((Math.random() + j)), exponent) * scaleFactor) + "");
                data.put("dexterity", (int) (Math.pow(((Math.random() + j)), exponent) * scaleFactor) + "");
                data.put("vitality", (int) (Math.pow(((Math.random() + j)), exponent) * scaleFactor) + "");
                data.put("energy", (int) (Math.pow(((Math.random() + j)), exponent) * scaleFactor) + "");
                data.put("class", clss);
                data.put("race", race);
                CapturedData capturedData = new CapturedData(data, instance.getKey().toString());
                capturedDataCollection.save(capturedData);
            }
        }
    }

    private static String getRaceName() {
        double random = Math.random();
        if (random > 0.9) {
            return "Elf";
        } else if (random > 0.8) {
            return "Troll";
        } else if (random > 0.5) {
            return "Human";
        } else if (random > 0.3) {
            return "Dwarf";
        } else {
            return "Gnome";
        }
    }

    private static String getClassName() {
        double random = Math.random();
        if (random > 0.8) {
            return "Rogue";
        } else if (random > 0.7) {
            return "Warrior";
        } else if (random > 0.5) {
            return "Monk";
        } else if (random > 0.3) {
            return "Hunter";
        } else {
            return "Necromancer";
        }
    }
}
