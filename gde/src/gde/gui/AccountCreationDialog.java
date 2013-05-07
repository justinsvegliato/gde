package gde.gui;

import gde.gui.util.DatabaseHandler;
import gde.gui.util.ImageLoader;
import gde.models.Developer;
import gde.models.Developer.AccountType;
import org.jongo.MongoCollection;
import org.netbeans.validation.api.AbstractValidator;
import org.netbeans.validation.api.Problems;
import org.netbeans.validation.api.Severity;
import org.netbeans.validation.api.Validator;
import org.netbeans.validation.api.ValidatorUtils;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.GroupValidator;
import org.netbeans.validation.api.ui.swing.SwingValidationGroup;
import org.netbeans.validation.api.ui.swing.ValidationPanel;

public class AccountCreationDialog extends javax.swing.JDialog {

    /**
     * Creates new form AccountCreationDialog.
     * @param parent The parent frame which creates the AccountCreationDialog
     */
    public AccountCreationDialog(java.awt.Frame parent) {
        super(parent);
        initComponents();
        setIconImage(ImageLoader.getAppIcon().getImage());
        setLocationRelativeTo(null);

        ValidationPanel validationPanel = new ValidationPanel();
        validationPanel.setInnerComponent(registerFormPanel);
        setContentPane(validationPanel);

        Validator<String> credentialValidator = ValidatorUtils.merge(
                StringValidators.REQUIRE_NON_EMPTY_STRING,
                StringValidators.NO_WHITESPACE,
                StringValidators.minLength(4),
                StringValidators.maxLength(20));

        Validator<String> usernameValidator = ValidatorUtils.merge(
                credentialValidator,
                new UsernameValidator());

        Validator<String> passwordValidator = ValidatorUtils.merge(
                credentialValidator);

        Validator<String> nameValidator = ValidatorUtils.merge(
                StringValidators.REQUIRE_NON_EMPTY_STRING,
                StringValidators.minLength(2),
                StringValidators.maxLength(30));

        validationPanel.getValidationGroup().add(companyTextField, nameValidator);
        validationPanel.getValidationGroup().add(lastNameTextField, nameValidator);
        validationPanel.getValidationGroup().add(firstNameTextField, nameValidator);

        SwingValidationGroup passwordFieldSubGroup = SwingValidationGroup.create(new PasswordValidator());
        passwordFieldSubGroup.add(confirmPasswordField, passwordValidator);
        passwordFieldSubGroup.add(passwordField, passwordValidator);
        validationPanel.getValidationGroup().addItem(passwordFieldSubGroup, false);

        validationPanel.getValidationGroup().add(usernameTextField, usernameValidator);

        if (validationPanel.showOkCancelDialog("Registration")) {
            MongoCollection collection = DatabaseHandler.getDatabase().getCollection("developers");
            Developer developer = new Developer(
                    firstNameTextField.getText(),
                    lastNameTextField.getText(),
                    companyTextField.getText(),
                    usernameTextField.getText().toLowerCase(),
                    new String(passwordField.getPassword()),
                    AccountType.DEVELOPER);
            collection.insert(developer);
        }
    }

    private final class UsernameValidator extends AbstractValidator<String> {

        UsernameValidator() {
            super(String.class);
        }

        @Override
        public void validate(Problems problems, String name, String input) {
            if (!input.isEmpty()) {
                MongoCollection collection = DatabaseHandler.getDatabase().getCollection("developers");
                String query = String.format("{username: '%s'}", input);
                if (collection.findOne(query).as(Developer.class) != null) {
                    problems.add("This username already exists", Severity.FATAL);
                }
            }
        }
    }

    private final class PasswordValidator extends GroupValidator {

        @Override
        protected void performGroupValidation(Problems problems) {
            if (!new String(confirmPasswordField.getPassword()).equals(new String(passwordField.getPassword()))) {
                problems.add("The specified passwords do not match", Severity.FATAL);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registerFormPanel = new javax.swing.JPanel();
        registerLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        confirmPasswordLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        companyLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        confirmPasswordField = new javax.swing.JPasswordField();
        firstNameTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        companyTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);

        registerLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        registerLabel.setText("Register an Account");

        usernameLabel.setText("Username");

        passwordLabel.setText("Password");

        confirmPasswordLabel.setText("Confirm Password");

        firstNameLabel.setText("First Name");

        lastNameLabel.setText("Last Name");

        companyLabel.setText("Company");

        usernameTextField.setName("Username"); // NOI18N

        passwordField.setName("Password"); // NOI18N

        confirmPasswordField.setName("Confirm Password"); // NOI18N

        firstNameTextField.setName("First Name"); // NOI18N

        lastNameTextField.setName("Last Name"); // NOI18N

        companyTextField.setName("Company"); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(0, 0, 0)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, passwordLabel)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, usernameLabel)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, firstNameLabel)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, lastNameLabel)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, companyLabel)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, confirmPasswordLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(passwordField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .add(confirmPasswordField)
                    .add(firstNameTextField)
                    .add(lastNameTextField)
                    .add(usernameTextField)
                    .add(companyTextField))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(usernameLabel)
                    .add(usernameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(passwordLabel)
                    .add(passwordField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(confirmPasswordLabel)
                    .add(confirmPasswordField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(firstNameLabel)
                    .add(firstNameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lastNameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lastNameLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(companyLabel)
                    .add(companyTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout registerFormPanelLayout = new org.jdesktop.layout.GroupLayout(registerFormPanel);
        registerFormPanel.setLayout(registerFormPanelLayout);
        registerFormPanelLayout.setHorizontalGroup(
            registerFormPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(registerFormPanelLayout.createSequentialGroup()
                .add(registerFormPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(registerLabel)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        registerFormPanelLayout.setVerticalGroup(
            registerFormPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(registerFormPanelLayout.createSequentialGroup()
                .add(registerLabel)
                .add(0, 0, 0)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(19, 19, 19)
                .add(registerFormPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(registerFormPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel companyLabel;
    private javax.swing.JTextField companyTextField;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JLabel confirmPasswordLabel;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPanel registerFormPanel;
    private javax.swing.JLabel registerLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}