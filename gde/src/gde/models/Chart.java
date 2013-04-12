package gde.models;

public class Chart extends Entry {

    public enum ChartType {
        LINE,
        PIE;
        
        @Override
        public String toString() {
            return name().substring(0, 1).toUpperCase() + name().substring(1).toLowerCase(); 
        }
    }
    
    private String title;
    private String xAxisFieldId;
    private String yAxisFieldId;
    private ChartType chartType;
    private String gameId;
    
    public Chart() {
    }

    public Chart(String title, String xAxisFieldId, String yAxisFieldId, ChartType chartType, String gameId) {
        this.title = title;
        this.xAxisFieldId = xAxisFieldId;
        this.yAxisFieldId = yAxisFieldId;
        this.chartType = chartType;
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getxAxisFieldId() {
        return xAxisFieldId;
    }

    public void setxAxisFieldId(String xAxisFieldId) {
        this.xAxisFieldId = xAxisFieldId;
    }

    public String getyAxisFieldId() {
        return yAxisFieldId;
    }

    public void setyAxisFieldId(String yAxisFieldId) {
        this.yAxisFieldId = yAxisFieldId;
    }

    public ChartType getChartType() {
        return chartType;
    }

    public void setChartType(ChartType chartType) {
        this.chartType = chartType;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
    
}
