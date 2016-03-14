package gde.gui.util;

import gde.models.Chart.ChartType;

/**
 * The ChartTableCellData class is a helper that is passed into the ChartTableCellRenderer class. 
 * 
 * @author Justin Svegliato and Andrew Evans
 */
public class ChartTableCellData {

    /** the chart title */
    private final String title;
    
    /** the chart type */
    private final ChartType type;

    /**
     * Instantiates a new ChartTableCellData object with a given title and chart type.
     * 
     * @param title the chart title
     * @param type the chart type
     */
    public ChartTableCellData(String title, ChartType type) {
        this.title = title;
        this.type = type;
    }

    /**
     * Returns the chart title.
     * 
     * @return the chart title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the chart type.
     * 
     * @return the chart type
     */
    public ChartType getType() {
        return type;
    }
}
