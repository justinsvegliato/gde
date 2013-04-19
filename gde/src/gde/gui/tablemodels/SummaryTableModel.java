package gde.gui.tablemodels;

import gde.gui.util.FieldSummary;
import gde.models.Field;
import gde.models.Game;
import org.jongo.MongoCollection;

public class SummaryTableModel extends TableModel<FieldSummary> {

    private static final Class[] TYPES = {String.class, String.class, String.class, String.class, String.class};
    private static final String[] TITLES = {"Field", "Mode", "Average", "Minimum", "Maximum"};

    public SummaryTableModel(Game game) {
        super(game, TYPES, TITLES);
    }

    @Override
    public void populate() {
        setRowCount(0);
        MongoCollection collection = database.getCollection("fields");
        String query = String.format("{gameId: '%s'}", game.getKey().toString());
        Iterable<Field> fields = collection.find(query).as(Field.class);
        for (Field field : fields) {
            FieldSummary fieldSummary = new FieldSummary(field.getName(), "", 1, 2, 3);
            addRow(fieldSummary);
        }
    }

    @Override
    public void add(FieldSummary entry) {
    }

    @Override
    public void remove(int[] rowIds) {
    }

    @Override
    public void update(FieldSummary entry, int rowId) {
    }

    @Override
    public FieldSummary getEntryAt(int rowId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEntryAt(int rowId, FieldSummary entry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void addRow(FieldSummary entry) {
        addRow(new Object[]{
            entry.getField(),
            entry.getMode(),
            entry.getAverage(),
            entry.getMinimum(),
            entry.getMaximum()
        });
    }
}