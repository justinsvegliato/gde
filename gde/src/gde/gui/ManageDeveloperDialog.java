package gde.gui;

import gde.gui.tablemodels.DeveloperTableModel;
import gde.gui.util.DatabaseHandler;
import gde.models.Developer;
import gde.models.Game;
import java.util.List;
import javax.swing.JOptionPane;
import org.bson.types.ObjectId;
import org.jongo.MongoCollection;

public class ManageDeveloperDialog extends javax.swing.JDialog {
    private final Game game;

    /**
     * Instantiates a new form ManageDeveloperDialog
     * @param game The game with which the form should be associated.
     */
    public ManageDeveloperDialog(Game game) {
        initComponents();
        getRootPane().setDefaultButton(selectButton);
        setLocationRelativeTo(null);

        this.game = game;
        
        MongoCollection collection = DatabaseHandler.getDatabase().getCollection("developers");
        StringBuilder builder = new StringBuilder();        
        for (int i = 0; i < game.getDeveloperIds().size(); i++) {            
            String delimiter = i < game.getDeveloperIds().size() - 1 ? ", " : "";
            Developer developer = collection.findOne(new ObjectId(game.getDeveloperIds().get(i))).as(Developer.class);           
            builder.append("'").append(developer.getUsername()).append("'").append(delimiter);
        }
        
        String query = String.format("{username: {$nin: [%s]}, accountType: {$ne: 'ADMINISTRATOR'}}", builder.toString());
        DeveloperTableModel unassociatedDeveloperTableModel = new DeveloperTableModel(game);
        unassociatedDeveloperTable.setModel(unassociatedDeveloperTableModel);
        unassociatedDeveloperTableModel.populate(query);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        developerScrollPane = new javax.swing.JScrollPane();
        unassociatedDeveloperTable = new javax.swing.JTable();
        selectButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);

        unassociatedDeveloperTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        unassociatedDeveloperTable.setShowGrid(true);
        developerScrollPane.setViewportView(unassociatedDeveloperTable);

        selectButton.setText("Select");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(developerScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(0, 159, Short.MAX_VALUE)
                        .add(selectButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cancelButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(developerScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 221, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(selectButton)
                    .add(cancelButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Associates the selected user to the currently associated game and disposes the window.
     * @param evt The swing ActionEvent trigger.
     */
    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        dispose();
        
        DeveloperTableModel developerTableModel = (DeveloperTableModel) unassociatedDeveloperTable.getModel();
        List<String> developerIds = game.getDeveloperIds();
        for (int selectedRow : unassociatedDeveloperTable.getSelectedRows()) {
            Developer developer = developerTableModel.getEntryAt(selectedRow);
            developerIds.add(developer.getKey().toString());
        }
        
        Game newGame = new Game(
                game.getTitle(),
                game.getGenre(),
                developerIds);
        
        MongoCollection collection = DatabaseHandler.getDatabase().getCollection("games");
        collection.update(game.getKey()).merge(newGame);
    }//GEN-LAST:event_selectButtonActionPerformed

    /**
     * Cancels the action and disposes the windows after the "cancel" button is clicked
     * and the user confirms that they want to take this action.
     * @param evt The swing ActionEvent trigger.
     */
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        if (unassociatedDeveloperTable.getSelectedRows().length > 0) {
            int response = JOptionPane.showConfirmDialog(this, "Are you sure you want cancel your changes?", "Confirm Cancellation",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JScrollPane developerScrollPane;
    private javax.swing.JButton selectButton;
    private javax.swing.JTable unassociatedDeveloperTable;
    // End of variables declaration//GEN-END:variables
}
