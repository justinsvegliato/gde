package gde.gui.tablemodels;

import gde.models.Entry;
import gde.models.Game;
import java.util.LinkedList;
import java.util.List;
import org.bson.types.ObjectId;
import org.jongo.MongoCollection;

/**
 * The CollectionTableModel class provides the basic functionality of database operations while ensuring that the
 * table is consistent as well. 
 * 
 * @author Justin Svegliato and Andrew Evans
 * @param <T> the Class type that all database operations will return
 */
public abstract class CollectionTableModel<T extends Entry> extends TableModel {

    /** the collection that the operation will be performed on */
    protected final MongoCollection collection;
    
    /** a list containing all of the ids of the database object (these are in order with the table rows */
    protected final List<ObjectId> ids;

    /**
     * Creates a newly-instantiated CollectionTableModel object.
     * 
     * @param game the game that is associated with this model
     * @param types the column types, namely Integer, String, or perhaps Boolean, which depend upon the game
     * @param titles the column titles that depend upon the game
     * @param collection the collection that the operation will be performed on
     */
    public CollectionTableModel(Game game, Class[] types, String[] titles, String collection) {
        super(game, types, titles);
        ids = new LinkedList<ObjectId>();
        this.collection = database.getCollection(collection);
    }

    /**
     * Populates the table with all documents in the collection.
     */
    public abstract void populate();

    /**
     * Populates the table with all documents in the collection that match the specified query.
     * 
     * @param query the query that will be used to retrieve the documents
     */
    public abstract void populate(String query);
    
    /**
     * Adds an entry to the table while also updating the table.
     * 
     * @param entry the entry to be added
     */
    public void add(T entry) {
        collection.save(entry);
        addRow(entry);
    }

    /**
     * Removes an entry from the table while also updating the table.
     * 
     * @param rowIds the ids of the rows to be removed
     */
    public void remove(int[] rowIds) {
        for (int i = 0; i < rowIds.length; i++) {
            collection.remove(ids.remove((int) rowIds[i] - i));
            removeRow(rowIds[i] - i);
        }
    }

    /**
     * Updates the specified row with the given entry while updating the table.
     * 
     * 
     * @param entry the entry to be updated
     * @param rowId the id the row to be updated
     */
    public void update(T entry, int rowId) {
        setEntryAt(rowId, entry);
        collection.update(ids.get(rowId)).merge(entry);
    }
    
    /**
     * Gets the entry at the specified row.
     * 
     * @param rowId the row which contains the entry
     * @return the entry at the specified row.
     */
    public abstract T getEntryAt(int rowId);

    /**
     * Sets the entry at the specified row with the specifiedentry.
     * 
     * @param rowId the id of the row that will be updated.
     * @param entry the entry to be inserted into this position.
     */
    public abstract void setEntryAt(int rowId, T entry);
    
    /**
     * Adds a row to the end of the table.
     * 
     * @param entry the entry to be added.
     */
    protected abstract void addRow(T entry);
    
    /**
     * Gets the ids of the database objects.
     *
     * @return the ids of the database objects.
     */
    public List<ObjectId> getIds() {
        return ids;
    }
}