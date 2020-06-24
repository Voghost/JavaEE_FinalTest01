package com.Model.Entity;

public class Folder {
    String folderId;
    String folderPath;
    String folderRemark;

    public Folder(String folderId, String folderPath, String folderRemark) {
        this.folderId = folderId;
        this.folderPath = folderPath;
        this.folderRemark = folderRemark;
    }

    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }

    public String getFolderRemark() {
        return folderRemark;
    }

    public void setFolderRemark(String folderRemark) {
        this.folderRemark = folderRemark;
    }

    @Override
    public String toString() {
        return "Folder{" +
                "folderId='" + folderId + '\'' +
                ", folderPath='" + folderPath + '\'' +
                ", folderRemark='" + folderRemark + '\'' +
                '}';
    }
}
