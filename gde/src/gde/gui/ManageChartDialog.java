package gde.gui;

import gde.gui.tablemodels.ChartTableModel;
import gde.gui.util.DatabaseHandler;
import gde.gui.util.ImageLoader;
import gde.models.Chart;
import gde.models.Chart.ChartType;
import static gde.models.Chart.ChartType.LINE;
import gde.models.Field;
import gde.models.Field.FieldType;
import gde.models.Game;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.bson.types.ObjectId;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

public class ManageChartDialog extends javax.swing.JDialog {

    private static final Jongo database = DatabaseHandler.getDatabase();
    private final Game game;
    private final JTable chartTable;
    private final boolean editMode;
    
    public ManageChartDialog(Game game, JTable chartTable, boolean editMode) {
        initComponents();
        setIconImage(ImageLoader.getAppIcon().getImage());

        this.game = game;
        this.chartTable = chartTable;
        this.editMode = editMode;

        populateFieldComboBoxes(null);
        populateChartComboBox();
        fillSelections(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        yAxisLabel = new javax.swing.JLabel();
        yAxisComboBox = new javax.swing.JComboBox();
        xAxisComboBox = new javax.swing.JComboBox();
        chartTypeComboBox = new javax.swing.JComboBox();
        chartTypeLabel = new javax.swing.JLabel();
        xAxisLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);

        yAxisLabel.setText("Vertical Axis");

        chartTypeComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chartTypeComboBoxInputStateChanged(evt);
            }
        });

        chartTypeLabel.setText("Chart Type");

        xAxisLabel.setText("Horizontal Axis");

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        titleLabel.setText("New Chart");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(chartTypeLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(chartTypeComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 222, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(titleLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 338, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(yAxisLabel)
                                .add(xAxisLabel))
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(xAxisComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 222, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, yAxisComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 222, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(saveButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cancelButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(4, 4, 4)
                .add(titleLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(chartTypeComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(chartTypeLabel))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(yAxisComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(yAxisLabel))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(xAxisComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(xAxisLabel))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(saveButton)
                    .add(cancelButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void chartTypeComboBoxInputStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chartTypeComboBoxInputStateChanged
        ChartType chartType = (ChartType) chartTypeComboBox.getSelectedItem();
        populateFieldComboBoxes(chartType);
        xAxisComboBox.setEnabled(chartType != ChartType.PIE);
        fillSelections(false);
    }//GEN-LAST:event_chartTypeComboBoxInputStateChanged

    private String getChoiceFilter(ChartType chartType) {
        String template = ", type: {$in:[%s]}";
        String filter;
        switch (chartType) {
            case PIE:
            case BAR:
                filter = "'" + FieldType.TEXT.name() + "'";
                return String.format(template, filter);
            case LINE:
            case SCATTER:
            case MAP:
                filter = String.format("'%s', '%s'", FieldType.INTEGER.name(), FieldType.DECIMAL.name());
                return String.format(template, filter);
        }
        return "";
    }

    private void fillSelections(boolean changeChart) {
        if (editMode) {
            MongoCollection fieldsCollection = database.getCollection("fields");
            ChartTableModel chartTableModel = ((ChartTableModel) chartTable.getModel());
            Chart chart = chartTableModel.getEntryAt(chartTable.getSelectedRow());
            Field xAxisField = fieldsCollection.findOne(new ObjectId(chart.getxAxisFieldId())).as(Field.class);
            Field yAxisField = fieldsCollection.findOne(new ObjectId(chart.getyAxisFieldId())).as(Field.class);
            // TODO
            titleLabel.setText("Edit Chart");
            yAxisComboBox.setSelectedItem(yAxisField);
            xAxisComboBox.setSelectedItem(xAxisField);
            if (changeChart) {
                chartTypeComboBox.setSelectedItem(chart.getChartType());
            }
        }
    }
    
    private void populateFieldComboBoxes(ChartType chartType) {
        MongoCollection fieldsCollection = database.getCollection("fields");
        String query = String.format("{gameId: '%s'%s}", game.getKey().toString(), chartType == null ? "" : getChoiceFilter(chartType));
        Iterable<Field> fields = fieldsCollection.find(query).as(Field.class);
        yAxisComboBox.removeAllItems();
        xAxisComboBox.removeAllItems();
        for (Field field : fields) {
            yAxisComboBox.addItem(field);
            xAxisComboBox.addItem(field);
        }
    }
    
    private void populateChartComboBox() {
        for (ChartType fieldType : Chart.ChartType.values()) {
            chartTypeComboBox.addItem(fieldType);
        }
    }

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        this.setVisible(false);

        Field verticalAxis = ((Field) yAxisComboBox.getSelectedItem());
        Field horizontalAxis = ((Field) xAxisComboBox.getSelectedItem());
        ChartType chartType = (ChartType) chartTypeComboBox.getSelectedItem();

        Chart newChart = new Chart(
                String.format("%s%s", verticalAxis.getName(), (chartType != Chart.ChartType.PIE ? " vs. " + horizontalAxis.getName() : " Distribution")),
                horizontalAxis.getKey().toString(),
                verticalAxis.getKey().toString(),
                (ChartType) chartTypeComboBox.getSelectedItem(),
                game.getKey().toString());

        ChartTableModel chartTableModel = ((ChartTableModel) chartTable.getModel());
        if (editMode) {
            chartTableModel.update(newChart, chartTable.getSelectedRow());
        } else {
            chartTableModel.add(newChart);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        if (editMode) {
            int response = JOptionPane.showConfirmDialog(null, "Are you sure you want cancel your changes?", "Confirm Cancellation",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                this.setVisible(false);
            }
        } else {
            this.setVisible(false);
        }
    }//GEN-LAST:event_cancelButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox chartTypeComboBox;
    private javax.swing.JLabel chartTypeLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JComboBox xAxisComboBox;
    private javax.swing.JLabel xAxisLabel;
    private javax.swing.JComboBox yAxisComboBox;
    private javax.swing.JLabel yAxisLabel;
    // End of variables declaration//GEN-END:variables
}
