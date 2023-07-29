package main.actions;

import main.dialogpanels.ResetPasswordDialog;
import main.util.FileOperations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetPasswordDialogAction {

    public static void setDoneButtonAction(ResetPasswordDialog resetPasswordDialog){
        resetPasswordDialog.doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentPassword = resetPasswordDialog.currentPassTextField.getText();
                String newPassword = resetPasswordDialog.newPassTextField.getText();
                String confirmPassword = resetPasswordDialog.confirmPassTextField.getText();

                if(currentPassword==null || newPassword==null || confirmPassword==null || currentPassword.trim().isEmpty() || newPassword.trim().isEmpty() || confirmPassword.trim().isEmpty()){
                    resetPasswordDialog.warnMessage.setText("Please fill all the entries to continue.");
                } else if (!newPassword.equals(confirmPassword)) {
                    resetPasswordDialog.warnMessage.setText("No match found in new and confirm password!");
                } else if (currentPassword.equals(newPassword)) {
                    resetPasswordDialog.warnMessage.setText("New and current password cannot be same!");
                } else if (!currentPassword.equals(FileOperations.getPasswordFromFileForLogin())) {
                    resetPasswordDialog.warnMessage.setText("Current password is incorrect!");
                } else{
                    FileOperations.setPasswordInFile(newPassword);
                    resetPasswordDialog.warnMessage.setText("");
                    resetPasswordDialog.dialog.dispose();
                }
            }
        });
    }
}
