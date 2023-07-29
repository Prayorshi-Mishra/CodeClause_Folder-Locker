package main.dialogpanels;

import main.actions.FileExplorerThread;
import main.actions.FilePanelDialogActions;
import main.util.RecentDataList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FilePanelDialog {
    public JDialog filePanelDialog;
    public JLabel recentPanelHeading;
    public JLabel recentFilePanel;
    public DefaultTableModel recentTableModel;
    public JTable recentTable;
    public JLabel lockListPanelHeading;
    public JLabel lockListPanel;
    public DefaultTableModel lockListTableModel;
    public JTable lockListTable;
    public JButton addButton;
    public JButton removeButton;
    public JButton clearButton;
    public JButton okButton;
    public JButton cancelButton;
    public JLabel fileExplorerPanel;
    public JLabel loadLabel;
    public JTree fileSystemTree;
    public FilePanelDialog(){
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException |  IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        filePanelDialog = new JDialog();
        filePanelDialog.setTitle("Add your Files and Folders");
        filePanelDialog.setSize(720,435);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = dimension.width/2-filePanelDialog.getWidth()/2;
        int y = dimension.height/2-filePanelDialog.getHeight()/2;
        filePanelDialog.setLocation(x,y);
        filePanelDialog.setAlwaysOnTop(true);
        filePanelDialog.setResizable(false);
        filePanelDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        filePanelDialog.setLayout(null);

        setRecentPanelHeading();
        setRecentFilePanel();
        setRecentTable();
        populateRecentTable();
        setLockListPanelHeading();
        setLockListPanel();
        setLockListTable();
        setAddButton();
        FilePanelDialogActions.setAddButtonAction(this);
        setRemoveButton();
        FilePanelDialogActions.setRemoveButtonAction(this);
        setClearButton();
        FilePanelDialogActions.setClearButtonAction(this);
        setOkButton();
        FilePanelDialogActions.setOkButtonAction(this);
        setCancelButton();
        FilePanelDialogActions.setCancelButtonAction(this);
        setFileExplorerPanel();
        setFileSystem();
        setLoadLabel();

        filePanelDialog.setVisible(true);
    }

    public void setRecentPanelHeading(){
        recentPanelHeading = new JLabel("Recently Unlocked Files");
        filePanelDialog.add(recentPanelHeading);
        recentPanelHeading.setSize(200,30);
        recentPanelHeading.setLocation(10,10);
    }

    public void setRecentFilePanel(){
        recentFilePanel = new JLabel();
        recentFilePanel.setSize(250,100);
        recentFilePanel.setLocation(10,40);
        recentFilePanel.setBackground(new Color(250,255,255,255));
        recentFilePanel.setOpaque(true);
        recentFilePanel.setLayout(null);
        recentFilePanel.setBorder(new LineBorder(new Color(10,10,10), 1));
        filePanelDialog.add(recentFilePanel);
    }

    public void setRecentTable(){
        recentTableModel = new DefaultTableModel();
        recentTableModel.addColumn("Recent Files");

        recentTable = new JTable(recentTableModel){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JScrollPane scrollPane = new JScrollPane(recentTable);
        scrollPane.setSize(244,94);
        scrollPane.setLocation(3,3);
        scrollPane.setViewportBorder(new LineBorder(new Color(200,200,200), 1));
        scrollPane.getViewport().setBackground(new Color(250,255,255,255));
        recentFilePanel.add(scrollPane);

        recentTable.setBackground(new Color(250,255,255,255));
        recentTable.setRowHeight(20);
        recentTable.setShowVerticalLines(false);
        recentTable.setFocusable(false);

        recentTable.getTableHeader().setReorderingAllowed(false);
        recentTable.getTableHeader().setBackground(new Color(250,255,255,255));
        recentTable.getTableHeader().getColumnModel().getColumn(0).setResizable(false);

    }

    public void populateRecentTable(){
        for(String fileString: RecentDataList.getRecentFiles()){
            recentTableModel.addRow(new Object[]{fileString});
        }
    }

    public void setLockListPanelHeading(){
        lockListPanelHeading = new JLabel("Lock File Path");
        filePanelDialog.add(lockListPanelHeading);
        lockListPanelHeading.setSize(200,30);
        lockListPanelHeading.setLocation(420,10);
    }

    public void setLockListPanel(){
        lockListPanel  = new JLabel();
        lockListPanel.setSize(283,310);
        lockListPanel.setLocation(420,40);
        lockListPanel.setBackground(new Color(250,255,255,255));
        lockListPanel.setOpaque(true);
        lockListPanel.setLayout(null);
        lockListPanel.setBorder(new LineBorder(new Color(10,10,10), 1));
        filePanelDialog.add(lockListPanel);
    }

    public void setLockListTable(){
        lockListTableModel = new DefaultTableModel();
        lockListTableModel.addColumn("Locked Files");

        lockListTable = new JTable(lockListTableModel){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JScrollPane scrollPane = new JScrollPane(lockListTable);
        scrollPane.setSize(277,304);
        scrollPane.setLocation(3,3);
        scrollPane.setViewportBorder(new LineBorder(new Color(200,200,200), 1));
        scrollPane.getViewport().setBackground(new Color(250,255,255,255));
        lockListPanel.add(scrollPane);

        lockListTable.setBackground(new Color(250,255,255,255));
        lockListTable.setRowHeight(30);
        lockListTable.setShowVerticalLines(false);
        lockListTable.setFocusable(false);

        lockListTable.getTableHeader().setReorderingAllowed(false);
        lockListTable.getTableHeader().setBackground(new Color(250,255,255,255));
        lockListTable.getTableHeader().getColumnModel().getColumn(0).setResizable(false);

    }

    public void setAddButton(){
        addButton = new JButton("Add >>");
        addButton.setSize(100,35);
        addButton.setLocation(290,160);
        addButton.setBackground(new Color(250,255,255,255));
        addButton.setFocusable(false);
        filePanelDialog.add(addButton);
    }

    public void setRemoveButton(){
        removeButton = new JButton("Remove <<");
        removeButton.setSize(100,35);
        removeButton.setLocation(290,210);
        removeButton.setBackground(new Color(250,255,255,255));
        removeButton.setFocusable(false);
        filePanelDialog.add(removeButton);
    }

    public void setClearButton(){
        clearButton = new JButton("Clear");
        clearButton.setSize(100,35);
        clearButton.setLocation(290,260);
        clearButton.setBackground(new Color(250,255,255,255));
        clearButton.setFocusable(false);
        filePanelDialog.add(clearButton);
    }

    public void setOkButton(){
        okButton = new JButton("OK");
        okButton.setSize(100,35);
        okButton.setLocation(495,360);
        okButton.setBackground(new Color(250,255,255,255));
        okButton.setFocusable(false);
        filePanelDialog.add(okButton);
    }

    public void setCancelButton(){
        cancelButton = new JButton("Cancel");
        cancelButton.setSize(100,35);
        cancelButton.setLocation(600,360);
        cancelButton.setBackground(new Color(250,255,255,255));
        cancelButton.setFocusable(false);
        filePanelDialog.add(cancelButton);
    }

    public void setFileExplorerPanel(){
        fileExplorerPanel  = new JLabel();
        fileExplorerPanel.setSize(250,200);
        fileExplorerPanel.setLocation(10,150);
        fileExplorerPanel.setBackground(new Color(250,255,255,255));
        fileExplorerPanel.setOpaque(true);
        fileExplorerPanel.setLayout(null);
        fileExplorerPanel.setBorder(new LineBorder(new Color(10,10,10), 1));
        filePanelDialog.add(fileExplorerPanel);
    }

    public void setFileSystem(){
        FileExplorerThread fileExplorerThread = new FileExplorerThread(this);
        fileExplorerThread.start();
    }

    public void setLoadLabel(){
        loadLabel = new JLabel("Please wait...");
        fileExplorerPanel.add(loadLabel);
        loadLabel.setSize(200,30);
        loadLabel.setLocation(80,60);
    }
}
