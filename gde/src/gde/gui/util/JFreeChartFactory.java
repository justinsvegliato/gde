package gde.gui.util;

import gde.gui.tablemodels.InstanceTableModel;
import gde.gui.util.DatabaseHandler;
import gde.models.CapturedData;
import gde.models.Chart;
import gde.models.Field;
import gde.models.Instance;
import java.awt.Color;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.Timer;
import org.bson.types.ObjectId;
import org.jfree.chart.JFreeChart;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.general.DefaultPieDataset;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.Rotation;
import org.jfree.util.ShapeUtilities;

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
            case SCATTER:
                return getJFreeScatterPlot(chart, selectedRows, instanceTableModel);
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
            CapturedData capturedData = capturedDataCollection.find(query).sort("{_id: -1}").limit(1).as(CapturedData.class).iterator().next();
            String stat = capturedData.getData().get(field.getName().toLowerCase());
            if (keyedValues.getKeys().contains(stat)) {
                keyedValues.addValue(stat, keyedValues.getValue(stat).intValue() + 1);
            } else {
                keyedValues.setValue(stat, 1);
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
