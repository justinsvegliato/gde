package gde.gui;

import gde.gui.tablemodels.DeveloperTableModel;
import gde.gui.tablemodels.FieldTableModel;
import gde.gui.util.DatabaseHandler;
import gde.models.Developer;
import gde.models.Developer.AccountType;
import gde.models.Game;
import gde.models.Instance;
import java.util.List;
import javax.swing.JOptionPane;
import org.jongo.MongoCollection;

public class ConfigurationDialog extends javax.swing.JDialog {

    private final Game game;

    public ConfigurationDialog(Game game) {
        initComponents();

        this.game = game;

        FieldTableModel fieldTableModel = new FieldTableModel(game);
        fieldTable.setModel(fieldTableModel);
        fieldTableModel.populate();

        DeveloperTableModel developerTableModel = new DeveloperTableModel(game);
        developerTable.setModel(developerTableModel);
        developerTableModel.populate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        administrationTabbedPanel = new javax.swing.JTabbedPane();
        fieldPanel = new javax.swing.JPanel();
        administrationScrollPane = new javax.swing.JScrollPane();
        fieldTable = new javax.swing.JTable();
        editFieldButton = new javax.swing.JButton();
        createFieldButton = new javax.swing.JButton();
        deleteFieldButton = new javax.swing.JButton();
        developerPanel = new javax.swing.JPanel();
        developerTableScrollPane = new javax.swing.JScrollPane();
        developerTable = new javax.swing.JTable();
        addDeveloperButton = new javax.swing.JButton();
        removeDeveloperButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);

        fieldTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        fieldTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        fieldTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldTableMouseClicked(evt);
            }
        });
        administrationScrollPane.setViewportView(fieldTable);

        editFieldButton.setText("Edit");
        editFieldButton.setEnabled(false);
        editFieldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editFieldButtonActionPerformed(evt);
            }
        });

        createFieldButton.setText("Create");
        createFieldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createFieldButtonActionPerformed(evt);
            }
        });

        deleteFieldButton.setText("Delete");
        deleteFieldButton.setEnabled(false);
        deleteFieldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteFieldButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout fieldPanelLayout = new org.jdesktop.layout.GroupLayout(fieldPanel);
        fieldPanel.setLayout(fieldPanelLayout);
        fieldPanelLayout.setHorizontalGroup(
            fieldPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(fieldPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(fieldPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(administrationScrollPane)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, fieldPanelLayout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(createFieldButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(editFieldButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(deleteFieldButton)))
                .addContainerGap())
        );
        fieldPanelLayout.setVerticalGroup(
            fieldPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(fieldPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(administrationScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(fieldPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(editFieldButton)
                    .add(deleteFieldButton)
                    .add(createFieldButton))
                .addContainerGap())
        );

        administrationTabbedPanel.addTab("Fields", fieldPanel);

        developerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        developerTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        developerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                developerTableMouseClicked(evt);
            }
        });
        developerTableScrollPane.setViewportView(developerTable);

        addDeveloperButton.setText("Add");
        addDeveloperButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDeveloperButtonActionPerformed(evt);
            }
        });

        removeDeveloperButton.setText("Remove");
        removeDeveloperButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDeveloperButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout developerPanelLayout = new org.jdesktop.layout.GroupLayout(developerPanel);
        developerPanel.setLayout(developerPanelLayout);
        developerPanelLayout.setHorizontalGroup(
            developerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(developerPanelLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(developerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, developerTableScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 454, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, developerPanelLayout.createSequentialGroup()
                        .add(addDeveloperButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(removeDeveloperButton)))
                .addContainerGap())
        );
        developerPanelLayout.setVerticalGroup(
            developerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(developerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(developerTableScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(developerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(removeDeveloperButton)
                    .add(addDeveloperButton))
                .addContainerGap())
        );

        administrationTabbedPanel.addTab("Developers", developerPanel);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(administrationTabbedPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(administrationTabbedPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 409, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fieldTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldTableMouseClicked
        if (evt.getClickCount() == 2) {
            new ManageFieldDialog(game, fieldTable, true).setVisible(true);
        }
        editFieldButton.setEnabled(fieldTable.getSelectedRowCount() > 0);
        deleteFieldButton.setEnabled(fieldTable.getSelectedRowCount() > 0);
    }//GEN-LAST:event_fieldTableMouseClicked

    private void createFieldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createFieldButtonActionPerformed
        new ManageFieldDialog(game, fieldTable, false).setVisible(true);
    }//GEN-LAST:event_createFieldButtonActionPerformed

    private void editFieldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editFieldButtonActionPerformed
        new ManageFieldDialog(game, fieldTable, true).setVisible(true);
    }//GEN-LAST:event_editFieldButtonActionPerformed

    private void deleteFieldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteFieldButtonActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this field? Doing so will erase all data.", "Confirm Deletion",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            ((FieldTableModel) fieldTable.getModel()).remove(fieldTable.getSelectedRows());
            MongoCollection instanceCollection = DatabaseHandler.getDatabase().getCollection("instances");
            String gameQuery = String.format("{gameId: '%s'}", game.getKey().toString());
            Iterable<Instance> instances = instanceCollection.find(gameQuery).as(Instance.class);
            MongoCollection capturedDataCollection = DatabaseHandler.getDatabase().getCollection("captureddata");
            for (Instance instance : instances) { 
                String instanceQuery = String.format("{instanceId: '%s'}", instance.getKey().toString());
                System.out.println(instanceQuery);
                capturedDataCollection.remove(instanceQuery);
            }
        }
        deleteFieldButton.setEnabled(false);
        editFieldButton.setEnabled(false);
    }//GEN-LAST:event_deleteFieldButtonActionPerformed

    private void addDeveloperButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDeveloperButtonActionPerformed
        new ManageDeveloperDialog(game).setVisible(true);
        ((DeveloperTableModel) developerTable.getModel()).populate();
    }//GEN-LAST:event_addDeveloperButtonActionPerformed

    private void removeDeveloperButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeDeveloperButtonActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this developer?", "Confirm Deletion",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            DeveloperTableModel developerTableModel = (DeveloperTableModel) developerTable.getModel();
            List<String> developerIds = game.getDeveloperIds();
            Developer developer = developerTableModel.getEntryAt(developerTable.getSelectedRow());
            int index = developerIds.indexOf(developer.getKey().toString());
            developerIds.remove(index);

            Game newGame = new Game(
                    game.getTitle(),
                    game.getGenre(),
                    developerIds);

            MongoCollection collection = DatabaseHandler.getDatabase().getCollection("games");
            collection.update(game.getKey()).merge(newGame);
            developerTableModel.populate();
        }
        removeDeveloperButton.setEnabled(false);
    }//GEN-LAST:event_removeDeveloperButtonActionPerformed

    private void developerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_developerTableMouseClicked
        DeveloperTableModel developerTableModel = (DeveloperTableModel) developerTable.getModel();
        removeDeveloperButton.setEnabled((developerTable.getSelectedRow() > 0) 
                &&  developerTableModel.getEntryAt(developerTable.getSelectedRow()).getAccountType() != AccountType.ADMINISTRATOR);
    }//GEN-LAST:event_developerTableMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDeveloperButton;
    private javax.swing.JScrollPane administrationScrollPane;
    private javax.swing.JTabbedPane administrationTabbedPanel;
    private javax.swing.JButton createFieldButton;
    private javax.swing.JButton deleteFieldButton;
    private javax.swing.JPanel developerPanel;
    private javax.swing.JTable developerTable;
    private javax.swing.JScrollPane developerTableScrollPane;
    private javax.swing.JButton editFieldButton;
    private javax.swing.JPanel fieldPanel;
    private javax.swing.JTable fieldTable;
    private javax.swing.JButton removeDeveloperButton;
    // End of variables declaration//GEN-END:variables
}
