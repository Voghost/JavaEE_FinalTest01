package com.Model.function;

import com.Model.Database.*;
import com.Model.Entity.*;

import java.util.ArrayList;

public class StaffProcess {
    Staff staff;

    public StaffProcess() {
    }

    public StaffProcess(Staff staff) {
        this.staff = staff;
    }

    //得到所有的staff
    public ArrayList<Staff> getAllStaff() {
        DatabaseStaff databaseStaff = new DatabaseStaff();
        return databaseStaff.searchStaff(new Staff(null, null, null, null, null));
    }

    //插入一条员工数据 返回ID
    public String newStaff(Staff staff) {
        DatabaseStaff databaseStaff = new DatabaseStaff();
        DatabaseFolder databaseFolder = new DatabaseFolder();


        //添加员工并返回值
        String staffId=databaseStaff.insertStaff(staff);

        //更新staff对象的id
        staff.setStaffId(staffId);
        String path = "staffFiles/" + staff.getStaffId();


        String folderId = databaseFolder.insertFolder(new Folder(null, path, null));

        //更新staff对象的路径
        staff.setStaffFileID(folderId);

        //修改数据
        databaseStaff.updateStaff(staff);
        return staffId;
    }

    //得到某个员工的部门数量
    public int getNumOfDepartment(Staff staff) {
        DatabaseStaffDepartment databaseStaffDepartment = new DatabaseStaffDepartment();
        ArrayList<StaffDepartment> staffDepartments = databaseStaffDepartment.searchStaffOrDepartment(staff, new Department(null, null, null));
        if (staffDepartments == null) {
            return -1;
        }
        return staffDepartments.size();
    }

    //获得某个员工涉及的任务数量
    public int getNumOfTask(Staff staff) {
        DatabaseStaffTask databaseStaffTask = new DatabaseStaffTask();
        ArrayList<StaffTask> staffTasks = databaseStaffTask.searchStaffOrTask(staff, new Task(null, null, null, null, null));
        if (staffTasks == null) {
            return -1;
        }
        return staffTasks.size();
    }

    //获得员工的涉及的项目数量
    public int getNumOfProject(Staff staff) {
        DatabaseStaffProject databaseProjec = new DatabaseStaffProject();
        ArrayList<StaffProject> staffProjects = databaseProjec.searchStaffOrProject(staff, new Project(null, null, null, null));
        if (staffProjects == null) {
            return -1;
        }
        return staffProjects.size();
    }

    //删除员工数据
    public int deleteStaff(Staff staff) {
        DatabaseStaff databaseStaff = new DatabaseStaff(); //删除员工
        DatabaseStaffDepartment databaseStaffDepartment = new DatabaseStaffDepartment(); //删除与部门有联系的员工

        databaseStaff.deleteStaff(staff);
        databaseStaffDepartment.deleteStaffToDepartment(staff, new Department(null, null, null));
        return 1;
    }
}
