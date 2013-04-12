package gde.gui.tablemodels;

import com.mongodb.WriteResult;
import gde.gui.util.DatabaseHandler;
import gde.models.Entry;
import gde.models.Game;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.bson.types.ObjectId;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

public abstract class TableModel<T extends Entry> extends DefaultTableModel {

    protected static final Jongo database = DatabaseHandler.getDatabase();
    protected final List<ObjectId> ids;
    protected final MongoCollection collection;
    protected final Class[] types;
    protected final String[] titles;
    protected final Game game;

    public TableModel(Game game, Class[] types, String[] titles, String collection) {
        this.ids = new LinkedList<ObjectId>();
        this.collection = database.getCollection(collection);
        this.game = game;
        this.types = types;
        this.titles = titles;
        setColumnIdentifiers(this.titles);
    }

    public abstract void populate(String query);

    public abstract void populate();

    public void add(T entry) {
        collection.save(entry);
        addRow(entry);
    }

    public void remove(int[] rowIds) {
        for (int i = 0; i < rowIds.length; i++) {
            collection.remove(ids.remove((int) rowIds[i] - i));
            removeRow(rowIds[i] - i);
        }
    }

    public void update(T entry, int rowId) {
        setEntryAt(rowId, entry);
        collection.update(ids.get(rowId)).merge(entry);
    }
    
    public abstract T getEntryAt(int rowId);

    public abstract void setEntryAt(int rowId, T entry);
    
    @Override
    public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
    
    protected abstract void addRow(T entry);
}