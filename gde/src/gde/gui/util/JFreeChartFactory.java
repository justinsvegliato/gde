package gde.gui.util;

import gde.gui.tablemodels.InstanceTableModel;
import gde.gui.util.DatabaseHandler;
import gde.models.CapturedData;
import gde.models.Chart;
import gde.models.Field;
import gde.models.Instance;
import javax.swing.JTable;
import org.bson.types.ObjectId;
import org.jfree.chart.JFreeChart;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.general.DefaultPieDataset;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public enum JFreeChartFactory {

    INSTANCE;
    
    protected static final Jongo database = DatabaseHandler.getDatabase();
    private static final MongoCollection capturedDataCollection = database.getCollection("captureddata");
    private static final MongoCollection fieldCollection = database.getCollection("fields");

    public JFreeChart getChart(Chart chart, JTable instanceTable) {
        int[] selectedRows = instanceTable.getSelectedRows();
        InstanceTableModel instanceTableModel = (InstanceTableModel) instanceTable.getModel();
        switch (chart.getChartType()) {
            case PIE:
                return getJFreePieChart(chart, selectedRows, instanceTableModel);
            case LINE:
                return getJFreeLineChart(chart, selectedRows, instanceTableModel); 
            default:
                return ChartFactory.createLineChart(
                        null,
                        null,
                        null,
                        null,
                        PlotOrientation.HORIZONTAL,
                        true,
                        true,
                        true);
        }
    }

    private JFreeChart getJFreePieChart(Chart chart, int[] selectedRows, InstanceTableModel model) {
        Field field = fieldCollection.findOne(new ObjectId(chart.getyAxisFieldId())).as(Field.class);
        DefaultKeyedValues keyedValues = new DefaultKeyedValues();
        for (int i : selectedRows) {
            Instance instance = model.getEntryAt(i);
            String query = String.format("{instanceId: '%s'}", instance.getKey().toString());
            Iterable<CapturedData> capturedData = capturedDataCollection.find(query).as(CapturedData.class);
            for (CapturedData capturedDatum : capturedData) {
                String stat = capturedDatum.getData().get(field.getName().toLowerCase());
                if (keyedValues.getKeys().contains(stat)) {
                    keyedValues.addValue(stat, keyedValues.getValue(stat).intValue() + 1);
                } else {
                    keyedValues.setValue(stat, 1);
                }
            }
        }

        return ChartFactory.createPieChart(
                chart.getTitle(),
                new DefaultPieDataset(keyedValues),
                false,
                true,
                true);

    }

    private JFreeChart getJFreeLineChart(Chart chart, int[] selectedRows, InstanceTableModel model) {
        Field xAxisField = fieldCollection.findOne(new ObjectId(chart.getxAxisFieldId())).as(Field.class);
        Field yAxisField = fieldCollection.findOne(new ObjectId(chart.getyAxisFieldId())).as(Field.class);
        XYSeriesCollection dataset = new XYSeriesCollection();
        for (int i : selectedRows) {
            Instance instance = model.getEntryAt(i);
            String query = String.format("{instanceId: '%s'}", instance.getKey().toString());
            Iterable<CapturedData> capturedData = capturedDataCollection.find(query).as(CapturedData.class);
            XYSeries series = new XYSeries(instance.getIdentifier());
            for (CapturedData capturedDatum : capturedData) {
                Integer x = Integer.parseInt(capturedDatum.getData().get(xAxisField.getName().toLowerCase()));
                Integer y = Integer.parseInt(capturedDatum.getData().get(yAxisField.getName().toLowerCase()));
                series.add(x, y);
            }
            dataset.addSeries(series);
        }

        return ChartFactory.createXYLineChart(
                chart.getTitle(),
                xAxisField.getName(),
                yAxisField.getName(),
                dataset,
                PlotOrientation.VERTICAL,
                false,
                false,
                false);
    }
}
