package gde.gui.util;

import gde.models.Chart.ChartType;

public class ChartTableCellData {

    private final String title;
    private final ChartType type;

    /**
     * Instantiates a new ChartTableCellData object with a given title and chart type.
     * @param title Chart title.
     * @param type Chart type.
     */
    public ChartTableCellData(String title, ChartType type) {
        this.title = title;
        this.type = type;
    }

    /**
     * Returns the chart title.
     * @return chart title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the chart type.
     * @return chart type.
     */
    public ChartType getType() {
        return type;
    }
}
