package gde.models;

/**
 * The implementation of the Chart data structure that is used by MongoDB
 * as well as the application.
 *
 * @author Justin Svegliato and Andrew Evans
 */
public class Chart extends Entry {

    /** the available chart types */
    public enum ChartType {
        LINE,
        PIE,
        BAR,
        MAP,
        SCATTER;
        
        /**
         * Returns a mixed cased version of the chart type.
         * 
         * @return a mixed cased version of the chart type
         */
        @Override
        public String toString() {
            return name().substring(0, 1).toUpperCase() + name().substring(1).toLowerCase(); 
        }
    }
    
    /** the title of the chart */
    private String title;
    
    /** the id of the associated x-axis field */
    private String xAxisFieldId;
    
    /** the id of the associated y-axis field */
    private String yAxisFieldId;
    
    /** the chart type of the chart */
    private ChartType chartType;
    
    /** the id of the associated game */
    private String gameId;
    
    /**
     * Instantiates a newly-created Chart object.
     */
    public Chart() {
    }

    /**
     * Instantiates a newly-created Chart object.
     * 
     * @param title the title of the chart
     * @param xAxisFieldId the id of the associated x-axis field
     * @param yAxisFieldId the id of the associated y-axis field
     * @param chartType the chart type of the chart
     * @param gameId the id of the associated game
     */
    public Chart(String title, String xAxisFieldId, String yAxisFieldId, ChartType chartType, String gameId) {
        this.title = title;
        this.xAxisFieldId = xAxisFieldId;
        this.yAxisFieldId = yAxisFieldId;
        this.chartType = chartType;
        this.gameId = gameId;
    }
    
    /**
     * Gets the title of the chart.
     * 
     * @return the title of the chart.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the chart.
     * 
     * @param title the title of the chart
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * Gets the id of the associated x-axis field.
     * 
     * @return the id of the associated x-axis field.
     */
    public String getxAxisFieldId() {
        return xAxisFieldId;
    }

    /**
     * Sets the id of the associated x-axis field.
     * 
     * @param xAxisFieldId the id of the associated x-axis fiel
     */
    public void setxAxisFieldId(String xAxisFieldId) {
        this.xAxisFieldId = xAxisFieldId;
    }

    /**
     * Gets the id of the associated y-axis field.
     * 
     * @return the id of the associated y-axis field
     */
    public String getyAxisFieldId() {
        return yAxisFieldId;
    }

    /**
     * Gets the id of the associated y-axis field.
     * 
     * @param the id of the associated y-axis field
     */
    public void setyAxisFieldId(String yAxisFieldId) {
        this.yAxisFieldId = yAxisFieldId;
    }

    /**
     * Gets the chart type of the chart.
     * 
     * @return the chart type of the chart.
     */
    public ChartType getChartType() {
        return chartType;
    }

    /**
     * Sets the chart type of the chart.
     * 
     * @param chartType the chart type of the chart
     */
    public void setChartType(ChartType chartType) {
        this.chartType = chartType;
    }

    /**
     * Gets the id of the associated game of the chart.
     * 
     * @return the id of the associated game.
     */
    public String getGameId() {
        return gameId;
    }

    /**
     * Sets the id of the associated game of the chart.
     * 
     * @param gameId the id of the associated game
     */
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
    
}
