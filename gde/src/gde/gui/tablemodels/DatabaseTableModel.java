package gde.gui.tablemodels;

import gde.models.Entry;
import gde.models.Game;
import java.util.LinkedList;
import java.util.List;
import org.bson.types.ObjectId;
import org.jongo.MongoCollection;

public abstract class DatabaseTableModel<T extends Entry> extends TableModel<T> {

    protected final MongoCollection collection;
    protected final List<ObjectId> ids;

    public DatabaseTableModel(Game game, Class[] types, String[] titles, String collection) {
        super(game, types, titles);
        this.ids = new LinkedList<ObjectId>();
        this.collection = database.getCollection(collection);
    }

    public abstract void populate(String query);

    @Override
    public void add(T entry) {
        collection.save(entry);
        addRow(entry);
    }

    @Override
    public void remove(int[] rowIds) {
        for (int i = 0; i < rowIds.length; i++) {
            collection.remove(ids.remove((int) rowIds[i] - i));
            removeRow(rowIds[i] - i);
        }
    }

    @Override
    public void update(T entry, int rowId) {
        setEntryAt(rowId, entry);
        collection.update(ids.get(rowId)).merge(entry);
    }
}