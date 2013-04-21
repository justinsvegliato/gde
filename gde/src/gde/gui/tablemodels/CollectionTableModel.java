package gde.gui.tablemodels;

import gde.models.Entry;
import gde.models.Game;
import java.util.LinkedList;
import java.util.List;
import org.bson.types.ObjectId;
import org.jongo.MongoCollection;

public abstract class CollectionTableModel<T extends Entry> extends TableModel {

    protected final MongoCollection collection;
    protected final List<ObjectId> ids;

    public CollectionTableModel(Game game, Class[] types, String[] titles, String collection) {
        super(game, types, titles);
        ids = new LinkedList<ObjectId>();
        this.collection = database.getCollection(collection);
    }

    public abstract void populate();

    public abstract void populate(String query);
    
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
    
    protected abstract void addRow(T data);
    
    public List<ObjectId> getIds() {
        return ids;
    }
}