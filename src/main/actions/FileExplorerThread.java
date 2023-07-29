package main.actions;

import main.dialogpanels.FilePanelDialog;
import main.util.FileExplorer;

import javax.swing.*;

public class FileExplorerThread extends Thread{

    public FilePanelDialog filePanelDialog;
    public FileExplorerThread(FilePanelDialog filePanelDialog){
        this.filePanelDialog = filePanelDialog;
    }

    @Override
    public void run(){
        setFileSystem();
    }
    public void setFileSystem(){
        JScrollPane fileScrollPane = FileExplorer.getFileExplorerScrollPanel();
        filePanelDialog.fileExplorerPanel.add(fileScrollPane);
        fileScrollPane.setSize(250,200);
        fileScrollPane.setLocation(0,0);
        filePanelDialog.fileExplorerPanel.validate();
        filePanelDialog.loadLabel.setVisible(false);
        JTree tree =(JTree) fileScrollPane.getViewport().getView();
        filePanelDialog.fileSystemTree = tree;
        FileExplorer.clearSelection(filePanelDialog.fileSystemTree);
    }
}
