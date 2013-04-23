package gde.gui.tablemodels;

import gde.gui.util.ChartTableCellData;
import gde.models.CapturedData;
import gde.models.Chart;
import gde.models.Game;
import javax.swing.SwingUtilities;

public class ChartTableModel extends CollectionTableModel<Chart> {

    private static final Class[] TYPES = {String.class};
    private static final String[] TITLES = {"Title"};
    private static final String COLLECTION = "charts";

    public ChartTableModel(Game game) {
        super(game, TYPES, TITLES, COLLECTION);
    }

    @Override
    public void populate(String query) {
        ids.clear();
        setRowCount(0);
        Iterable<Chart> charts = collection.find(query).as(Chart.class);
        for (final Chart chart : charts) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    addRow(chart);
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
    public Chart getEntryAt(int rowId) {
        return collection.findOne(ids.get(rowId)).as(Chart.class);
    }

    @Override
    public void setEntryAt(int rowId, Chart entry) {
        setValueAt(new ChartTableCellData(entry.getTitle(), entry.getChartType()), rowId, 0);
    }

    @Override
    protected void addRow(Chart chart) {
        addRow(new Object[]{
            new ChartTableCellData(chart.getTitle(), chart.getChartType())
        });

        ids.add(chart.getKey());
    }
}