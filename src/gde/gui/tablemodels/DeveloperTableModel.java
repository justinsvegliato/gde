package gde.gui.tablemodels;

import gde.models.Developer;
import gde.models.Game;
import javax.swing.SwingUtilities;
import org.bson.types.ObjectId;

/**
 * The DeveloperTableModel class handles all interactions with the table that contains data types of this sort.
 * 
 * @author Justin Svegliato and Andrew Evans
 */
public class DeveloperTableModel extends CollectionTableModel<Developer> {
    
    /** the types of the columns of this table */
    private static final Class[] TYPES = {String.class, String.class, String.class};
    
    /** the titles of the columns of this table */
    private static final String[] TITLES = {"Name", "Company", "Username"};
    
    /** the collection that will be operated upon */
    private static final String COLLECTION = "developers";
    
    /**
     * Creates newly-instantiated DeveloperTableModel object.
     * 
     * @param game the game that this table will be associated to.
     */
    public DeveloperTableModel(Game game) {
        super(game, TYPES, TITLES, COLLECTION);
    }

    /**
     * Populates the table with all developers in the collection that match the specified query.
     * 
     * @param query the query that will be used to retrieve the documents
     */
    @Override
    public void populate(String query) {
        ids.clear();
        setRowCount(0);
        Iterable<Developer> developers = collection.find(query).as(Developer.class);
        for (final Developer developer : developers) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    addRow(developer);
                }
            });
        }
    }
    
    /**
     * Populates the table with all developers in the collection that are associated with the game.
     */
    @Override
    public void populate() {
        StringBuilder builder = new StringBuilder();        
        for (int i = 0; i < game.getDeveloperIds().size(); i++) {            
            String delimiter = i < game.getDeveloperIds().size() - 1 ? ", " : "";
            Developer developer = collection.findOne(new ObjectId(game.getDeveloperIds().get(i))).as(Developer.class);           
            builder.append("'").append(developer.getUsername()).append("'").append(delimiter);
        }
        String query = String.format("{username: {$in: [%s]}}", builder.toString());
        populate(query);
    }
    
    /**
     * Gets the Developer at the specified row.
     * 
     * @param rowId the row which contains the Developer
     * @return the Developer at the specified row.
     */
    @Override
    public Developer getEntryAt(int rowId) {
        return collection.findOne(ids.get(rowId)).as(Developer.class);
    }

   /**
     * Sets the Developer at the specified row with the specified Developer.
     * 
     * @param rowId the id of the row that will be updated.
     * @param entry the Developer to be inserted into this position.
     */
    @Override
    public void setEntryAt(int rowId, Developer entry) {
        setValueAt(entry.getFirstName() + " " + entry.getLastName(), rowId, 0);
        setValueAt(entry.getCompany(), rowId, 1);
        setValueAt(entry.getUsername(), rowId, 2);
    }

    /**
     * Adds a row to the end of the table.
     * 
     * @param entry the Developer to be added.
     */
    @Override
    protected void addRow(Developer entry) {
        addRow(new Object[] {
            entry.getFirstName() + " " + entry.getLastName(),
            entry.getCompany(),
            entry.getUsername()
        });
        ids.add(entry.getKey());
    }
}