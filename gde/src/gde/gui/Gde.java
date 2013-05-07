package gde.gui;

public class Gde {
    
    /**
     * Starts the GDE application.
     * @param args 
     */
    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            new LoginFrame().setVisible(true);
        } catch (Exception e) {
        }
    }
}
