package gde.gui.tablemodels;

import gde.models.Game;
import gde.models.Instance;
import javax.swing.SwingUtilities;

/**
 * The InstanceTableModel class handles all interactions with the table that contains data types of this sort.
 * 
 * @author Justin Svegliato and Andrew Evans
 */
public class InstanceTableModel extends CollectionTableModel<Instance> {
    
    /** the types of the columns of this table */
    private static final Class[] TYPES = {String.class};
    
    /** the titles of the columns of this table */
    private static final String[] TITLES = {"Players"};
    
    /** the collection that will be operated upon */
    private static final String COLLECTION = "instances";
    
    /**
     * Creates newly-instantiated CapturedDataTableModel object.
     * 
     * @param game the game that this table will be associated to.
     */
    public InstanceTableModel(Game game) {
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
        Iterable<Instance> instances = collection.find(query).as(Instance.class);
        for (final Instance instance : instances) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    addRow(instance);
                }
            });
        }
    }
    
    /**
     * Populates the table with all Instances in the collection that are associated with the game.
     */
    @Override
    public void populate() {
        String query = String.format("{gameId: '%s'}", game.getKey().toString());
        populate(query);
    }
    
    /**
     * Gets the Instance at the specified row.
     * 
     * @param rowId the row which contains the Instance
     * @return the Instance at the specified row.
     */
    @Override
    public Instance getEntryAt(int rowId) {
        return collection.findOne(ids.get(rowId)).as(Instance.class);
    }

    /**
     * Sets the Instance at the specified row with the specified Instance.
     * 
     * @param rowId the id of the row that will be updated.
     * @param entry the Instance to be inserted into this position.
     */
    @Override
    public void setEntryAt(int rowId, Instance entry) {
        setValueAt(entry.getIdentifier(), rowId, 0);
    }
    /**
     * Adds a row to the end of the table.
     * 
     * @param entry the Instance to be added.
     */
    @Override
    protected void addRow(Instance entry) {
        addRow(new Object[] {entry.getIdentifier()});
        ids.add(entry.getKey());
    }
}