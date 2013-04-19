package gde.gui.util;

public class FieldSummary {
    private final String field;
    private final String mode;
    private final double average;
    private final double maximum;
    private final double minimum;

    public FieldSummary(String field, String mode, double average, double maximum, double minimum) {
        this.field = field;
        this.mode = mode;
        this.average = average;
        this.maximum = maximum;
        this.minimum = minimum;
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
