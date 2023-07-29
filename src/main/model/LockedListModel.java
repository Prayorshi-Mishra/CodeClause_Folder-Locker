package main.model;

import java.io.Serializable;
import java.util.List;

public class LockedListModel implements Serializable {
    private static final long serialVersionUID = 2l;

    List<String> lockedList;

    public LockedListModel() {
    }

    public LockedListModel(List<String> lockedList) {
        this.lockedList = lockedList;
    }

    public List<String> getLockedList() {
        return lockedList;
    }

    public void setLockedList(List<String> lockedList) {
        this.lockedList = lockedList;
    }
}
