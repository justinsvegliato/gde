package gde.gui.tablemodels;

import gde.gui.util.ChartTableCellData;
import gde.models.Chart;
import gde.models.Game;
import javax.swing.SwingUtilities;

/**
 * The ChartTableModel class handles all interactions with the table that contains data types of this sort.
 * 
 * @author Justin Svegliato and Andrew Evans
 */
public class ChartTableModel extends CollectionTableModel<Chart> {

    /** the types of the columns of this table */
    private static final Class[] TYPES = {String.class};
    
    /** the titles of the columns of this table */
    private static final String[] TITLES = {"Title"};
    
    /** the collection that will be operated upon */
    private static final String COLLECTION = "charts";

    /**
     * Creates newly-instantiated ChartTableModel object.
     * 
     * @param game the game that this table will be associated to.
     */
    public ChartTableModel(Game game) {
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
        Iterable<Chart> charts = collection.find(query).as(Chart.class);
        for (final Chart chart : charts) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    addRow(chart);
                }
            });
        }
    }

    /**
     * Populates the table with all Charts in the collection that are associated with the game.
     */
    @Override
    public void populate() {
        String query = String.format("{gameId: '%s'}", game.getKey().toString());
        populate(query);
    }

    /**
     * Gets the Chart at the specified row.
     * 
     * @param rowId the row which contains the chart
     * @return the chart at the specified row.
     */
    @Override
    public Chart getEntryAt(int rowId) {
        return collection.findOne(ids.get(rowId)).as(Chart.class);
    }

   /**
     * Sets the Chart at the specified row with the specified Chart.
     * 
     * @param rowId the id of the row that will be updated.
     * @param entry the Chart to be inserted into this position.
     */
    @Override
    public void setEntryAt(int rowId, Chart entry) {
        setValueAt(new ChartTableCellData(entry.getTitle(), entry.getChartType()), rowId, 0);
    }

    /**
     * Adds a row to the end of the table.
     * 
     * @param entry the Chart to be added.
     */
    @Override
    protected void addRow(Chart chart) {
        addRow(new Object[]{
            new ChartTableCellData(chart.getTitle(), chart.getChartType())
        });
        ids.add(chart.getKey());
    }
}
