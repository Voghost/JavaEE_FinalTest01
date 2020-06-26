package com.Model.function;

import com.Model.Database.DatabaseDepartment;
import com.Model.Database.DatabaseStaff;
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


    //得到某个department的员工数量
    public int getNumOfStaff(Department department){
        DatabaseStaffDepartment databaseStaffDepartment=new DatabaseStaffDepartment();
        ArrayList<StaffDepartment> staffDepartments= databaseStaffDepartment.searchStaffOrDepartment(new Staff(null,null,null,null,null),department);
        if(staffDepartments==null){
            return -1;
        }
        return staffDepartments.size();
    }

    //插入一条部门数据
    public int newDepartment(Department department){
        DatabaseDepartment databaseDepartment=new DatabaseDepartment();
        databaseDepartment.insertDepartment(department);
        return 1;
    }

    //删除部门数据
    public int deleteDepartment(Department department){
        DatabaseDepartment databaseDepartment=new DatabaseDepartment(); //删除部门
        DatabaseStaffDepartment databaseStaffDepartment=new DatabaseStaffDepartment(); //删除与部门有联系的员工

        databaseDepartment.deleteDepartment(department);
        databaseStaffDepartment.deleteStaffToDepartment(new Staff(null,null,null,null,null),department);
        return 1;
    }
}
