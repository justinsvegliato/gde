package gde.gui.util;

import gde.gui.tablemodels.InstanceTableModel;
import gde.models.CapturedData;
import gde.models.Chart;
import gde.models.Field;
import gde.models.Instance;
import java.awt.Shape;
import javax.swing.JTable;
import org.bson.types.ObjectId;
import org.jfree.chart.JFreeChart;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.general.DefaultPieDataset;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.Rotation;
import org.jfree.util.ShapeUtilities;


/**
 * The JFreeChartFactory is a singleton object that produces a graph depending 
 * on the Chart and JTable received.
 * 
 * @author Justin Svelgiato and Martin Mena
 */
public enum JFreeChartFactory {

    /** the singleton */
    INSTANCE;
    
    /** the Jongo object used to easily interact with the database */
    protected static final Jongo database = DatabaseHandler.getDatabase();
    
    /** the captureddata collection */
    private static final MongoCollection capturedDataCollection = database.getCollection("captureddata");
    
    /** the field collection */
    private static final MongoCollection fieldCollection = database.getCollection("fields");

    /**
     * Gets a chart depending on the chart type.
     * 
     * @param chart the chart data in question which dictates what chart will be produced
     * @param instanceTable the table containing all of the instances
     * @return a new chart which is contingent upon the chart type.
     */
    public JFreeChart getChart(Chart chart, JTable instanceTable) {
        int[] selectedRows = instanceTable.getSelectedRows();
        InstanceTableModel instanceTableModel = (InstanceTableModel) instanceTable.getModel();
        switch (chart.getChartType()) {
            case PIE:
                return getJFreePieChart(chart, selectedRows, instanceTableModel);
            case LINE:
                return getJFreeLineChart(chart, selectedRows, instanceTableModel);
            case SCATTER:
                return getJFreeScatterPlot(chart, selectedRows, instanceTableModel);
            case MAP:
                return getJFreePositionMap(chart, selectedRows, instanceTableModel);
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

    /**
     * 
     * 
     * @param chart
     * @param selectedRows
     * @param model
     * @return 
     */
    private JFreeChart getJFreePieChart(Chart chart, int[] selectedRows, InstanceTableModel model) {
        Field field = fieldCollection.findOne(new ObjectId(chart.getyAxisFieldId())).as(Field.class);
        DefaultKeyedValues keyedValues = new DefaultKeyedValues();
        for (int i : selectedRows) {
            Instance instance = model.getEntryAt(i);
            String query = String.format("{instanceId: '%s'}", instance.getKey().toString());
            if (capturedDataCollection.count(query) > 0) {
                CapturedData capturedData = capturedDataCollection.find(query).sort("{_id: -1}").limit(1).as(CapturedData.class).iterator().next();
                String stat = capturedData.getData().get(field.getName().toLowerCase());
                if (keyedValues.getKeys().contains(stat)) {
                    keyedValues.addValue(stat, keyedValues.getValue(stat).intValue() + 1);
                } else {
                    keyedValues.setValue(stat, 1);
                }
            }
        }


        JFreeChart jFreeChart = ChartFactory.createPieChart3D(
                chart.getTitle(),
                new DefaultPieDataset(keyedValues),
                true,
                true,
                true);

        PiePlot3D plot = (PiePlot3D) jFreeChart.getPlot();
        plot.setStartAngle(320);
        plot.setDirection(Rotation.ANTICLOCKWISE);
        plot.setForegroundAlpha(0.40f);

        return jFreeChart;
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
    
    private JFreeChart getJFreeScatterPlot(Chart chart, int[] selectedRows, InstanceTableModel model) {
        Field xAxisField = fieldCollection.findOne(new ObjectId(chart.getxAxisFieldId())).as(Field.class);
        Field yAxisField = fieldCollection.findOne(new ObjectId(chart.getyAxisFieldId())).as(Field.class);
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("All");
        for (int i : selectedRows) {
            Instance instance = model.getEntryAt(i);
            String query = String.format("{instanceId: '%s'}", instance.getKey().toString());
            CapturedData capturedData = capturedDataCollection.find(query).sort("{_id: -1}").limit(1).as(CapturedData.class).iterator().next();
            Integer x = Integer.parseInt(capturedData.getData().get(xAxisField.getName().toLowerCase()));
            Integer y = Integer.parseInt(capturedData.getData().get(yAxisField.getName().toLowerCase()));
            series.add(x, y);
        }
        dataset.addSeries(series);
        
        JFreeChart jFreeChart = ChartFactory.createScatterPlot(
                chart.getTitle(),
                xAxisField.getName(),
                yAxisField.getName(),
                dataset,
                PlotOrientation.VERTICAL,
                false,
                false,
                false);
        
        XYPlot plot = (XYPlot) jFreeChart.getPlot();
        XYItemRenderer renderer = plot.getRenderer();
        Shape shape = ShapeUtilities.createDiamond(4);
        renderer.setSeriesShape(0, shape);

        return jFreeChart;
    }
    
    private JFreeChart getJFreePositionMap(Chart chart, int[] selectedRows, InstanceTableModel model) {
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
        
        JFreeChart jFreeChart = ChartFactory.createScatterPlot(
                chart.getTitle(),
                xAxisField.getName(),
                yAxisField.getName(),
                dataset,
                PlotOrientation.VERTICAL,
                false,
                false,
                false);
        
        XYPlot plot = (XYPlot) jFreeChart.getPlot();
        XYItemRenderer renderer = plot.getRenderer();
        Shape shape = ShapeUtilities.createDiamond(4);
        renderer.setSeriesShape(0, shape);
        
        NumberAxis domain = (NumberAxis) plot.getDomainAxis();
        domain.setRange(0.00, 10000);
        domain.setTickUnit(new NumberTickUnit(1000));
        domain.setVerticalTickLabels(true);
        NumberAxis range = (NumberAxis) plot.getRangeAxis();
        range.setRange(0.0, 8000);
        range.setTickUnit(new NumberTickUnit(1000));

        return jFreeChart;
    }


//    private JFreeChart getJFreeBarGraph(Chart chart, int[] selectedRows, InstanceTableModel model) {
//        Field field = fieldCollection.findOne(new ObjectId(chart.getyAxisFieldId())).as(Field.class);
//        DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
//        for (int i : selectedRows) {
//            Instance instance = model.getEntryAt(i);
//            String query = String.format("{instanceId: '%s'}", instance.getKey().toString());
//            Iterable<CapturedData> capturedData = capturedDataCollection.find(query).as(CapturedData.class);
//            for (CapturedData capturedDatum : capturedData) {
//                String stat = capturedDatum.getData().get(field.getName().toLowerCase());
//                if (categoryDataset.getColumnKeys().contains(stat) && categoryDataset.getRowKeys().contains(field.getName())) {
//                    categoryDataset.addValue(categoryDataset.getValue(stat, field.getName()).intValue() + 1, stat, field.getName());
//                } else {
//                    categoryDataset.setValue(1, stat, field.getName());
//                }
//            }
//        }
//
//
////        JFreeChart jFreeChart = ChartFactory.createPieChart3D(
////                chart.getTitle(),
////                new DefaultPieDataset(keyedValues),
////                true,
////                true,
////                true);
//
//        JFreeChart jFreeChart = ChartFactory.createBarChart3D("Program Enrollment (c) www.sanjaal.com",
//                "Year",
//                "Number of Students",
//                categoryDataset,
//                PlotOrientation.VERTICAL,
//                true,
//                true,
//                false);
//
//        return jFreeChart;
//    }
}
