package com.Model.function;

import com.Model.Database.DatabaseDepartment;
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

    public int getNumOfStaff(Staff staff){
        DatabaseStaff databaseStaff=new DatabaseStaff();
        ArrayList<Staff> staffs= databaseStaff.searchStaff(new Staff(null,null,null,null,null));
        if(staffs==null){
            return -1;
        }
        return staffs.size();
    }
}
