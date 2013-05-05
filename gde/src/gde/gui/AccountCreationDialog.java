package gde.gui;

import gde.gui.util.DatabaseHandler;
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

    public AccountCreationDialog(java.awt.Frame parent) {
        super(parent);
        initComponents();


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
        companyTextField = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        firstNameLabel = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        confirmPasswordLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        lastNameTextField = new javax.swing.JTextField();
        companyLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        confirmPasswordField = new javax.swing.JPasswordField();
        registerLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);

        companyTextField.setName("Company"); // NOI18N

        usernameLabel.setText("Username");

        usernameTextField.setName("Username"); // NOI18N

        firstNameLabel.setText("First Name");

        firstNameTextField.setName("First Name"); // NOI18N

        confirmPasswordLabel.setText("Confirm Password");

        lastNameLabel.setText("Last Name");

        lastNameTextField.setName("Last Name"); // NOI18N

        companyLabel.setText("Company");

        passwordLabel.setText("Password");

        passwordField.setName("Password"); // NOI18N

        confirmPasswordField.setName("Confirm Password"); // NOI18N

        registerLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        registerLabel.setText("Register");

        org.jdesktop.layout.GroupLayout registerFormPanelLayout = new org.jdesktop.layout.GroupLayout(registerFormPanel);
        registerFormPanel.setLayout(registerFormPanelLayout);
        registerFormPanelLayout.setHorizontalGroup(
            registerFormPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(registerFormPanelLayout.createSequentialGroup()
                .add(registerFormPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(registerFormPanelLayout.createSequentialGroup()
                        .add(46, 46, 46)
                        .add(registerFormPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(firstNameLabel)
                            .add(lastNameLabel)
                            .add(companyLabel))
                        .add(registerFormPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(registerFormPanelLayout.createSequentialGroup()
                                .add(18, 18, 18)
                                .add(registerFormPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(lastNameTextField)
                                    .add(firstNameTextField)))
                            .add(registerFormPanelLayout.createSequentialGroup()
                                .add(18, 18, 18)
                                .add(companyTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 195, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, registerFormPanelLayout.createSequentialGroup()
                        .add(registerFormPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(passwordLabel)
                            .add(confirmPasswordLabel)
                            .add(usernameLabel))
                        .add(18, 18, 18)
                        .add(registerFormPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(usernameTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .add(passwordField)
                            .add(confirmPasswordField)))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, registerLabel))
                .add(0, 0, Short.MAX_VALUE))
        );
        registerFormPanelLayout.setVerticalGroup(
            registerFormPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(registerFormPanelLayout.createSequentialGroup()
                .add(registerLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(registerFormPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(usernameLabel)
                    .add(usernameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(registerFormPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(passwordLabel)
                    .add(passwordField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(registerFormPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(confirmPasswordLabel)
                    .add(confirmPasswordField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(registerFormPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(firstNameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(firstNameLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(registerFormPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lastNameLabel)
                    .add(lastNameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(registerFormPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(companyTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(companyLabel))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(registerFormPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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