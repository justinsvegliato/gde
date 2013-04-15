package gde.gui;

public class Gde {
    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            new LoginFrame().setVisible(true);
        } catch (Exception e) {
        }
    }
}
