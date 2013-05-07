package gde.gui;

import gde.gui.util.DatabaseHandler;
import gde.gui.util.ImageLoader;
import gde.models.Developer;
import gde.models.Developer.AccountType;
import gde.models.Game;
import javax.swing.JOptionPane;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

public class LoginFrame extends javax.swing.JFrame {

    private static final Jongo database = DatabaseHandler.getDatabase();
    private boolean isAdmin = false;

    /**
     * Instantiates a new form LoginFrame.
     */
    public LoginFrame() {
        initComponents();
        getRootPane().setDefaultButton(loginButton);
        setIconImage(ImageLoader.getAppIcon().getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoLabel = new javax.swing.JLabel();
        loginFormContainer = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        passwordTextField = new javax.swing.JPasswordField();
        passwordLabel = new javax.swing.JLabel();
        gameLabel = new javax.swing.JLabel();
        gameComboBox = new javax.swing.JComboBox();
        loginButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game Diagnostics Engine");
        setMinimumSize(new java.awt.Dimension(596, 210));
        setResizable(false);

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gde/resources/logo_small.png"))); // NOI18N
        logoLabel.setPreferredSize(new java.awt.Dimension(300, 190));

        nameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gde/resources/title_text.png"))); // NOI18N

        usernameLabel.setText("Username");

        usernameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usernameTextFieldKeyReleased(evt);
            }
        });

        passwordTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordTextFieldKeyReleased(evt);
            }
        });

        passwordLabel.setText("Password");

        gameLabel.setText("Game");

        gameComboBox.setEnabled(false);
        gameComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                gameComboBoxItemStateChanged(evt);
            }
        });

        loginButton.setText("Login");
        loginButton.setEnabled(false);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout loginFormContainerLayout = new org.jdesktop.layout.GroupLayout(loginFormContainer);
        loginFormContainer.setLayout(loginFormContainerLayout);
        loginFormContainerLayout.setHorizontalGroup(
            loginFormContainerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(nameLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .add(loginFormContainerLayout.createSequentialGroup()
                .add(loginFormContainerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(gameLabel)
                    .add(loginFormContainerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(usernameLabel)
                        .add(passwordLabel)))
                .add(loginFormContainerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(loginFormContainerLayout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(loginFormContainerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, passwordTextField)
                            .add(usernameTextField)))
                    .add(loginFormContainerLayout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(gameComboBox, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, loginFormContainerLayout.createSequentialGroup()
                .add(0, 0, Short.MAX_VALUE)
                .add(registerButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(loginButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(exitButton))
        );
        loginFormContainerLayout.setVerticalGroup(
            loginFormContainerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(loginFormContainerLayout.createSequentialGroup()
                .add(10, 10, 10)
                .add(nameLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 14, Short.MAX_VALUE)
                .add(loginFormContainerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(usernameLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(usernameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(11, 11, 11)
                .add(loginFormContainerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(passwordLabel)
                    .add(passwordTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(11, 11, 11)
                .add(loginFormContainerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(gameComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(gameLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 15, Short.MAX_VALUE)
                .add(loginFormContainerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(exitButton)
                    .add(loginButton)
                    .add(registerButton))
                .add(0, 0, 0))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(10, 10, 10)
                .add(logoLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 300, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(12, 12, 12)
                .add(loginFormContainer, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(10, 10, 10)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(loginFormContainer, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(logoLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                .add(10, 10, 10))
        );

        setSize(new java.awt.Dimension(628, 248));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Ends the application when the "exit" button is clicked.
     * @param evt The swing ActionEvent trigger.
     */
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    /**
     * When the "login / choose game" button is clicked, takes the appropriate actions
     * in checking the username / encrypted password and the games with which the user
     * is associated. 
     * @param evt The swing ActionEvent trigger.
     */
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String command = evt.getActionCommand();
        if (command.equals("Login")) {
            Developer developer;
            String username = usernameTextField.getText().toLowerCase();
            String password = new String(passwordTextField.getPassword());
            if ((developer = getDeveloper(username, password)) != null) {
                isAdmin = developer.getAccountType() == AccountType.ADMINISTRATOR;

                MongoCollection gamesCollection = database.getCollection("games");
                String query = String.format("{developerIds: '%s'}", developer.getKey().toString());
                Iterable<Game> games = gamesCollection.find(query).as(Game.class);
                if (games.iterator().hasNext()) {
                    gameComboBox.setEnabled(true);
                    loginButton.setText("Choose Game");
                    usernameTextField.setEnabled(false);
                    passwordTextField.setEnabled(false);
                    registerButton.setVisible(false);
                    gameComboBox.addItem("Select a game...");
                    for (Game game : games) {
                        gameComboBox.addItem(game);
                    }
                } else {
                    JOptionPane.showMessageDialog(this,
                            "This username is not associated with any games.",
                            "No Game Assocations",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "The username or password is incorrect. Please try again.",
                        "Incorrect Credentials",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (command.equals("Choose Game")) {
            Game game = (Game) gameComboBox.getSelectedItem();
            dispose();
            new MainMenu(game, isAdmin).setVisible(true);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    /**
     * Opens a new AccountCreationDialog when the "register" button is clicked.
     * @param evt The swing ActionEvent trigger.
     */
    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        new AccountCreationDialog(this);
    }//GEN-LAST:event_registerButtonActionPerformed

    private void gameComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_gameComboBoxItemStateChanged
        loginButton.setEnabled(!gameComboBox.getSelectedItem().equals("Select a game..."));
    }//GEN-LAST:event_gameComboBoxItemStateChanged

    private void usernameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameTextFieldKeyReleased
        boolean isValid = !usernameTextField.getText().trim().isEmpty() && !passwordTextField.getText().trim().isEmpty();
        loginButton.setEnabled(isValid);
    }//GEN-LAST:event_usernameTextFieldKeyReleased

    private void passwordTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordTextFieldKeyReleased
        boolean isValid = !usernameTextField.getText().trim().isEmpty() && !passwordTextField.getText().trim().isEmpty();
        loginButton.setEnabled(isValid);
    }//GEN-LAST:event_passwordTextFieldKeyReleased

    private Developer getDeveloper(String username, String password) {
        MongoCollection developersCollection = database.getCollection("developers");
        String query = String.format("{username: '%s', password: '%s'}", username, password);
        return developersCollection.findOne(query).as(Developer.class);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JComboBox gameComboBox;
    private javax.swing.JLabel gameLabel;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginFormContainer;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
