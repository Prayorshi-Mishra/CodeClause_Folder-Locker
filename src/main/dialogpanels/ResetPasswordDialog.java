package main.dialogpanels;

import main.actions.ResetPasswordDialogAction;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ResetPasswordDialog {

    public JDialog dialog;
    public JLabel dialogBackground;
    public JLabel currentPassLabel, newPassLabel, confirmPassLabel;
    public JTextField currentPassTextField, newPassTextField, confirmPassTextField;
    public JButton doneButton;
    public JLabel warnMessage;

    public ResetPasswordDialog(){
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException |  IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        dialog = new JDialog();
        dialog.setTitle("Reset Password");
        dialog.setSize(450,250);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = dimension.width/2-dialog.getWidth()/2;
        int y = dimension.height/2-dialog.getHeight()/2;
        dialog.setLocation(x,y);
        dialog.setAlwaysOnTop(true);
        dialog.setResizable(false);
        dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setLayout(null);

        setDialogBackground();
        setPasswordLabels();
        setPasswordTextFields();
        setDoneButton();
        setWarnMessage();
        ResetPasswordDialogAction.setDoneButtonAction(this);

        dialog.setVisible(true);
    }

    public void setDialogBackground(){
        dialogBackground = new JLabel();
        dialogBackground.setBounds(15,15,415,190);
        dialogBackground.setBackground(Color.WHITE);
        dialogBackground.setLayout(null);
        dialogBackground.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
        dialogBackground.setOpaque(true);
        dialog.add(dialogBackground);
    }

    public void setPasswordLabels(){
        currentPassLabel = new JLabel("Current Password");
        currentPassLabel.setBounds(30,20,110,30);
        dialogBackground.add(currentPassLabel);
        newPassLabel = new JLabel("New Password");
        newPassLabel.setBounds(30,60,110,30);
        dialogBackground.add(newPassLabel);
        confirmPassLabel = new JLabel("Confirm Password");
        confirmPassLabel.setBounds(30,100,110,30);
        dialogBackground.add(confirmPassLabel);
    }

    public void setPasswordTextFields(){
        currentPassTextField = new JTextField();
        currentPassTextField.setBounds(150,20,200,30);
        currentPassTextField.setFont(new Font("Arial", Font.ITALIC, 13));
        dialogBackground.add(currentPassTextField);
        newPassTextField = new JTextField();
        newPassTextField.setBounds(150,60,200,30);
        newPassTextField.setFont(new Font("Arial", Font.ITALIC, 13));
        dialogBackground.add(newPassTextField);
        confirmPassTextField = new JTextField();
        confirmPassTextField.setBounds(150,100,200,30);
        confirmPassTextField.setFont(new Font("Arial", Font.ITALIC, 13));
        dialogBackground.add(confirmPassTextField);
    }

    public void setDoneButton(){
        doneButton = new JButton("Done");
        doneButton.setBounds(250,150,100,30);
        doneButton.setFont(new Font("Arial", Font.BOLD, 15));
        doneButton.setFocusable(false);
        dialogBackground.add(doneButton);
    }

    public void setWarnMessage(){
        warnMessage = new JLabel();
        warnMessage.setBounds(150,125,300,30);
        warnMessage.setForeground(Color.RED);
        warnMessage.setFont(new Font("Arial", Font.BOLD, 10));
        dialogBackground.add(warnMessage);
    }
}
