package gde.gui.tablemodels;

import static gde.gui.tablemodels.TableModel.database;
import gde.models.Chart;
import gde.models.Field;
import gde.models.Game;
import gde.gui.tablemodels.ChartHeader;
import java.awt.Component;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import org.bson.types.ObjectId;
import org.jongo.MongoCollection;

public class ChartTableModel extends TableModel<Chart> {

    private static final Class[] TYPES = {ChartHeader.class};
    private static final String[] TITLES = {"Title"};
    private static final String COLLECTION = "charts";

    public ChartTableModel(Game game) {
        super(game, TYPES, TITLES, COLLECTION);
    }

    @Override
    public void populate(String query) {
        setRowCount(0);
        Iterable<Chart> charts = collection.find(query).as(Chart.class);
        for (Chart chart : charts) {
            addRow(chart);
        }
    }

    @Override
    public void populate() {
        String query = String.format("{gameId: '%s'}", game.getKey().toString());
        populate(query);
    }

    @Override
    public Chart getEntryAt(int rowId) {
        return collection.findOne(ids.get(rowId)).as(Chart.class);
    }

    @Override
    public void setEntryAt(int rowId, Chart entry) {
        setValueAt(new ChartHeader(entry.getTitle(), entry.getChartType()), rowId, 0);
    }

    @Override
    protected void addRow(Chart chart) {
        addRow(new Object[]{
            new ChartHeader(chart.getTitle(), chart.getChartType())
        });

        ids.add(chart.getKey());
    }
}