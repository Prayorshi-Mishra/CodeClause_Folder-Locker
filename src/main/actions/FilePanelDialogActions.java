package main.actions;

import main.MainPage;
import main.dialogpanels.FilePanelDialog;
import main.util.ArrayManipulations;
import main.util.FileExplorer;
import main.util.FileOperations;
import main.util.LockedFileDataList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class FilePanelDialogActions {

    public static void setAddButtonAction(FilePanelDialog dialogObject){
        dialogObject.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //get selected files from recent list
                int[] selectedRows = dialogObject.recentTable.getSelectedRows();
                for(int rowNumber : selectedRows){
                    String rowValue = (String) dialogObject.recentTable.getValueAt(rowNumber, 0);
                    if(FileOperations.isValidFile(rowValue)){
                        if(!isRowAlreadyExists(rowValue, dialogObject)){
                            dialogObject.lockListTableModel.addRow(new Object[]{rowValue});
                        }
                    }
                }

                //get selected files from file explorer
                String filePath = FileExplorer.getSelectedFile();
                if(FileOperations.isValidFile(filePath)){
                    if(!isRowAlreadyExists(filePath, dialogObject)){
                        dialogObject.lockListTableModel.addRow(new Object[]{filePath});
                    }
                }
            }
        });
    }

    public static Boolean isRowAlreadyExists(String rowValue, FilePanelDialog dialogObject){
        Vector<Vector> data = dialogObject.lockListTableModel.getDataVector();
        for(Vector vectorValue: data){
            if(vectorValue.get(0).equals(rowValue)){
                return true;
            }
        }
        return false;
    }

    public static void setRemoveButtonAction(FilePanelDialog dialogObject){
        dialogObject.removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] rowIndexes = dialogObject.lockListTable.getSelectedRows();
                if(rowIndexes.length == 0){
                    return;
                }
                ArrayManipulations.reverseArrayOfInt(rowIndexes);
                for(int rowNumber : rowIndexes){
                    dialogObject.lockListTableModel.removeRow(rowNumber);
                }
            }
        });
    }

    public static void setCancelButtonAction(FilePanelDialog dialogObject){
        dialogObject.cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogObject.filePanelDialog.dispose();
            }
        });
    }

    public static void setClearButtonAction(FilePanelDialog dialogObject){
        dialogObject.clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogObject.recentTable.clearSelection();
                dialogObject.lockListTable.clearSelection();
                if(dialogObject.fileSystemTree != null){
                    FileExplorer.clearSelection(dialogObject.fileSystemTree);
                }
            }
        });
    }

    public static void setOkButtonAction(FilePanelDialog dialogObject){
        dialogObject.okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<Vector> dataVector = dialogObject.lockListTableModel.getDataVector();
                List<String> files = new ArrayList<>();
                for(Vector data : dataVector){
                    String value = data.get(0).toString();
                    if(!MainPageActions.isRowAlreadyExists(value)){
                        if(FileOperations.hideFileFromSystem(value)){
                            MainPage.tableModel.addRow(new Object[]{value, "Active"});
                            files.add(value);
                        }
                    }
                }
                LockedFileDataList.appendLockedFiles(files);
                dialogObject.filePanelDialog.dispose();
            }
        });
    }
}
