package com.Model.function;

import com.Model.Database.DatabaseDepartment;
import com.Model.Database.DatabaseStaffDepartment;
import com.Model.Entity.Department;
import com.Model.Entity.Staff;
import com.Model.Entity.StaffDepartment;

import java.util.ArrayList;

/**
 * Created by Edgar Liu
 */
public class DepartmentProcess {
    Department department;

    public DepartmentProcess() {
    }

    public DepartmentProcess(Department department) {
        this.department = department;
    }


    //得到所有的department
    public ArrayList<Department> getAllDepartment(){
        DatabaseDepartment databaseDepartment=new DatabaseDepartment();
        return databaseDepartment.searchDepartment(new Department(null,null,null));
    }


    public int getNumOfStaff(Department department){
       DatabaseStaffDepartment databaseStaffDepartment=new DatabaseStaffDepartment();
       ArrayList<StaffDepartment> staffDepartments= databaseStaffDepartment.searchStaffOrDepartment(new Staff(null,null,null,null,null),department);
       if(staffDepartments==null){
           return -1;
       }
       return staffDepartments.size();
    }
}
