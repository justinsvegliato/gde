package gde.gui.tablemodels;

import gde.models.Chart.ChartType;

public class ChartHeader {

    private final String title;
    private final ChartType type;

    public ChartHeader(String title, ChartType type) {
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
