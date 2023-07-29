package main;

import main.util.FileOperations;
import main.util.LockedFileDataList;
import main.util.RecentDataList;

import javax.swing.*;
import java.awt.*;

public class MainApplication {
    public static JFrame mainWindow;

    public static void main(String args[]) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        mainWindow = new JFrame("Protected Folder");
        mainWindow.setSize(720,422);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setResizable(false);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = dimension.width/2-mainWindow.getWidth()/2;
        int y = dimension.height/2-mainWindow.getHeight()/2;
        mainWindow.setLocation(x,y);
        mainWindow.setLayout(null);


        //set login background
        LoginBackground.setMainBackground();

        //set main page
        MainPage.setMainPage();

        //check app directory
        FileOperations.checkApplicationDirectory();

        //populate recent file data
        RecentDataList.populateRecentFileData();

        //populate locked files data into main page table
        LockedFileDataList.populateLockedFileData();

        //new FilePanelDialog();
        //new ResetPasswordDialog();

        mainWindow.setVisible(true);
    }
}
