package gde.gui.tablemodels;

import gde.models.Developer;
import gde.models.Game;
import javax.swing.SwingUtilities;
import org.bson.types.ObjectId;

public class DeveloperTableModel extends CollectionTableModel<Developer> {
    private static final Class[] TYPES = {String.class, String.class, String.class};
    private static final String[] TITLES = {"Name", "Company", "Username"};
    private static final String COLLECTION = "developers";
    
    public DeveloperTableModel(Game game) {
        super(game, TYPES, TITLES, COLLECTION);
    }

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
    
    @Override
    public Developer getEntryAt(int rowId) {
        return collection.findOne(ids.get(rowId)).as(Developer.class);
    }

    @Override
    public void setEntryAt(int rowId, Developer entry) {
        setValueAt(entry.getFirstName() + " " + entry.getLastName(), rowId, 0);
        setValueAt(entry.getCompany(), rowId, 1);
        setValueAt(entry.getUsername(), rowId, 2);
    }

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