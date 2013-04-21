package gde.gui.util;

import gde.models.Chart.ChartType;

public class ChartTableCellData {

    private final String title;
    private final ChartType type;

    public ChartTableCellData(String title, ChartType type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public ChartType getType() {
        return type;
    }
}
