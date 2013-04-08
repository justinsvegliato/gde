package gde.gui;

/**
 *
 * @author Justin Svegliato and Andrew Evans
 */
public class Gde {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
        } catch (Exception e) {
        }
    }
}
