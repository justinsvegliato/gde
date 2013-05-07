package gde.gui.tablemodels;

import gde.models.Field;
import gde.models.Game;
import javax.swing.SwingUtilities;

public class FieldTableModel extends CollectionTableModel<Field> {
    private static final Class[] TYPES = {String.class, String.class};
    private static final String[] TITLES = {"Name", "Type"};
    private static final String COLLECTION = "fields";
    
    public FieldTableModel(Game game) {
        super(game, TYPES, TITLES, COLLECTION);
    }

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
    
    @Override
    public void populate() {
        String query = String.format("{gameId: '%s'}", game.getKey().toString());
        populate(query);
    }
    
    @Override
    public Field getEntryAt(int rowId) {
        return collection.findOne(ids.get(rowId)).as(Field.class);
    }

    @Override
    public void setEntryAt(int rowId, Field entry) {
        setValueAt(entry.getName(), rowId, 0);
        setValueAt(entry.getType(), rowId, 1);
    }

    @Override
    protected void addRow(Field entry) {
        addRow(new Object[] {
            entry.getName(),
            entry.getType()
        });
        ids.add(entry.getKey());
    }
}