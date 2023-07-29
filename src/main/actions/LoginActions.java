package main.actions;

import main.LoginBackground;
import main.util.FileOperations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginActions {
    public static void setCancelButtonAction(){
        LoginBackground.cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void setLoginButtonAction(){
        LoginBackground.LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char passwordArray[] = LoginBackground.passwordTextField.getPassword();
                String password = String.valueOf(passwordArray);
                if(password.equals(FileOperations.getPasswordFromFileForLogin())){
                    scrollLoginScreen();
                    LoginBackground.wrongPasswordMessage.setVisible(false);
                }else{
                    LoginBackground.wrongPasswordMessage.setVisible(true);
                }
            }
        });
    }

    public static void scrollLoginScreen(){
        LoginScreenOpenThread loginScreenOpenThread = new LoginScreenOpenThread();
        loginScreenOpenThread.start();
    }
}
