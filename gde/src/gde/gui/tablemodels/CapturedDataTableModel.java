package gde.gui.tablemodels;

import static gde.gui.tablemodels.TableModel.database;
import gde.models.CapturedData;
import gde.models.Field;
import static gde.models.Field.FieldType.BOOLEAN;
import static gde.models.Field.FieldType.DECIMAL;
import static gde.models.Field.FieldType.INTEGER;
import static gde.models.Field.FieldType.TEXT;
import gde.models.Game;
import java.util.LinkedList;
import java.util.List;
import org.jongo.MongoCollection;

public class CapturedDataTableModel extends TableModel<CapturedData> {
    private static final String COLLECTION = "captureddata";

    public CapturedDataTableModel(Game game) {
        super(game, getTypes(game), getTitles(game), COLLECTION);
    }

    @Override
    public void populate(String query) {
        setRowCount(0);       
        Iterable<CapturedData> capturedData = collection.find(query).as(CapturedData.class);
        for (CapturedData capturedDatum : capturedData) {
            addRow(capturedDatum);
        }
    }  
    
    @Override
    public void populate() {
        populate("");
    }
       
    @Override
    public CapturedData getEntryAt(int rowId) {
        return collection.findOne(ids.get(rowId)).as(CapturedData.class);
    }
    
    @Override
    public void setEntryAt(int rowId, CapturedData entry) {
        for (int i = 0; i < titles.length; i++) {
            setValueAt(entry.getData().get(titles[i].toLowerCase()), rowId, i);
        }
    }
    
    @Override
    protected void addRow(CapturedData data) {
        Object[] objects = new Object[titles.length];
        for (int i = 0; i < titles.length; i++) {
            objects[i] = data.getData().get(titles[i].toLowerCase());
        }
        addRow(objects);
        ids.add(data.getKey());
    }

    private static Class convertToType(Field.FieldType type) {
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
    
    private static String[] getTitles(Game game) {
        List<String> titles = new LinkedList<String>();
        MongoCollection fieldsCollection = database.getCollection("fields");
        String fieldQuery = String.format("{gameId: '%s'}", game.getKey().toString());
        Iterable<Field> fields = fieldsCollection.find(fieldQuery).as(Field.class);
        for (Field field : fields) {
            titles.add(field.getName());
        }
        return titles.toArray(new String[titles.size() - 1]);
    }
    
    private static Class[] getTypes(Game game) {
        List<Class> types = new LinkedList<Class>();
        MongoCollection fieldsCollection = database.getCollection("fields");
        String fieldQuery = String.format("{gameId: '%s'}", game.getKey().toString());
        Iterable<Field> fields = fieldsCollection.find(fieldQuery).as(Field.class);
        for (Field field : fields) {
            types.add(convertToType(field.getType()));
        }
        return types.toArray(new Class[types.size() - 1]);
    }

}