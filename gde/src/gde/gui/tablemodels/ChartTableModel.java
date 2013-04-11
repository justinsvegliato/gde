package gde.gui.tablemodels;

import static gde.gui.tablemodels.TableModel.database;
import gde.models.Chart;
import gde.models.Field;
import gde.models.Game;
import org.bson.types.ObjectId;
import org.jongo.MongoCollection;

public class ChartTableModel extends TableModel<Chart> {
    private static final Class[] TYPES = {String.class, String.class, String.class, String.class};
    private static final String[] TITLES = {"Title", "Horizontal Axis", "Vertical Axis", "Chart Type"};

    public ChartTableModel(Game game) {
        super(game, TYPES, TITLES);
    }  

    @Override
    public void populate() {
        setRowCount(0);
        MongoCollection chartsCollection = database.getCollection("charts");
        String chartsQuery = String.format("{gameId: '%s'}", game.getKey().toString());
        Iterable<Chart> charts = chartsCollection.find(chartsQuery).as(Chart.class);
        for (Chart chart : charts) {
            addRow(chart);
        }
    }

    @Override
    public void update(Chart entry) {
        addRow(entry);
    }
    
    private void addRow(Chart chart) {
        MongoCollection fieldsCollection = database.getCollection("fields");
        Field xAxisField = fieldsCollection.findOne(new ObjectId(chart.getxAxisFieldId())).as(Field.class);
        Field yAxisField = fieldsCollection.findOne(new ObjectId(chart.getyAxisFieldId())).as(Field.class);
        addRow(new Object[] {
            chart.getTitle(),
            xAxisField.getName(),
            yAxisField.getName(),
            chart.getChartType()
        });
    }
}
