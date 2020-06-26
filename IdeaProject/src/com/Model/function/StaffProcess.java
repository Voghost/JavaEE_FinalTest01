package com.Model.function;

import com.Model.Database.DatabaseStaff;
import com.Model.Database.DatabaseStaffDepartment;
import com.Model.Entity.Department;
import com.Model.Entity.Staff;
import com.Model.Entity.StaffDepartment;

import java.util.ArrayList;

public class StaffProcess {
    Staff staff;

    public StaffProcess(){}

    public StaffProcess(Staff staff){
        this.staff=staff;
    }

    //得到所有的staff
    public ArrayList<Staff> getAllStaff(){
        DatabaseStaff databaseStaff=new DatabaseStaff();
        return databaseStaff.searchStaff(new Staff(null,null,null,null,null));
    }

    //插入一条员工数据
    public int newStaff(Staff staff){
        DatabaseStaff databaseStaff=new DatabaseStaff();
        databaseStaff.insertStaff(staff);
        return 1;
    }

    //得到某个员工的部门数量
    public int getNumOfDepartment(Staff staff){
        DatabaseStaffDepartment databaseStaffDepartment=new DatabaseStaffDepartment();
        ArrayList<StaffDepartment> staffDepartments= databaseStaffDepartment.searchStaffOrDepartment(staff,new Department(null,null,null));
        if(staffDepartments==null){
            return -1;
        }
        return staffDepartments.size();
    }

    //删除员工数据
    public int deleteStaff(Staff staff){
        DatabaseStaff databaseStaff=new DatabaseStaff(); //删除员工
        DatabaseStaffDepartment databaseStaffDepartment=new DatabaseStaffDepartment(); //删除与部门有联系的员工

        databaseStaff.deleteStaff(staff);
        databaseStaffDepartment.deleteStaffToDepartment(staff,new Department(null,null,null));
        return 1;
    }
}
