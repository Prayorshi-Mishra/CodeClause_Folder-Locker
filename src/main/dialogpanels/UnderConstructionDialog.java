package main.dialogpanels;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class UnderConstructionDialog {

    public JDialog dialog;
    public JLabel dialogBackground;
    public JLabel message;
    public UnderConstructionDialog(){
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException |  IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        dialog = new JDialog();
        dialog.setTitle("Message");
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
        setMessage();

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

    public void setMessage(){
        message = new JLabel("Under Construction");
        dialogBackground.add(message);
        message.setBounds(120,60,210,30);
        message.setFont(new Font("Arial", Font.ITALIC, 15));

    }
}
