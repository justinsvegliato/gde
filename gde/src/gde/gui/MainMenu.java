package gde.gui;

import gde.gui.tablemodels.CapturedDataTableModel;
import gde.gui.tablemodels.ChartTableModel;
import gde.gui.tablemodels.InstanceTableModel;
import gde.gui.tablemodels.SummaryTableModel;
import gde.gui.util.ChartTableCellRenderer;
import gde.gui.util.DatabaseHandler;
import gde.gui.util.ImageLoader;
import gde.gui.util.JFreeChartFactory;
import gde.models.Chart;
import gde.models.Game;
import gde.models.Instance;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

public class MainMenu extends javax.swing.JFrame {

    protected static final Jongo database = DatabaseHandler.getDatabase();
    private final Game game;

    public MainMenu(Game game, boolean isAdmin) {
        this.game = game;

        initComponents();
        setIconImage(ImageLoader.getAppIcon().getImage());
        refreshButton.setIcon(ImageLoader.getRefreshIcon());

        chartContainerPanel.setLayout(new java.awt.BorderLayout());
        chartContainerPanel.add(new ChartPanel(ChartFactory.createPieChart("", null, true, true, false)), BorderLayout.CENTER);

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

        SummaryTableModel summaryTableModel = new SummaryTableModel(game);
        summaryTable.setModel(summaryTableModel);

        updateSummaryLabels();

        adminMenu.setVisible(isAdmin);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        summaryContainerPanel = new javax.swing.JPanel();
        summaryPanel = new javax.swing.JPanel();
        summaryScrollPane = new javax.swing.JScrollPane();
        summaryTable = new javax.swing.JTable();
        fieldCountTitleLAbel = new javax.swing.JLabel();
        fieldCountLabel = new javax.swing.JLabel();
        instanceNumberCountLabel = new javax.swing.JLabel();
        instanceCountLabel = new javax.swing.JLabel();
        detailedAnalysisContainerPanel = new javax.swing.JPanel();
        detailedAnalysisPanel = new javax.swing.JScrollPane();
        capturedDataTable = new javax.swing.JTable();
        graphicalAnalysisContainerPanel = new javax.swing.JPanel();
        graphicalAnalysisPanel = new javax.swing.JPanel();
        chartScrollPane = new javax.swing.JScrollPane();
        chartTable = new javax.swing.JTable();
        createChartButton = new javax.swing.JButton();
        deleteChartButton = new javax.swing.JButton();
        editChartButton = new javax.swing.JButton();
        chartContainerPanel = new javax.swing.JPanel();
        instanceScrollPane = new javax.swing.JScrollPane();
        instanceTable = new javax.swing.JTable();
        selectCheckBox = new javax.swing.JCheckBox();
        refreshButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        refreshMenuButton = new javax.swing.JMenuItem();
        logoutMenuButton = new javax.swing.JMenuItem();
        adminMenu = new javax.swing.JMenu();
        configureMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game Diagnostics Engine");

        tabbedPane.setMinimumSize(new java.awt.Dimension(876, 615));

        summaryPanel.setPreferredSize(new java.awt.Dimension(800, 181));

        summaryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        summaryScrollPane.setViewportView(summaryTable);

        fieldCountTitleLAbel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        fieldCountTitleLAbel.setText("Number of Fields: ");

        fieldCountLabel.setText("0");

        instanceNumberCountLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        instanceNumberCountLabel.setText("Number of Instances:");

        instanceCountLabel.setText("0");

        javax.swing.GroupLayout summaryPanelLayout = new javax.swing.GroupLayout(summaryPanel);
        summaryPanel.setLayout(summaryPanelLayout);
        summaryPanelLayout.setHorizontalGroup(
            summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(summaryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(summaryScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
                    .addGroup(summaryPanelLayout.createSequentialGroup()
                        .addComponent(fieldCountTitleLAbel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldCountLabel)
                        .addGap(40, 40, 40)
                        .addComponent(instanceNumberCountLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(instanceCountLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        summaryPanelLayout.setVerticalGroup(
            summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, summaryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldCountTitleLAbel)
                    .addComponent(fieldCountLabel)
                    .addComponent(instanceNumberCountLabel)
                    .addComponent(instanceCountLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(summaryScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout summaryContainerPanelLayout = new javax.swing.GroupLayout(summaryContainerPanel);
        summaryContainerPanel.setLayout(summaryContainerPanelLayout);
        summaryContainerPanelLayout.setHorizontalGroup(
            summaryContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 956, Short.MAX_VALUE)
            .addGroup(summaryContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(summaryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE))
        );
        summaryContainerPanelLayout.setVerticalGroup(
            summaryContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 614, Short.MAX_VALUE)
            .addGroup(summaryContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(summaryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE))
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
                .addComponent(detailedAnalysisPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
                .addContainerGap())
        );
        detailedAnalysisContainerPanelLayout.setVerticalGroup(
            detailedAnalysisContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailedAnalysisContainerPanelLayout.createSequentialGroup()
                .addComponent(detailedAnalysisPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
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
        deleteChartButton.setEnabled(false);
        deleteChartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteChartButtonActionPerformed(evt);
            }
        });

        editChartButton.setText("Edit");
        editChartButton.setEnabled(false);
        editChartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editChartButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout chartContainerPanelLayout = new javax.swing.GroupLayout(chartContainerPanel);
        chartContainerPanel.setLayout(chartContainerPanelLayout);
        chartContainerPanelLayout.setHorizontalGroup(
            chartContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 719, Short.MAX_VALUE)
        );
        chartContainerPanelLayout.setVerticalGroup(
            chartContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 492, Short.MAX_VALUE)
                        .addComponent(createChartButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editChartButton)
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
                    .addComponent(editChartButton))
                .addGap(6, 6, 6))
            .addGroup(graphicalAnalysisPanelLayout.createSequentialGroup()
                .addComponent(chartScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout graphicalAnalysisContainerPanelLayout = new javax.swing.GroupLayout(graphicalAnalysisContainerPanel);
        graphicalAnalysisContainerPanel.setLayout(graphicalAnalysisContainerPanelLayout);
        graphicalAnalysisContainerPanelLayout.setHorizontalGroup(
            graphicalAnalysisContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(graphicalAnalysisPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE)
        );
        graphicalAnalysisContainerPanelLayout.setVerticalGroup(
            graphicalAnalysisContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(graphicalAnalysisPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
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

        refreshButton.setMaximumSize(new java.awt.Dimension(24, 24));
        refreshButton.setMinimumSize(new java.awt.Dimension(24, 24));
        refreshButton.setPreferredSize(new java.awt.Dimension(24, 24));
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        fileMenu.setText("File");

        refreshMenuButton.setText("Refresh");
        refreshMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshMenuButtonActionPerformed(evt);
            }
        });
        fileMenu.add(refreshMenuButton);

        logoutMenuButton.setText("Logout");
        logoutMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutMenuButtonActionPerformed(evt);
            }
        });
        fileMenu.add(logoutMenuButton);

        menuBar.add(fileMenu);

        adminMenu.setText("Admin");

        configureMenuItem.setText("Configure");
        configureMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configureMenuItemActionPerformed(evt);
            }
        });
        adminMenu.add(configureMenuItem);

        menuBar.add(adminMenu);

        helpMenu.setText("Help");

        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(instanceScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(instanceScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectCheckBox)
                    .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        if (instanceTable.getSelectedRowCount() != instanceTable.getRowCount()) {
            selectCheckBox.setSelected(false);
        }
    }//GEN-LAST:event_instanceTableMouseReleased

    private void editChartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editChartButtonActionPerformed
        new ManageChartDialog(game, chartTable, true).setVisible(true);
    }//GEN-LAST:event_editChartButtonActionPerformed

    private void deleteChartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteChartButtonActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this chart?", "Confirm Deletion",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            ((ChartTableModel) chartTable.getModel()).remove(chartTable.getSelectedRows());
        }
        deleteChartButton.setEnabled(false);
        editChartButton.setEnabled(false);
    }//GEN-LAST:event_deleteChartButtonActionPerformed

    private void createChartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createChartButtonActionPerformed
        new ManageChartDialog(game, chartTable, false).setVisible(true);
    }//GEN-LAST:event_createChartButtonActionPerformed

    private void chartTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chartTableMouseClicked
        if (evt.getClickCount() == 2) {
            new ManageChartDialog(game, chartTable, true).setVisible(true);
        }
        updateChart();
        editChartButton.setEnabled(chartTable.getSelectedRowCount() > 0);
        deleteChartButton.setEnabled(chartTable.getSelectedRowCount() > 0);
    }//GEN-LAST:event_chartTableMouseClicked

    private void instanceTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_instanceTableKeyReleased
        if (evt.getKeyCode() == 38 || evt.getKeyCode() == 40) {
            updateTabs();
            if (instanceTable.getSelectedRowCount() != instanceTable.getRowCount()) {
                selectCheckBox.setSelected(false);
            }
        }
    }//GEN-LAST:event_instanceTableKeyReleased

    private void chartTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chartTableKeyReleased
        if (evt.getKeyCode() == 38 || evt.getKeyCode() == 40) {
            updateChart();
        }
    }//GEN-LAST:event_chartTableKeyReleased

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        refreshInstancesTable();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void logoutMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutMenuButtonActionPerformed
        dispose();
        new LoginFrame().setVisible(true);
    }//GEN-LAST:event_logoutMenuButtonActionPerformed

    private void refreshMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshMenuButtonActionPerformed
        refreshInstancesTable();
    }//GEN-LAST:event_refreshMenuButtonActionPerformed

    public void refreshInstancesTable() {
        ((InstanceTableModel) instanceTable.getModel()).populate();
        updateTabs();
        selectCheckBox.setSelected(false);
    }

    private void configureMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configureMenuItemActionPerformed
        new ConfigurationDialog(game, chartTable, capturedDataTable, chartContainerPanel, editChartButton, deleteChartButton).setVisible(true);
        updateTabs();
        updateSummaryLabels();
    }//GEN-LAST:event_configureMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        new AboutDialog().setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void updateTabs() {
        updateTables();
        updateChart();
    }

    private void updateTables() {
        if (instanceTable.getSelectedRows().length >= 0) {
            InstanceTableModel instanceTableModel = ((InstanceTableModel) instanceTable.getModel());
            StringBuilder filter = new StringBuilder();
            int[] selectedRows = instanceTable.getSelectedRows();
            for (int i = 0; i < selectedRows.length; i++) {
                Instance instance = instanceTableModel.getEntryAt(selectedRows[i]);
                String divider = (i < selectedRows.length - 1) ? ", " : "";
                filter.append(String.format("'%s'%s", instance.getKey().toString(), divider));
            }
            String query = String.format("{instanceId: {$in: [%s]}}", filter.toString());

            CapturedDataTableModel capturedDataTableModel = ((CapturedDataTableModel) capturedDataTable.getModel());
            capturedDataTableModel.populate(query);

            SummaryTableModel summaryTableModel = ((SummaryTableModel) summaryTable.getModel());
            summaryTableModel.populate(instanceTableModel.getIds(), instanceTable.getSelectedRows());

            updateSummaryLabels();
        }
    }

    private void updateChart() {
        if (chartTable.getSelectedRow() != -1) {
            ChartTableModel chartTableModel = ((ChartTableModel) chartTable.getModel());
            Chart chart = chartTableModel.getEntryAt(chartTable.getSelectedRow());
            JFreeChart jFreeChart = JFreeChartFactory.INSTANCE.getChart(chart, instanceTable);
            chartContainerPanel.removeAll();
            chartContainerPanel.add(new ChartPanel(jFreeChart), BorderLayout.CENTER);
            chartContainerPanel.validate();
        }
    }

    private void updateSummaryLabels() {
        MongoCollection fieldCollection = database.getCollection("fields");
        MongoCollection instanceCollection = database.getCollection("instances");

        String gameQuery = String.format("{gameId: '%s'}", game.getKey().toString());
        long fieldCount = fieldCollection.count(gameQuery);
        long instanceCount = instanceCollection.count(gameQuery);

        fieldCountLabel.setText("" + fieldCount);
        instanceCountLabel.setText("" + instanceCount);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenu adminMenu;
    private javax.swing.JTable capturedDataTable;
    private javax.swing.JPanel chartContainerPanel;
    private javax.swing.JScrollPane chartScrollPane;
    private javax.swing.JTable chartTable;
    private javax.swing.JMenuItem configureMenuItem;
    private javax.swing.JButton createChartButton;
    private javax.swing.JButton deleteChartButton;
    private javax.swing.JPanel detailedAnalysisContainerPanel;
    private javax.swing.JScrollPane detailedAnalysisPanel;
    private javax.swing.JButton editChartButton;
    private javax.swing.JLabel fieldCountLabel;
    private javax.swing.JLabel fieldCountTitleLAbel;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JPanel graphicalAnalysisContainerPanel;
    private javax.swing.JPanel graphicalAnalysisPanel;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel instanceCountLabel;
    private javax.swing.JLabel instanceNumberCountLabel;
    private javax.swing.JScrollPane instanceScrollPane;
    private javax.swing.JTable instanceTable;
    private javax.swing.JMenuItem logoutMenuButton;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton refreshButton;
    private javax.swing.JMenuItem refreshMenuButton;
    private javax.swing.JCheckBox selectCheckBox;
    private javax.swing.JPanel summaryContainerPanel;
    private javax.swing.JPanel summaryPanel;
    private javax.swing.JScrollPane summaryScrollPane;
    private javax.swing.JTable summaryTable;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}