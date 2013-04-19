package gde.gui.util;

public class FieldSummary {
    private final String field;
    private final String mode;
    private final double average;
    private final double maximum;
    private final double minimum;

    public FieldSummary(String field, double average, String mode, double minimum, double maximum) {
        this.field = field;
        this.average = average;
        this.mode = mode;
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public String getField() {
        return field;
    }

    public String getMode() {
        return mode;
    }

    public double getAverage() {
        return average;
    }

    public double getMaximum() {
        return maximum;
    }

    public double getMinimum() {
        return minimum;
    }
    
    
}
