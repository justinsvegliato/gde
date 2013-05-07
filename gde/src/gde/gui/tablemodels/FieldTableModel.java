package gde.gui.tablemodels;

import gde.models.Field;
import gde.models.Game;
import javax.swing.SwingUtilities;

/**
 * The FieldTableModel class handles all interactions with the table that contains data types of this sort.
 * 
 * @author Justin Svegliato and Andrew Evans
 */
public class FieldTableModel extends CollectionTableModel<Field> {
    
    /** the types of the columns of this table */
    private static final Class[] TYPES = {String.class, String.class};
    
    /** the titles of the columns of this table */
    private static final String[] TITLES = {"Name", "Type"};
    
    /** the collection that will be operated upon */
    private static final String COLLECTION = "fields";
    
    /**
     * Creates newly-instantiated FieldTableModel object.
     * 
     * @param game the game that this table will be associated to.
     */
    public FieldTableModel(Game game) {
        super(game, TYPES, TITLES, COLLECTION);
    }

    /**
     * Populates the table with all documents in the collection that match the specified query.
     * 
     * @param query the query that will be used to retrieve the documents
     */
    @Override
    public void populate(String query) {
        ids.clear();
        setRowCount(0);
        Iterable<Field> fields = collection.find(query).as(Field.class);
        for (final Field field : fields) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    addRow(field);
                }
            });
        }
    }
    
    /**
     * Populates the table with all Fields in the collection that are associated with the game.
     */
    @Override
    public void populate() {
        String query = String.format("{gameId: '%s'}", game.getKey().toString());
        populate(query);
    }
    
    /**
     * Gets the Field at the specified row.
     * 
     * @param rowId the row which contains the Field
     * @return the Field at the specified row.
     */
    @Override
    public Field getEntryAt(int rowId) {
        return collection.findOne(ids.get(rowId)).as(Field.class);
    }

   /**
     * Sets the Field at the specified row with the specified Field.
     * 
     * @param rowId the id of the row that will be updated.
     * @param entry the Field to be inserted into this position.
     */
    @Override
    public void setEntryAt(int rowId, Field entry) {
        setValueAt(entry.getName(), rowId, 0);
        setValueAt(entry.getType(), rowId, 1);
    }

    /**
     * Adds a row to the end of the table.
     * 
     * @param entry the Field to be added.
     */
    @Override
    protected void addRow(Field entry) {
        addRow(new Object[] {
            entry.getName(),
            entry.getType()
        });
        ids.add(entry.getKey());
    }
}