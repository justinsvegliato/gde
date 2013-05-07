package gde.gui.tablemodels;

import com.sun.jmx.snmp.Timestamp;
import static gde.gui.tablemodels.TableModel.database;
import gde.models.CapturedData;
import gde.models.Field;
import gde.models.Field.FieldType;
import gde.models.Game;
import gde.models.Instance;
import java.text.DateFormat;
import java.util.LinkedList;
import java.util.List;
import javax.swing.SwingUtilities;
import org.bson.types.ObjectId;
import org.jongo.MongoCollection;

/**
 * The CapturedDataTableModel class handles all interactions with the table that contains data types of this sort.
 * 
 * @author Justin Svegliato and Andrew Evans
 */
public class CapturedDataTableModel extends CollectionTableModel<CapturedData> {

    /** the collection that will be operated upon */
    private static final String COLLECTION = "captureddata";

    /**
     * Creates newly-instantiated CapturedDataTableModel object.
     * 
     * @param game the game that this table will be associated to.
     */
    public CapturedDataTableModel(Game game) {
        super(game, getTypes(game), getTitles(game), COLLECTION);
    }

    /**
     * Populates the table with all CapturedData in the collection that match the specified query.
     * 
     * @param query the query that will be used to retrieve the documents
     */
    @Override
    public void populate(String query) {
        ids.clear();
        setRowCount(0);
        Iterable<CapturedData> capturedData = collection.find(query).as(CapturedData.class);
        for (final CapturedData capturedDatum : capturedData) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    addRow(capturedDatum);
                }
            });
        }
    }

    /**
     * Populates the table with all CapturedData in the collection.
     */
    @Override
    public void populate() {
        populate("");
    }

    /**
     * Gets the CapturedData at the specified row.
     * 
     * @param rowId the row which contains the CapturedData
     * @return the CapturedData at the specified row.
     */
    @Override
    public CapturedData getEntryAt(int rowId) {
        return collection.findOne(ids.get(rowId)).as(CapturedData.class);
    }

   /**
     * Sets the CapturedData at the specified row with the specified CapturedData.
     * 
     * @param rowId the id of the row that will be updated.
     * @param entry the CapturedData to be inserted into this position.
     */
    @Override
    public void setEntryAt(int rowId, CapturedData entry) {
        for (int i = 0; i < titles.length; i++) {
            setValueAt(entry.getData().get(titles[i].toLowerCase()), rowId, i);
        }
    }

    /**
     * Adds a row to the end of the table.
     * 
     * @param entry the CapturedData to be added.
     */
    @Override
    protected void addRow(CapturedData data) {
        final Object[] objects = new Object[titles.length];
        DateFormat shortDf = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        objects[0] = shortDf.format(data.getCreateDate());
        MongoCollection instanceCollection = database.getCollection("instances");
        Instance instance = instanceCollection.findOne(new ObjectId(data.getInstanceId())).as(Instance.class);
        objects[1] = instance.getIdentifier();
        for (int i = 2; i < titles.length; i++) {
            objects[i] = data.getData().get(titles[i].toLowerCase());
        }
        addRow(objects);
        ids.add(data.getKey());
    }
    
    /**
     * Gets the corresponding data type of the specified field type.
     * 
     * @param type the type to be converted
     * @return the corresponding data type of the specified field type.
     */
    private static Class convertToType(FieldType type) {
        switch (type) {
            case INTEGER:
                return Integer.class;
            case DECIMAL:
                return Double.class;
            case BOOLEAN:
                return Boolean.class;
            case TEXT:
                return String.class;
        }
        return null;
    }

    /**
     * Gets the titles of the table by checking the fields in the database
     * 
     * @param game the game that that we are getting the titles for 
     * @return the titles of the table
     */
    private static String[] getTitles(Game game) {
        List<String> titles = new LinkedList<String>();
        titles.add("Date");
        titles.add("Identifier");
        MongoCollection fieldsCollection = database.getCollection("fields");
        String fieldQuery = String.format("{gameId: '%s'}", game.getKey().toString());
        Iterable<Field> fields = fieldsCollection.find(fieldQuery).as(Field.class);
        for (Field field : fields) {
            titles.add(field.getName());
        }
        return titles.toArray(new String[titles.size() - 1]);
    }

    /**
     * Gets the types of the table by checking the fields in the database
     * 
     * @param game the game that that we are getting the types for 
     * @return the types of the table
     */
    private static Class[] getTypes(Game game) {
        List<Class> types = new LinkedList<Class>();
        types.add(Timestamp.class);
        types.add(String.class);
        MongoCollection fieldsCollection = database.getCollection("fields");
        String fieldQuery = String.format("{gameId: '%s'}", game.getKey().toString());
        Iterable<Field> fields = fieldsCollection.find(fieldQuery).as(Field.class);
        for (Field field : fields) {
            types.add(convertToType(field.getType()));
        }
        return types.toArray(new Class[types.size() - 1]);
    }
}
