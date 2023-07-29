package main.util;

import main.MainPage;
import main.model.LockedListModel;

import java.util.ArrayList;
import java.util.List;

public class LockedFileDataList {
    public static List<String> lockedFiles = new ArrayList<>();

    public static void appendLockedFiles(List<String> files){
        if(files.size()==0){
            return;
        }
        lockedFiles.addAll(files);
        FileOperations.saveLockedListData(lockedFiles);
    }
    public static void populateLockedFileData(){
        LockedListModel lockedListModel = FileOperations.getLockedListData();
        if(lockedListModel==null || lockedListModel.getLockedList()==null || lockedListModel.getLockedList().size()==0){
            return;
        }
        lockedFiles.addAll(lockedListModel.getLockedList());
        for(String data : lockedFiles){
            MainPage.tableModel.addRow(new Object[]{data, "Active"});
        }
    }

    public static void removeLockedFiles(List<String> files){
        if(files.size()==0){
            return;
        }
        lockedFiles.removeAll(files);
        FileOperations.saveLockedListData(lockedFiles);
    }
}
