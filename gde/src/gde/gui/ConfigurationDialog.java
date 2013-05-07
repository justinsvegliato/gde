package gde.gui;

import gde.gui.tablemodels.DeveloperTableModel;
import gde.gui.tablemodels.FieldTableModel;
import gde.gui.util.DatabaseHandler;
import gde.gui.util.ImageLoader;
import gde.models.Developer;
import gde.models.Developer.AccountType;
import gde.models.Game;
import gde.models.Instance;
import java.util.List;
import javax.swing.JOptionPane;
import org.jongo.MongoCollection;

public class ConfigurationDialog extends javax.swing.JDialog {

    private final Game game;

    /**
     * Creates new form ConfigurationDialog
     * @param game The game instance with which the admin is associated.
     */
    public ConfigurationDialog(Game game) {
        initComponents();
        setIconImage(ImageLoader.getAppIcon().getImage());
        setLocationRelativeTo(null);

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
        fieldCancelButton = new javax.swing.JButton();
        developerPanel = new javax.swing.JPanel();
        developerTableScrollPane = new javax.swing.JScrollPane();
        developerTable = new javax.swing.JTable();
        addDeveloperButton = new javax.swing.JButton();
        removeDeveloperButton = new javax.swing.JButton();
        developerCancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Admin Configuration");
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

        fieldCancelButton.setText("Cancel");
        fieldCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCancelButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout fieldPanelLayout = new org.jdesktop.layout.GroupLayout(fieldPanel);
        fieldPanel.setLayout(fieldPanelLayout);
        fieldPanelLayout.setHorizontalGroup(
            fieldPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(fieldPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(fieldPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(fieldPanelLayout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(createFieldButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(editFieldButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(deleteFieldButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(fieldCancelButton))
                    .add(administrationScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE))
                .addContainerGap())
        );
        fieldPanelLayout.setVerticalGroup(
            fieldPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(fieldPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(administrationScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(fieldPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(editFieldButton)
                    .add(deleteFieldButton)
                    .add(createFieldButton)
                    .add(fieldCancelButton))
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
        developerTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                developerTableKeyReleased(evt);
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

        developerCancelButton.setText("Cancel");
        developerCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                developerCancelButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout developerPanelLayout = new org.jdesktop.layout.GroupLayout(developerPanel);
        developerPanel.setLayout(developerPanelLayout);
        developerPanelLayout.setHorizontalGroup(
            developerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(developerPanelLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .add(developerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(developerTableScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 454, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, developerPanelLayout.createSequentialGroup()
                        .add(addDeveloperButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(removeDeveloperButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(developerCancelButton)))
                .addContainerGap())
        );
        developerPanelLayout.setVerticalGroup(
            developerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(developerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(developerTableScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(developerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(removeDeveloperButton)
                    .add(addDeveloperButton)
                    .add(developerCancelButton))
                .addContainerGap())
        );

        administrationTabbedPanel.addTab("Developers", developerPanel);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(administrationTabbedPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addContainerGap())
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

    /**
     * On a double click of a field in the table, opens a new ManageFieldDialog. 
     * On double or single click, enables the "edit" and "delete" buttons.
     * @param evt The swing ActionEvent trigger.
     */
    private void fieldTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldTableMouseClicked
        if (evt.getClickCount() == 2) {
            new ManageFieldDialog(game, fieldTable, true).setVisible(true);
        }
        editFieldButton.setEnabled(fieldTable.getSelectedRowCount() > 0);
        deleteFieldButton.setEnabled(fieldTable.getSelectedRowCount() > 0);
    }//GEN-LAST:event_fieldTableMouseClicked

    /**
     * Opens a new ManageFieldDialog to create a field when the "create field" button is clicked.
     * @param evt The swing ActionEvent trigger.
     */
    private void createFieldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createFieldButtonActionPerformed
        new ManageFieldDialog(game, fieldTable, false).setVisible(true);
    }//GEN-LAST:event_createFieldButtonActionPerformed

    /**
     * Opens a new ManageFieldDialog to edit a field when the "edit field" button is clicked.
     * @param evt The swing ActionEvent trigger.
     */
    private void editFieldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editFieldButtonActionPerformed
        new ManageFieldDialog(game, fieldTable, true).setVisible(true);
    }//GEN-LAST:event_editFieldButtonActionPerformed

    /**
     * Deletes a field and makes appropriate corrections to the database and application
     * after the "delete field" button has been clicked and the user has confirmed that
     * they want to take this action.
     * @param evt The swing ActionEvent trigger.
     */
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

    /**
     * Opens and populates a new ManageDeveloperDialog window when the "add developer" button is clicked.
     * @param evt The swing ActionEvent trigger.
     */
    private void addDeveloperButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDeveloperButtonActionPerformed
        new ManageDeveloperDialog(game).setVisible(true);
        ((DeveloperTableModel) developerTable.getModel()).populate();
    }//GEN-LAST:event_addDeveloperButtonActionPerformed

    /**
     * Deletes a developer and makes appropriate corrections to the database and application 
     * after the "remove developer" button has been clicked and the user has confirmed that 
     * they want to take this action.
     * @param evt The swing ActionEvent trigger.
     */
    private void removeDeveloperButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeDeveloperButtonActionPerformed
        DeveloperTableModel developerTableModel = (DeveloperTableModel) developerTable.getModel();
        List<String> developerIds = game.getDeveloperIds();
        Developer developer = developerTableModel.getEntryAt(developerTable.getSelectedRow());
        
        if (developer.getAccountType() == AccountType.ADMINISTRATOR) {
            JOptionPane.showMessageDialog(this, "This account is an administrator and cannot be removed.");
        }
        else {
            int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this developer?", "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {

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
        }
    }//GEN-LAST:event_removeDeveloperButtonActionPerformed

    /**
     * Enable the "remove developer" button if a non-admin developer is selected in the 
     * developer table.
     * @param evt The swing ActionEvent trigger.
     */
    private void developerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_developerTableMouseClicked
        enableRemoveDeveloperButton();
    }//GEN-LAST:event_developerTableMouseClicked

    /**
     * Dispose the window when the "cancel" button is clicked.
     * @param evt The swing ActionEvent trigger.
     */
    private void fieldCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_fieldCancelButtonActionPerformed

    /**
     * Dispose the window when the "cancel" button is clicked.
     * @param evt The swing ActionEvent trigger.
     */
    private void developerCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_developerCancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_developerCancelButtonActionPerformed

    private void developerTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_developerTableKeyReleased
        if (evt.getKeyCode() == 38 || evt.getKeyCode() == 40) {
            enableRemoveDeveloperButton();
        }
    }//GEN-LAST:event_developerTableKeyReleased

    private void enableRemoveDeveloperButton() {
        DeveloperTableModel developerTableModel = (DeveloperTableModel) developerTable.getModel();
            removeDeveloperButton.setEnabled((developerTable.getSelectedRow() > 0) 
                &&  developerTableModel.getEntryAt(developerTable.getSelectedRow()).getAccountType() != AccountType.ADMINISTRATOR);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDeveloperButton;
    private javax.swing.JScrollPane administrationScrollPane;
    private javax.swing.JTabbedPane administrationTabbedPanel;
    private javax.swing.JButton createFieldButton;
    private javax.swing.JButton deleteFieldButton;
    private javax.swing.JButton developerCancelButton;
    private javax.swing.JPanel developerPanel;
    private javax.swing.JTable developerTable;
    private javax.swing.JScrollPane developerTableScrollPane;
    private javax.swing.JButton editFieldButton;
    private javax.swing.JButton fieldCancelButton;
    private javax.swing.JPanel fieldPanel;
    private javax.swing.JTable fieldTable;
    private javax.swing.JButton removeDeveloperButton;
    // End of variables declaration//GEN-END:variables
}
