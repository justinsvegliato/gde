package gde.gui;

import gde.gui.tablemodels.CapturedDataTableModel;
import gde.gui.tablemodels.ChartTableModel;
import gde.gui.tablemodels.ChartTableCellRenderer;
import gde.gui.tablemodels.InstanceTableModel;
import gde.gui.tablemodels.TableModel;
import gde.gui.util.DatabaseHandler;
import gde.models.CapturedData;
import gde.models.Chart;
import gde.models.Chart.ChartType;
import gde.models.Field;
import gde.models.Game;
import gde.models.Instance;
import java.awt.BorderLayout;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import org.bson.types.ObjectId;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

public class MainMenu extends javax.swing.JFrame {

    protected static final Jongo database = DatabaseHandler.getDatabase();
    private final ImageIcon appIcon = new ImageIcon(getClass().getResource("gde_icon1.png"));
    private final Game game;
    private JFreeChart dataChart;

    public MainMenu(Game game) {
        this.game = game;
        initComponents();
        setIconImage(appIcon.getImage());

        dataChart = ChartFactory.createPieChart("", null, true, true, false);
        dataChart.setBackgroundPaint(getBackground());

        chartContainerPanel.setLayout(new java.awt.BorderLayout());
        chartContainerPanel.add(new ChartPanel(dataChart), BorderLayout.CENTER);
        chartContainerPanel.validate();

        InstanceTableModel instanceTableModel = new InstanceTableModel(game);
        instanceTable.setModel(instanceTableModel);
        instanceTableModel.populate();

        CapturedDataTableModel capturedDataTableModel = new CapturedDataTableModel(game);
        capturedDataTable.setModel(capturedDataTableModel);
        TableRowSorter<CapturedDataTableModel> sorter = new TableRowSorter<CapturedDataTableModel>((CapturedDataTableModel) capturedDataTable.getModel());
        capturedDataTable.setRowSorter(sorter);

        ChartTableModel chartTableModel = new ChartTableModel(game);
        chartTable.setModel(chartTableModel);
        chartTable.getColumnModel().getColumn(0).setCellRenderer(new ChartTableCellRenderer());
        chartTableModel.populate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        menuBar3 = new java.awt.MenuBar();
        menu5 = new java.awt.Menu();
        menu6 = new java.awt.Menu();
        menuBar4 = new java.awt.MenuBar();
        menu7 = new java.awt.Menu();
        menu8 = new java.awt.Menu();
        jPanel3 = new javax.swing.JPanel();
        tabbedPane = new javax.swing.JTabbedPane();
        summaryContainerPanel = new javax.swing.JPanel();
        summaryPanel = new javax.swing.JPanel();
        summaryScrollPane = new javax.swing.JScrollPane();
        summaryTable = new javax.swing.JTable();
        detailedAnalysisContainerPanel = new javax.swing.JPanel();
        detailedAnalysisPanel = new javax.swing.JScrollPane();
        capturedDataTable = new javax.swing.JTable();
        graphicalAnalysisContainerPanel = new javax.swing.JPanel();
        graphicalAnalysisPanel = new javax.swing.JPanel();
        chartScrollPane = new javax.swing.JScrollPane();
        chartTable = new javax.swing.JTable();
        createChartButton = new javax.swing.JButton();
        deleteChartButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        chartContainerPanel = new javax.swing.JPanel();
        instanceScrollPane = new javax.swing.JScrollPane();
        instanceTable = new javax.swing.JTable();
        selectCheckBox = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        menu5.setLabel("File");
        menuBar3.add(menu5);

        menu6.setLabel("Edit");
        menuBar3.add(menu6);

        menu7.setLabel("File");
        menuBar4.add(menu7);

        menu8.setLabel("Edit");
        menuBar4.add(menu8);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game Diagnostics Engine");

        tabbedPane.setMinimumSize(new java.awt.Dimension(876, 615));

        summaryPanel.setPreferredSize(new java.awt.Dimension(800, 181));

        summaryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Name", "--", "--", "--", "--"},
                {"Level", "34", "32.24", "3", "90"},
                {"Race", "Elf", null, null, null},
                {"Class", "Warrior", null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Field", "Mode", "Average", "Lowest", "Highest"
            }
        ));
        summaryScrollPane.setViewportView(summaryTable);

        javax.swing.GroupLayout summaryPanelLayout = new javax.swing.GroupLayout(summaryPanel);
        summaryPanel.setLayout(summaryPanelLayout);
        summaryPanelLayout.setHorizontalGroup(
            summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(summaryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(summaryScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
                .addContainerGap())
        );
        summaryPanelLayout.setVerticalGroup(
            summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, summaryPanelLayout.createSequentialGroup()
                .addComponent(summaryScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout summaryContainerPanelLayout = new javax.swing.GroupLayout(summaryContainerPanel);
        summaryContainerPanel.setLayout(summaryContainerPanelLayout);
        summaryContainerPanelLayout.setHorizontalGroup(
            summaryContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 879, Short.MAX_VALUE)
            .addGroup(summaryContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(summaryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE))
        );
        summaryContainerPanelLayout.setVerticalGroup(
            summaryContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
            .addGroup(summaryContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(summaryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Summary", summaryContainerPanel);

        capturedDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        detailedAnalysisPanel.setViewportView(capturedDataTable);

        javax.swing.GroupLayout detailedAnalysisContainerPanelLayout = new javax.swing.GroupLayout(detailedAnalysisContainerPanel);
        detailedAnalysisContainerPanel.setLayout(detailedAnalysisContainerPanelLayout);
        detailedAnalysisContainerPanelLayout.setHorizontalGroup(
            detailedAnalysisContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailedAnalysisContainerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(detailedAnalysisPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
                .addContainerGap())
        );
        detailedAnalysisContainerPanelLayout.setVerticalGroup(
            detailedAnalysisContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailedAnalysisContainerPanelLayout.createSequentialGroup()
                .addComponent(detailedAnalysisPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPane.addTab("Detailed Analysis", detailedAnalysisContainerPanel);

        graphicalAnalysisPanel.setPreferredSize(new java.awt.Dimension(800, 181));

        chartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        chartTable.setEditingRow(0);
        chartTable.setRowHeight(36);
        chartTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        chartTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chartTableMouseClicked(evt);
            }
        });
        chartTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                chartTableKeyReleased(evt);
            }
        });
        chartScrollPane.setViewportView(chartTable);

        createChartButton.setText("Create");
        createChartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createChartButtonActionPerformed(evt);
            }
        });

        deleteChartButton.setText("Delete");
        deleteChartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteChartButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout chartContainerPanelLayout = new javax.swing.GroupLayout(chartContainerPanel);
        chartContainerPanel.setLayout(chartContainerPanelLayout);
        chartContainerPanelLayout.setHorizontalGroup(
            chartContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 634, Short.MAX_VALUE)
        );
        chartContainerPanelLayout.setVerticalGroup(
            chartContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout graphicalAnalysisPanelLayout = new javax.swing.GroupLayout(graphicalAnalysisPanel);
        graphicalAnalysisPanel.setLayout(graphicalAnalysisPanelLayout);
        graphicalAnalysisPanelLayout.setHorizontalGroup(
            graphicalAnalysisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(graphicalAnalysisPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chartScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(graphicalAnalysisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(graphicalAnalysisPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(chartContainerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, graphicalAnalysisPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 471, Short.MAX_VALUE)
                        .addComponent(createChartButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteChartButton)))
                .addContainerGap())
        );
        graphicalAnalysisPanelLayout.setVerticalGroup(
            graphicalAnalysisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(graphicalAnalysisPanelLayout.createSequentialGroup()
                .addComponent(chartContainerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(graphicalAnalysisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteChartButton)
                    .addComponent(createChartButton)
                    .addComponent(editButton))
                .addGap(6, 6, 6))
            .addGroup(graphicalAnalysisPanelLayout.createSequentialGroup()
                .addComponent(chartScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout graphicalAnalysisContainerPanelLayout = new javax.swing.GroupLayout(graphicalAnalysisContainerPanel);
        graphicalAnalysisContainerPanel.setLayout(graphicalAnalysisContainerPanelLayout);
        graphicalAnalysisContainerPanelLayout.setHorizontalGroup(
            graphicalAnalysisContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(graphicalAnalysisPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
        );
        graphicalAnalysisContainerPanelLayout.setVerticalGroup(
            graphicalAnalysisContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(graphicalAnalysisPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Graphical Analysis", graphicalAnalysisContainerPanel);

        instanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        instanceTable.setAutoCreateRowSorter(true);
        instanceTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        instanceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                instanceTableMouseReleased(evt);
            }
        });
        instanceTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                instanceTableKeyReleased(evt);
            }
        });
        instanceScrollPane.setViewportView(instanceTable);

        selectCheckBox.setText("Select All/None");
        selectCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCheckBoxActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(selectCheckBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(instanceScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(instanceScrollPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectCheckBox)
                .addContainerGap())
            .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabbedPane.getAccessibleContext().setAccessibleName("tabbedPane");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void selectCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCheckBoxActionPerformed
        if (selectCheckBox.isSelected()) {
            instanceTable.selectAll();
        } else {
            instanceTable.clearSelection();
        }
        updateTabs();
    }//GEN-LAST:event_selectCheckBoxActionPerformed

    private void instanceTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instanceTableMouseReleased
        updateTabs();
    }//GEN-LAST:event_instanceTableMouseReleased

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        new ManageChartDialog(game, chartTable, true).setVisible(true);
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteChartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteChartButtonActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this chart?", "Confirm Deletion",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            ((ChartTableModel) chartTable.getModel()).remove(chartTable.getSelectedRows());
        }
    }//GEN-LAST:event_deleteChartButtonActionPerformed

    private void createChartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createChartButtonActionPerformed
        new ManageChartDialog(game, chartTable, false).setVisible(true);
    }//GEN-LAST:event_createChartButtonActionPerformed

    private void chartTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chartTableMouseClicked
        if (evt.getClickCount() == 2) {
            new ManageChartDialog(game, chartTable, true).setVisible(true);
        }
        if (evt.getClickCount() >= 1) {
            updateChart();
        }
    }//GEN-LAST:event_chartTableMouseClicked

    private void instanceTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_instanceTableKeyReleased
        updateTabs();
    }//GEN-LAST:event_instanceTableKeyReleased

    private void chartTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chartTableKeyReleased
        updateChart();
    }//GEN-LAST:event_chartTableKeyReleased

    private void updateTabs() {
        if (instanceTable.getSelectedRows().length >= 0) {
            InstanceTableModel instanceTableModel = ((InstanceTableModel) instanceTable.getModel());
            StringBuilder filter = new StringBuilder();
            int[] selectedRows = instanceTable.getSelectedRows();
            for (int i = 0; i < selectedRows.length; i++) {
                Instance instance = instanceTableModel.getEntryAt(selectedRows[i]);
                String divider = (i < selectedRows.length - 1) ? ", " : "";
                filter.append(String.format("'%s'%s", instance.getKey().toString(), divider));
            }

            CapturedDataTableModel capturedDataTableModel = ((CapturedDataTableModel) capturedDataTable.getModel());
            String query = String.format("{instanceId: {$in: [%s]}}", filter.toString());
            capturedDataTableModel.populate(query);

            if (chartTable.getSelectedRow() != -1) {
                updateChart();
            }
        }
    }

    private void updateChart() {
        int selectedRow = chartTable.getSelectedRow();
        ChartTableModel chartTableModel = ((ChartTableModel) chartTable.getModel());
        Chart chart = chartTableModel.getEntryAt(selectedRow);
        Chart.ChartType chartType = chart.getChartType();

        if (chartType == ChartType.PIE) {
            DefaultKeyedValues keyedValues = new DefaultKeyedValues();
            MongoCollection capturedDataCollection = database.getCollection("captureddata");
            MongoCollection fieldCollection = database.getCollection("fields");
            Field field = fieldCollection.findOne(new ObjectId(chart.getyAxisFieldId())).as(Field.class);
            for (int i : instanceTable.getSelectedRows()) {
                Instance instance = ((InstanceTableModel) instanceTable.getModel()).getEntryAt(i);
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

            DefaultPieDataset pieData = new DefaultPieDataset(keyedValues);

            dataChart = ChartFactory.createPieChart(
                    chart.getTitle(),
                    pieData,
                    true,
                    true,
                    false);

        } else if (chartType == ChartType.LINE) {
            MongoCollection capturedDataCollection = database.getCollection("captureddata");
            MongoCollection fieldCollection = database.getCollection("fields");
            Field field1 = fieldCollection.findOne(new ObjectId(chart.getyAxisFieldId())).as(Field.class);
            Field field2 = fieldCollection.findOne(new ObjectId(chart.getxAxisFieldId())).as(Field.class);
            XYSeriesCollection dataset = new XYSeriesCollection();
            for (int i : instanceTable.getSelectedRows()) {
                Instance instance = ((InstanceTableModel) instanceTable.getModel()).getEntryAt(i);
                String query = String.format("{instanceId: '%s'}", instance.getKey().toString());
                Iterable<CapturedData> capturedData = capturedDataCollection.find(query).as(CapturedData.class);
                XYSeries series = new XYSeries(instance.getIdentifier());
                for (CapturedData capturedDatum : capturedData) {
                    Integer stat1 = Integer.parseInt(capturedDatum.getData().get(field1.getName().toLowerCase()));
                    Integer stat2 = Integer.parseInt(capturedDatum.getData().get(field2.getName().toLowerCase()));
                    series.add(stat1, stat2);
                }
                dataset.addSeries(series);
            }

            dataChart = ChartFactory.createXYLineChart(
                    chart.getTitle(),
                    field2.getName(),
                    field1.getName(),
                    dataset,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false);
        }
        
        dataChart.setBackgroundPaint(getBackground());

        chartContainerPanel.removeAll();
        ChartPanel chartPanel = new ChartPanel(dataChart);
        chartContainerPanel.add(chartPanel, BorderLayout.CENTER);
        chartContainerPanel.validate();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable capturedDataTable;
    private javax.swing.JPanel chartContainerPanel;
    private javax.swing.JScrollPane chartScrollPane;
    private javax.swing.JTable chartTable;
    private javax.swing.JButton createChartButton;
    private javax.swing.JButton deleteChartButton;
    private javax.swing.JPanel detailedAnalysisContainerPanel;
    private javax.swing.JScrollPane detailedAnalysisPanel;
    private javax.swing.JButton editButton;
    private javax.swing.JPanel graphicalAnalysisContainerPanel;
    private javax.swing.JPanel graphicalAnalysisPanel;
    private javax.swing.JScrollPane instanceScrollPane;
    private javax.swing.JTable instanceTable;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel3;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.Menu menu5;
    private java.awt.Menu menu6;
    private java.awt.Menu menu7;
    private java.awt.Menu menu8;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    private java.awt.MenuBar menuBar3;
    private java.awt.MenuBar menuBar4;
    private javax.swing.JCheckBox selectCheckBox;
    private javax.swing.JPanel summaryContainerPanel;
    private javax.swing.JPanel summaryPanel;
    private javax.swing.JScrollPane summaryScrollPane;
    private javax.swing.JTable summaryTable;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}
