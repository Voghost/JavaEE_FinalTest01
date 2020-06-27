package com.Model.function;

import com.Model.Database.*;
import com.Model.Entity.*;

import java.util.ArrayList;

/**
 * Created by Edgar Liu
 */
public class ProjectProcess {
    Project project;

    public ProjectProcess() {
    }

    public ProjectProcess(Project project) {
        this.project = project;
    }


    //得到所有的Project
    public ArrayList<Project> getAllProject(){
        DatabaseProject databaseProject=new DatabaseProject();
        return databaseProject.searchProject(new Project(null,null,null,null));
    }


    //得到某个项目的员工数量
    public int getNumOfProject(Project project){
        DatabaseStaffProject databaseStaffProject=new DatabaseStaffProject();
        ArrayList<StaffProject> staffProjects= databaseStaffProject.searchStaffOrProject(new Staff(null,null,null,null,null),project);
        if(staffProjects==null){
            return -1;
        }
        return staffProjects.size();
    }

    //插入一条项目数据
    public int newProject(Project project){
        DatabaseProject databaseProject=new DatabaseProject();
        DatabaseFolder databaseFolder = new DatabaseFolder();

        String projectId=databaseProject.insertProject(project);
        project.setProjectId(projectId);
        String path="projectFiles/"+project.getProjectId()+"-"+project.getProjectName();
        String folderId=databaseFolder.insertFolder(new Folder(null,path,null));
        project.setProjectPathId(folderId);
        databaseProject.updateProject(project);




//        DatabaseStaff databaseStaff = new DatabaseStaff();
//        DatabaseFolder databaseFolder = new DatabaseFolder();
//        //添加员工并返回值
//        String staffId=databaseStaff.insertStaff(staff);
//        //更新staff对象的id
//        staff.setStaffId(staffId);
//        String path = "staffFiles/" + staff.getStaffId();
//        String folderId = databaseFolder.insertFolder(new Folder(null, path, null));
//        //更新staff对象的路径
//        staff.setStaffFileID(folderId);
//        //修改数据
//        databaseStaff.updateStaff(staff);
//

        return 1;
    }

    //删除项目数据
    public int deleteProject(Project project){
        DatabaseProject databaseProject=new DatabaseProject();

        databaseProject.deleteProject(project);

        return 1;
    }
}
