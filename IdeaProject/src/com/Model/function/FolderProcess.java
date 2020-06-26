package com.Model.function;

import com.Model.Database.DatabaseDepartment;
import com.Model.Database.DatabaseFolder;
import com.Model.Database.DatabaseStaff;
import com.Model.Database.DatabaseStaffDepartment;
import com.Model.Entity.Department;
import com.Model.Entity.Folder;
import com.Model.Entity.Staff;
import com.Model.Entity.StaffDepartment;

import java.util.ArrayList;

/**
 * Created by Edgar Liu
 */
public class FolderProcess {
    Folder folder;

    public FolderProcess() {
    }

    public FolderProcess(Folder folder) {
        this.folder = folder;
    }


    //得到所有的folder
    public ArrayList<Folder> getAllFolder(){
        DatabaseFolder databaseFolder=new DatabaseFolder();
        return databaseFolder.searchFolder(new Folder(null,null,null));
    }

    //插入一条folder数据
    public int newFolder(Folder folder){
        DatabaseFolder databaseFolder=new DatabaseFolder();
        databaseFolder.insertFolder(folder);
        return 1;
    }

    //删除folder数据
    public int deleteFolder(Folder folder){
        DatabaseFolder databaseFolder=new DatabaseFolder();

        databaseFolder.deleteFolder(folder);

        return 1;
    }
}
