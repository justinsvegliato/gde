package gde.test;

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
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;
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
        MongoCollection developers = jongo.getCollection("developers");
        MongoCollection games = jongo.getCollection("games");
        MongoCollection instances = jongo.getCollection("instances");
        MongoCollection fields = jongo.getCollection("fields");
        MongoCollection captureddata = jongo.getCollection("captureddata");
        developers.drop();
        games.drop();
        instances.drop();
        fields.drop();
        captureddata.drop();
        
        for (int i = 0; i < 100; i++) {
            Developer developer = new Developer("name" + i, "svegliato", "Svegabytes", "revulsion" + i, "password");
            developers.save(developer);   
        }

        List<String> developersList = new LinkedList<String>();
        developersList.add(developer.getKey().toString());
        Game game = new Game("Diablo 3", "ARPG", developersList);
        games.save(game);
        game = new Game("World of Warcraft", "MMORPG", developersList);
        games.save(game);

        for (int i = 0; i < 100; i++) {
            instances.save(new Instance("Lancelot" + i, game.getKey().toString()));
        }
        
        Field field = new Field("Strength" , FieldType.INTEGER, game.getKey().toString());
        fields.save(field);
        field = new Field("Vitality" , FieldType.INTEGER, game.getKey().toString());
        fields.save(field);
    }
}
