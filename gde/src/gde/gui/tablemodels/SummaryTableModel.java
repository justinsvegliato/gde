package gde.gui.tablemodels;

import gde.gui.util.FieldSummary;
import gde.models.CapturedData;
import gde.models.Field;
import gde.models.Game;
import org.jongo.MongoCollection;

public class SummaryTableModel extends TableModel<FieldSummary> {

    private static final Class[] TYPES = {String.class, String.class, String.class, String.class, String.class};
    private static final String[] TITLES = {"Field", "Average", "Mode", "Minimum", "Maximum"};

    public SummaryTableModel(Game game) {
        super(game, TYPES, TITLES);
    }

    public void populate(String query) {
        setRowCount(0);
        MongoCollection collection = database.getCollection("fields");
        MongoCollection capturedData = database.getCollection("captureddata");
        String fieldQuery = String.format("{gameId: '%s'}", game.getKey().toString());
        Iterable<Field> fields = collection.find(fieldQuery).as(Field.class);
        for (Field field : fields) {
            //System.out.println(query + String.format("average: {$avg: '$%s'}}",field.getName().toLowerCase()));
            //double average = capturedData.aggregate({$match: {%s: }, {average: {$avg: field.getName().toLowerCase())}}",).as(FieldSummary.class).get(0).getAverage();
            
            double average = 0.0;
            FieldSummary fieldSummary = new FieldSummary(field.getName(), average, "1.0", 2, 3);
            addRow(fieldSummary);
        }
    }
    
    @Override
    public void populate() {
        populate("");
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
            entry.getAverage(),
            entry.getMode(),
            entry.getMinimum(),
            entry.getMaximum()
        });
    }
}