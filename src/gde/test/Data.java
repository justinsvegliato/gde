package gde.test;

import com.mongodb.DB;
import com.mongodb.Mongo;
import gde.models.CapturedData;
import gde.models.Chart;
import gde.models.Chart.ChartType;
import gde.models.Developer;
import gde.models.Developer.AccountType;
import gde.models.Field;
import gde.models.Field.FieldType;
import gde.models.Game;
import gde.models.Instance;
import gde.service.RequestHandler;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Data class merely serves to persist data to the database in order to ensure
 * that the GUI application is working properly.
 * 
 * @author Justin Svegliato and Andrew Evans
 */
public class Data {

    /** the Logger object using for logging purposes */
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestHandler.class);
    
    /** the name of the database to be connected to */
    private static final String DATABASE = "gde";
    
    /** the Jongo object which enables easy interaction with the database */
    private static Jongo jongo;

    /** a static initializer that creates the database and thereafter instantiates
     * the Jongo object.
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
     * Drops all of the collections in the database and then persists random data
     * for testing purposes.
     */
    public static void main(String[] args) {
        // Instantiates all of the collections
        MongoCollection developersCollection = jongo.getCollection("developers");
        MongoCollection gamesCollection = jongo.getCollection("games");
        MongoCollection instancesCollection = jongo.getCollection("instances");
        MongoCollection fieldsCollection = jongo.getCollection("fields");
        MongoCollection capturedDataCollection = jongo.getCollection("captureddata");
        MongoCollection chartCollection = jongo.getCollection("charts");
        
        // Drops all of the collections in the database
        developersCollection.drop();
        gamesCollection.drop();
        instancesCollection.drop();
        fieldsCollection.drop();
        capturedDataCollection.drop();
        chartCollection.drop();

        // Creates test developers
        Developer developer = new Developer("justin", "svegliato", "Svegabytes", "revulsion", "a9se3p2f", AccountType.ADMINISTRATOR);
        developersCollection.save(developer);
        List<String> developers = new LinkedList<String>();
        developers.add(developer.getKey().toString());
        
        developer = new Developer("justin", "svegliato", "Svegabytes", "andrew", "jk14lol", AccountType.DEVELOPER);
        developersCollection.save(developer);
        developer = new Developer("justin", "svegliato", "Svegabytes", "caiti", "iscool", AccountType.DEVELOPER);
        developersCollection.save(developer);
        developer = new Developer("justin", "svegliato", "Svegabytes", "admin", "b", AccountType.ADMINISTRATOR);
        developersCollection.save(developer);       

        // Creates a test game as well as test fields and charts
        Game game = new Game("Diablo 2", "ARPG", developers);
        gamesCollection.save(game);

        Field levelField = new Field("Level", FieldType.INTEGER, game.getKey().toString());
        fieldsCollection.save(levelField);
        
        Field field = new Field("Strength", FieldType.INTEGER, game.getKey().toString());
        fieldsCollection.save(field);     
        Chart newChart = new Chart(
                "Strength vs. Level",
                levelField.getKey().toString(),
                field.getKey().toString(),
                ChartType.LINE,
                game.getKey().toString());
        chartCollection.save(newChart);
        
        
        field = new Field("Dexterity", FieldType.INTEGER, game.getKey().toString());
        fieldsCollection.save(field);
        newChart = new Chart(
                "Dexterity vs. Level",
                levelField.getKey().toString(),
                field.getKey().toString(),
                ChartType.LINE,
                game.getKey().toString());
        chartCollection.save(newChart);
        
        
        field = new Field("Vitality", FieldType.INTEGER, game.getKey().toString());
        fieldsCollection.save(field);
        newChart = new Chart(
                "Vitality vs. Level",
                levelField.getKey().toString(),
                field.getKey().toString(),
                ChartType.LINE,
                game.getKey().toString());
        chartCollection.save(newChart);
        
        field = new Field("Energy", FieldType.INTEGER, game.getKey().toString());
        fieldsCollection.save(field);
        newChart = new Chart(
                "Energy vs. Level",
                levelField.getKey().toString(),
                field.getKey().toString(),
                ChartType.LINE,
                game.getKey().toString());
        chartCollection.save(newChart);
        
        field = new Field("Class", FieldType.TEXT, game.getKey().toString());
        fieldsCollection.save(field);
        newChart = new Chart(
                "Class Distribution",
                null,
                field.getKey().toString(),
                ChartType.PIE,
                game.getKey().toString());
        chartCollection.save(newChart);
        
        field = new Field("Race", FieldType.TEXT, game.getKey().toString());
        fieldsCollection.save(field);
                newChart = new Chart(
                "Race Distribution",
                null,
                field.getKey().toString(),
                ChartType.PIE,
                game.getKey().toString());
        chartCollection.save(newChart);
        
        Game game2 = new Game("Dragons [Alpha]", "ARPG", developers);
        gamesCollection.save(game2);

        field = new Field("X Position", FieldType.INTEGER, game2.getKey().toString());
        fieldsCollection.save(field);
        field = new Field("Y Position", FieldType.INTEGER, game2.getKey().toString());
        fieldsCollection.save(field);

        // Generates random captured data
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

    
    /**
     * Gets a random race name.
     * 
     * @return a random race name.
     */
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

    /**
     * Gets a random class name.
     * 
     * @return a random class name.
     */
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
