package main.actions;

import main.MainPage;
import main.dialogpanels.FilePanelDialog;
import main.dialogpanels.ResetPasswordDialog;
import main.dialogpanels.UnderConstructionDialog;
import main.util.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MainPageActions {
    public static void setAddButtonAction(){
        MainPage.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FilePanelDialog();
            }
        });
    }

    public static Boolean isRowAlreadyExists(String rowValue){
        Vector<Vector> data = MainPage.tableModel.getDataVector();
        for(Vector vectorValue: data){
            if(vectorValue.get(0).equals(rowValue)){
                return true;
            }
        }
        return false;
    }

    public static void setUnlockButtonAction(){
        MainPage.unlockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] rowIndexes = MainPage.table.getSelectedRows();
                if(rowIndexes.length == 0){
                    return;
                }
                ArrayManipulations.reverseArrayOfInt(rowIndexes);
                List<String> datalist = new ArrayList<>();
                for(int rowNumber : rowIndexes){
                    String value = (String)MainPage.table.getValueAt(rowNumber,0);
                    if(FileOperations.unHideFileFromSystem(value)){
                        datalist.add(value);
                        MainPage.tableModel.removeRow(rowNumber);
                    }
                }
                RecentDataList.appendRecentFiles(datalist);
                LockedFileDataList.removeLockedFiles(datalist);
            }
        });
    }

    public static void setInnerButtonAction(){
        MainPage.addInnerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openPopupMenu();
            }
        });
    }
    static void openPopupMenu(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JPopupMenu popupMenu = new JPopupMenu();
        for(String itemValue: RecentDataList.getRecentFiles()){
            JMenuItem item = new JMenuItem(itemValue);
            popupMenu.add(item);
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(FileOperations.isValidFile(itemValue)){
                        if(!MainPageActions.isRowAlreadyExists(itemValue)){
                            if(FileOperations.hideFileFromSystem(itemValue)){
                                MainPage.tableModel.addRow(new Object[]{itemValue, "Active"});
                                List<String> temp = new ArrayList<>();
                                temp.add(itemValue);
                                LockedFileDataList.appendLockedFiles(temp);
                            }
                        }
                    }
                }
            });
        }
        popupMenu.show(MainPage.addInnerButton, 10,33);
    }

    public static void setExitButtonAction(){
        MainPage.exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginScreenCloseThread loginScreenCloseThread = new LoginScreenCloseThread();
                loginScreenCloseThread.start();
            }
        });
    }

    public static void setOptionsButtonAction(){
        MainPage.optionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ResetPasswordDialog();
            }
        });
    }

    public static void setSupportButtonAction(){
        MainPage.supportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UrlOpener.openWebPage("https://www.google.com/");
            }
        });
    }

    public static void setRegisterButtonAction(){
        MainPage.registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UnderConstructionDialog();
            }
        });
    }
}
