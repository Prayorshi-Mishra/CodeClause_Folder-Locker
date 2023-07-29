package main;

import main.actions.LoginActions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoginBackground {

    public static JLabel loginBackground;
    public static JLabel LockCloseImage;
    public static JLabel LoginImage;
    public static JButton LoginButton;
    public static JButton cancelButton;
    public static JPasswordField passwordTextField;
    public static JLabel enterPasswordMessage;
    public static JLabel wrongPasswordMessage;
    public static void setMainBackground(){
        loginBackground = new JLabel();
        loginBackground.setSize(712,390);
        loginBackground.setLocation(0,0);
        loginBackground.setLayout(null);
        MainApplication.mainWindow.add(loginBackground);
        ImageIcon loginBackgroundIcon = new ImageIcon(MainApplication.class.getResource("/resources/grey screen.jpg"));
        loginBackground.setIcon(loginBackgroundIcon);

        setLockCloseImage();
        setMainLoginScreen();
        setLoginButton();
        setCancelButton();
        setPasswordTextField();
        setEnterPasswordMessage();
        enterPasswordMessageShowAndHide();
        LoginActions.setCancelButtonAction();
        LoginActions.setLoginButtonAction();
        setWrongPasswordMessage();
        loginByEnterKey();
    }
    public static void setLockCloseImage(){
        LockCloseImage = new JLabel();
        LockCloseImage.setLocation(0,0);
        LockCloseImage.setLayout(null);
        loginBackground.add(LockCloseImage);
        ImageIcon loginBackgroundIcon = new ImageIcon(MainApplication.class.getResource("/resources/clipart-lock-7.png"));
        LockCloseImage.setSize(loginBackgroundIcon.getIconWidth(), loginBackgroundIcon.getIconHeight());
        LockCloseImage.setLocation(292,20);
        LockCloseImage.setIcon(loginBackgroundIcon);
    }

    public static void setMainLoginScreen(){
        LoginImage = new JLabel();
        LoginImage.setLocation(0,0);
        LoginImage.setLayout(null);
        loginBackground.add(LoginImage);
        ImageIcon loginBackgroundIcon = new ImageIcon(MainApplication.class.getResource("/resources/PASSWORD 1.jpg"));
        LoginImage.setSize(loginBackgroundIcon.getIconWidth(), loginBackgroundIcon.getIconHeight());
        LoginImage.setLocation(168,206);
        LoginImage.setIcon(loginBackgroundIcon);
    }

    public static void setLoginButton(){
        LoginButton = new JButton("Login");
        LoginButton.setSize(80,20);
        LoginButton.setLocation(180,117);
        LoginImage.add(LoginButton);
    }

    public static void setCancelButton(){
        cancelButton = new JButton("Cancel");
        cancelButton.setSize(80,20);
        cancelButton.setLocation(280,117);
        LoginImage.add(cancelButton);
    }

    public static void setPasswordTextField(){
        passwordTextField = new JPasswordField();
        passwordTextField.setLocation(70,65);
        passwordTextField.setSize(233,25);
        passwordTextField.setBackground(new Color(204,204,204,255));
        passwordTextField.setLayout(null);
        passwordTextField.setBorder(null);
        passwordTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        LoginImage.add(passwordTextField);
    }

    public static void setEnterPasswordMessage(){
        enterPasswordMessage = new JLabel("Enter password here....");
        enterPasswordMessage.setSize(160,25);
        passwordTextField.add(enterPasswordMessage);
    }

    public static void enterPasswordMessageShowAndHide(){
        passwordTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                showAndHide();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                showAndHide();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                showAndHide();
            }
        });
    }
    public static void showAndHide(){
        char pass[] = passwordTextField.getPassword();
        if(pass.length==0){
            enterPasswordMessage.setVisible(true);
        }else{
            enterPasswordMessage.setVisible(false);
        }
    }

    public static void setWrongPasswordMessage(){
        wrongPasswordMessage = new JLabel("Incorrect Password!");
        wrongPasswordMessage.setSize(120,28);
        wrongPasswordMessage.setOpaque(false);
        wrongPasswordMessage.setFont(new Font("Arial", Font.PLAIN, 11));
        wrongPasswordMessage.setForeground(Color.RED);
        wrongPasswordMessage.setLocation(70,83);
        wrongPasswordMessage.setVisible(false);
        LoginImage.add(wrongPasswordMessage);
    }

    public static void loginByEnterKey(){
        passwordTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                if(code==KeyEvent.VK_ENTER){
                    LoginButton.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
}
