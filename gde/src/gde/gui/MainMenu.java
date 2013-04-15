package gde.gui;

import gde.gui.tablemodels.CapturedDataTableModel;
import gde.gui.tablemodels.ChartTableModel;
import gde.gui.tablemodels.ImageRenderer;
import gde.gui.tablemodels.InstanceTableModel;
import gde.gui.util.DatabaseHandler;

import gde.models.Chart;
import gde.models.Game;
import gde.models.Instance;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

public class MainMenu extends javax.swing.JFrame {

    protected static final Jongo database = DatabaseHandler.getDatabase();
    private final Game game;
    private JFreeChart dataChart;
    
    public MainMenu(Game game) {
        initComponents();
        this.game = game;
        
        dataChart = ChartFactory.createBarChart(
            "Bar Chart", // Title
            "x-axis", // x-axis Label
            "y-axis", // y-axis Label
            null, // Dataset
            PlotOrientation.VERTICAL, // Plot Orientation
            true, // Show Legend
            true, // Use tooltips
            false // Configure chart to generate URLs?
         );
        
        jPanel1.setLayout(new java.awt.BorderLayout());
        ChartPanel chartPanel = new ChartPanel(dataChart);
        jPanel1.add(chartPanel,BorderLayout.CENTER);
        jPanel1.validate();
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
        jPanel2 = new javax.swing.JPanel();
        summaryPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        instanceSummaryTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        instancesPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        instanceTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        retrieveButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        capturedDataTable = new javax.swing.JTable();
        selectCheckBox = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        manageChartPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        chartTable = new javax.swing.JTable();
        createChartButton = new javax.swing.JButton();
        deleteChartButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        viewChartsPanel = new javax.swing.JPanel();
        canvas1 = new java.awt.Canvas();
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

        tabbedPane.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabbedPaneFocusGained(evt);
            }
        });

        summaryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Overview"));
        summaryPanel.setPreferredSize(new java.awt.Dimension(800, 181));

        instanceSummaryTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(instanceSummaryTable);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Number of Instances: 14");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Number of Fields: 4");

        jLabel2.setText("Field Summaries:");

        javax.swing.GroupLayout summaryPanelLayout = new javax.swing.GroupLayout(summaryPanel);
        summaryPanel.setLayout(summaryPanelLayout);
        summaryPanelLayout.setHorizontalGroup(
            summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(summaryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 935, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, summaryPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)))
                .addContainerGap())
        );
        summaryPanelLayout.setVerticalGroup(
            summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(summaryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 967, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(summaryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 967, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(summaryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Summary", jPanel2);

        instancesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Instances"));

        instanceTable.setAutoCreateRowSorter(true);
        instanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        instanceTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane3.setViewportView(instanceTable);

        jLabel1.setText("Age (in months)");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(12, 1, 999, 1));

        retrieveButton.setText("Retrieve");
        retrieveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retrieveButtonActionPerformed(evt);
            }
        });

        capturedDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(capturedDataTable);

        selectCheckBox.setText("Select All/None");
        selectCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout instancesPanelLayout = new javax.swing.GroupLayout(instancesPanel);
        instancesPanel.setLayout(instancesPanelLayout);
        instancesPanelLayout.setHorizontalGroup(
            instancesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(instancesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5)
                .addGap(6, 6, 6))
            .addGroup(instancesPanelLayout.createSequentialGroup()
                .addComponent(selectCheckBox)
                .addGap(553, 553, 553)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(retrieveButton))
        );
        instancesPanelLayout.setVerticalGroup(
            instancesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(instancesPanelLayout.createSequentialGroup()
                .addGroup(instancesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(instancesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, instancesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(selectCheckBox))
                    .addComponent(retrieveButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabbedPane.addTab("Instances", instancesPanel);

        manageChartPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Charts"));
        manageChartPanel.setPreferredSize(new java.awt.Dimension(800, 181));

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
        jScrollPane4.setViewportView(chartTable);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 699, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout manageChartPanelLayout = new javax.swing.GroupLayout(manageChartPanel);
        manageChartPanel.setLayout(manageChartPanelLayout);
        manageChartPanelLayout.setHorizontalGroup(
            manageChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageChartPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createChartButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteChartButton))
            .addGroup(manageChartPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        manageChartPanelLayout.setVerticalGroup(
            manageChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageChartPanelLayout.createSequentialGroup()
                .addGroup(manageChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(manageChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteChartButton)
                    .addComponent(createChartButton)
                    .addComponent(editButton))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(manageChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 967, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(manageChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Manage Charts", jPanel4);

        javax.swing.GroupLayout viewChartsPanelLayout = new javax.swing.GroupLayout(viewChartsPanel);
        viewChartsPanel.setLayout(viewChartsPanelLayout);
        viewChartsPanelLayout.setHorizontalGroup(
            viewChartsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewChartsPanelLayout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(676, Short.MAX_VALUE))
        );
        viewChartsPanelLayout.setVerticalGroup(
            viewChartsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewChartsPanelLayout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(383, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Analyze", viewChartsPanel);

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
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        tabbedPane.getAccessibleContext().setAccessibleName("Summary");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void retrieveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retrieveButtonActionPerformed
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
    }//GEN-LAST:event_retrieveButtonActionPerformed

    private void tabbedPaneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabbedPaneFocusGained
        if (tabbedPane.getSelectedIndex() == 1 && capturedDataTable.getRowCount() == 0) {
            InstanceTableModel instanceTableModel = new InstanceTableModel(game);
            instanceTable.setModel(instanceTableModel);
            instanceTableModel.populate();

            CapturedDataTableModel capturedDataTableModel = new CapturedDataTableModel(game);
            capturedDataTable.setModel(capturedDataTableModel);
        } else if (tabbedPane.getSelectedIndex() == 2 && chartTable.getRowCount() == 0) {
            ChartTableModel chartTableModel = new ChartTableModel(game);
            chartTable.setModel(chartTableModel);
            chartTableModel.populate();
            chartTable.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
        }
    }//GEN-LAST:event_tabbedPaneFocusGained

    private void selectCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCheckBoxActionPerformed
        if (selectCheckBox.isSelected()) {
            instanceTable.selectAll();
        } else {
            instanceTable.clearSelection();
        }
    }//GEN-LAST:event_selectCheckBoxActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        new ManageChartDialog(game, chartTable, true).setVisible(true);
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteChartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteChartButtonActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete your selection?", "Confirm Deletion",
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
        else if (evt.getClickCount() == 1) {
            int selectedRow = (chartTable.getSelectedRows())[0];
            ChartTableModel chartTableModel = ((ChartTableModel) instanceTable.getModel());
            Chart chart = chartTableModel.getEntryAt(selectedRow);
            
            dataChart.setTitle(chart.getTitle());
        }
    }//GEN-LAST:event_chartTableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    private javax.swing.JTable capturedDataTable;
    private javax.swing.JTable chartTable;
    private javax.swing.JButton createChartButton;
    private javax.swing.JButton deleteChartButton;
    private javax.swing.JButton editButton;
    private javax.swing.JTable instanceSummaryTable;
    private javax.swing.JTable instanceTable;
    private javax.swing.JPanel instancesPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JPanel manageChartPanel;
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
    private javax.swing.JButton retrieveButton;
    private javax.swing.JCheckBox selectCheckBox;
    private javax.swing.JPanel summaryPanel;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JPanel viewChartsPanel;
    // End of variables declaration//GEN-END:variables
}
