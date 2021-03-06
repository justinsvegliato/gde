package gde.gui;

import gde.gui.tablemodels.CapturedDataTableModel;
import gde.gui.tablemodels.ChartTableModel;
import gde.gui.tablemodels.FieldTableModel;
import gde.gui.util.DatabaseHandler;
import gde.gui.util.ImageLoader;
import gde.models.Chart;
import gde.models.Field;
import gde.models.Field.FieldType;
import gde.models.Game;
import gde.models.Instance;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jongo.MongoCollection;

/**
 * The ManageFieldDialog provides field management functionality.
 * 
 * @author Justin Svegliato and Andrew Evans
 */
public class ManageFieldDialog extends javax.swing.JDialog {

    /** the game associated with this instance of gde */
    private final Game game;
    
    /** the field table from the main menu */
    private final boolean editMode;
    
    /** the chart table from the main menu */
    private final JTable fieldTable;
    
    /** the captured data table from the main menu */
    private final JTable chartTable;
    
    /** the chart container panel from the main menu */
    private final JTable capturedDataTable;
    
    /** true if this dialog will be in field edit mode */
    private final JPanel chartContainerPanel;

    /**
     * Creates a newly-instantiated ManageFieldDialog object.
     * 
     * @param game the game associated with this instance of gde
     * @param fieldTable the field table from the main menu
     * @param chartTable the chart table from the main menu
     * @param capturedDataTable the captured data table from the main menu
     * @param chartContainerPanel the chart container panel from the main menu
     * @param editMode true if this dialog will be in field edit mode
     */
    public ManageFieldDialog(Game game, JTable fieldTable, JTable chartTable, JTable capturedDataTable, JPanel chartContainerPanel, boolean editMode) {
        initComponents();
        setIconImage(ImageLoader.getAppIcon().getImage());
        getRootPane().setDefaultButton(saveButton);
        setLocationRelativeTo(null);

        this.game = game;
        this.fieldTable = fieldTable;
        this.editMode = editMode;
        this.chartTable = chartTable;
        this.capturedDataTable = capturedDataTable;
        this.chartContainerPanel = chartContainerPanel;

        // Populates all of the fields in the combo box
        for (FieldType type : Field.FieldType.values()) {
            typeComboBox.addItem(type);
        }

        fillSelections(editMode);
        saveButton.setEnabled(editMode);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox();
        typeLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        nameTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);

        titleLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        titleLabel.setText("New Field");

        nameLabel.setText("Name");

        typeLabel.setText("Type");

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

        nameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameTextFieldKeyReleased(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(saveButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cancelButton))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(titleLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 338, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(nameLabel)
                                .add(typeLabel))
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                .add(typeComboBox, 0, 222, Short.MAX_VALUE)
                                .add(nameTextField)))))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(4, 4, 4)
                .add(titleLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(nameLabel)
                    .add(nameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(19, 19, 19)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(typeComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(typeLabel))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cancelButton)
                    .add(saveButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Fills the selections in the form based on the selected field, if edit mode is enabled.
     * 
     * @param editMode whether or not the window is open in edit mode
     */
    private void fillSelections(boolean editMode) {
        if (editMode) {
            FieldTableModel fieldTableModel = ((FieldTableModel) fieldTable.getModel());
            Field field = fieldTableModel.getEntryAt(fieldTable.getSelectedRow());
            titleLabel.setText("Edit Field");
            nameTextField.setText(field.getName());
            typeComboBox.setSelectedItem(field.getType());
        }
    }

    /**
     * Creates or changes the selected field after the "save" button is clicked and the
     * user confirms that they want to take this action.
     * 
     * @param evt the swing ActionEvent trigger
     */
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        String message = String.format("Are you sure to %s this field? Doing so will erase all existing player data for this game.",
                                        editMode ? "edit" : "create");
        int response = JOptionPane.showConfirmDialog(this, message, "Confirm Cancellation",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            dispose();

            // Empties the database because of field merging conflicts (will fix this later)
            MongoCollection instanceCollection = DatabaseHandler.getDatabase().getCollection("instances");
            String gameQuery = String.format("{gameId: '%s'}", game.getKey().toString());
            Iterable<Instance> instances = instanceCollection.find(gameQuery).as(Instance.class);
            MongoCollection capturedDataCollection = DatabaseHandler.getDatabase().getCollection("captureddata");
            for (Instance instance : instances) {
                String instanceQuery = String.format("{instanceId: '%s'}", instance.getKey().toString());
                capturedDataCollection.remove(instanceQuery);
            }
            ((CapturedDataTableModel) capturedDataTable.getModel()).populate(); 
            
            Field newField = new Field(
                    nameTextField.getText(),
                    (FieldType) typeComboBox.getSelectedItem(),
                    game.getKey().toString());

            // Handles the dialog differently depending on whether it is in edit mode
            FieldTableModel fieldTableModel = ((FieldTableModel) fieldTable.getModel());
            if (editMode) {      
                // Updates the field according to the user's selection
                Field editedField = ((FieldTableModel) fieldTable.getModel()).getEntryAt(fieldTable.getSelectedRow());
                String editedFieldKey = editedField.getKey().toString();
                fieldTableModel.update(newField, fieldTable.getSelectedRow());               
                
                // Removes any charts that use this field
                MongoCollection chartCollection = DatabaseHandler.getDatabase().getCollection("charts");
                String chartQuery = String.format("{$or: [{xAxisFieldId: '%s'}, {yAxisFieldId: '%s'}]}", editedFieldKey, editedFieldKey);
                Iterable<Chart> charts = chartCollection.find(chartQuery).as(Chart.class);
                ChartTableModel chartTableModel = (ChartTableModel) chartTable.getModel();
                for (Chart chart : charts) {
                    chartTableModel.remove(new int[]{chartTableModel.getIds().indexOf(chart.getKey())});
                }
                
                // Updates the chart table if none are selected
                if (chartTable.getSelectedRow() == -1) {
                    chartContainerPanel.removeAll();
                    chartContainerPanel.add(new ChartPanel(ChartFactory.createPieChart("", null, true, true, false)), BorderLayout.CENTER);
                    chartContainerPanel.validate();
                }               
            } else {
                fieldTableModel.add(newField);
            } 
                                               
            capturedDataTable.setModel(new CapturedDataTableModel(game));
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    /**
     * Disposes the current window after the "cancel" button is clicked and the
     * user confirms the action.
     * 
     * @param evt the swing ActionEvent trigger
     */
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        if (editMode) {
            int response = JOptionPane.showConfirmDialog(this, "Are you sure you want cancel your changes?", "Confirm Cancellation",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Enables the save button when there is text in the field.
     * 
     * @param evt the swing ActionEvent trigger
     */
    private void nameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTextFieldKeyReleased
        saveButton.setEnabled(!nameTextField.getText().trim().isEmpty());
    }//GEN-LAST:event_nameTextFieldKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JComboBox typeComboBox;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
}
