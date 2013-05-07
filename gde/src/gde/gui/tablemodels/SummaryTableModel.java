package gde.gui.tablemodels;

import static gde.gui.tablemodels.TableModel.database;
import gde.models.CapturedData;
import gde.models.Field;
import gde.models.Field.FieldType;
import gde.models.Game;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.bson.types.ObjectId;
import org.jongo.MongoCollection;

/**
 * The SummaryTableModel class handles all interactions with the table that contains data types of this sort.
 * 
 * @author Justin Svegliato and Andrew Evans
 */
public class SummaryTableModel extends TableModel {
        

    /**
     * The DatabaseQueryRunnable class handles 
     */
    class DatabaseQueryRunnable implements Runnable {

        /** the object id associated with the instance */
        private final ObjectId id;
        
        /**
         * Creates a newly-instantiated DatabaseQueryRunnable object
         * 
         * @param id the ObjectId of the said Instance
         */
        DatabaseQueryRunnable(ObjectId id) {
            this.id = id;
        }

        /**
         * Collects the data for the most recent CapturedData for the given object id
         */
        @Override
        public void run() {
            MongoCollection capturedDataCollection = database.getCollection("captureddata");
            String query = String.format("{instanceId: '%s'}", id.toString());
            if (capturedDataCollection.count(query) > 0) {
                CapturedData capturedData = capturedDataCollection.find(query).sort("{_id: -1}").limit(1).as(CapturedData.class).iterator().next();
                for (Entry<String, String> data : capturedData.getData().entrySet()) {
                    if (statsMap.containsKey(data.getKey())) {
                        statsMap.get(data.getKey()).add(data.getValue());
                    } else {
                        CopyOnWriteArrayList<String> stats = new CopyOnWriteArrayList<String>();
                        stats.add(data.getValue());
                        statsMap.put((String) data.getKey(), stats);
                    }
                }
            }
        }
    }   
    
    /** the types of the columns of this table */
    private static final Class[] TYPES = {String.class, String.class, String.class, String.class, String.class, String.class};
    
    /** the titles of the columns of this table */
    private static final String[] TITLES = {"Field", "Least", "Most", "Average", "Minimum", "Maximum"};
    
    /** the types of the columns of this table */
    private final ConcurrentHashMap<String, CopyOnWriteArrayList<String>> statsMap;

    /**
     * Creates newly-instantiated CapturedDataTableModel object.
     * 
     * @param game the game that this table will be associated to.
     */
    public SummaryTableModel(Game game) {
        super(game, TYPES, TITLES);
        this.statsMap = new ConcurrentHashMap<String, CopyOnWriteArrayList<String>>();
    }

    /**
     * Populates the table retrieving information from the specified selected row ids.
     * 
     * @param ids the ids of the objects
     * @param selectedRows the ids of the select rows
     */
    public void populate(List<ObjectId> ids, int[] selectedRows) {
        setRowCount(0);
        statsMap.clear();
        ExecutorService executor = Executors.newFixedThreadPool(50);
        for (int selectedRow : selectedRows) {
            Runnable worker = new DatabaseQueryRunnable(ids.get(selectedRow));
            executor.execute(worker);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        if (statsMap.size() > 0) {
            MongoCollection fieldsCollection = database.getCollection("fields");
            String fieldQuery = String.format("{gameId: '%s'}", game.getKey().toString());
            Iterable<Field> fields = fieldsCollection.find(fieldQuery).as(Field.class);
            for (Field field : fields) {
                List<String> stats = statsMap.get(field.getName().toLowerCase());
                String least = "-";
                String most = "-";
                String average = "-";
                String minimum = "-";
                String maximum = "-";
                if (field.getType() == FieldType.TEXT) {
                    Map<String, Integer> textCounts = new HashMap<String, Integer>();
                    for (String stat : stats) {
                        if (textCounts.containsKey(stat)) {
                            textCounts.put(stat, textCounts.get(stat) + 1);
                        } else {
                            textCounts.put(stat, 1);
                        }
                        Map.Entry<String, Integer> maxEntry = null;
                        Map.Entry<String, Integer> minEntry = null;
                        Double sum = 0.0;
                        for (Entry<String, Integer> entry : textCounts.entrySet()) {
                            sum += entry.getValue();
                            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                                maxEntry = entry;
                            }
                            if (minEntry == null || entry.getValue() < minEntry.getValue()) {
                                minEntry = entry;
                            }
                        }
                        least = String.format("%s (%s%%)", minEntry.getKey(), Math.round((minEntry.getValue() / sum) * 100));
                        most = String.format("%s (%s%%)", maxEntry.getKey(), Math.round((maxEntry.getValue() / sum) * 100));     
                    }
                } else if (field.getType() == FieldType.INTEGER || field.getType() == FieldType.DECIMAL) {
                    List<Integer> integerStats = new LinkedList<Integer>();
                    for (String stat : stats) {
                        integerStats.add(Integer.valueOf(stat));
                    }
                    minimum = Collections.min(integerStats).toString();
                    maximum = Collections.max(integerStats).toString();
                    double sum = 0;
                    for (double stat : integerStats) {
                        sum += stat;
                    }
                    average = String.valueOf(Math.round(sum / integerStats.size()));
                }
                addRow(new Object[]{
                    field,
                    least,
                    most,
                    average,
                    minimum,
                    maximum,});
            }
        }
    }
}
