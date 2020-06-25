package com.Model.function;


import com.Model.Database.DatabaseDepartment;
import com.Model.Database.DatabaseStaff;
import com.Model.Entity.Department;
import com.Model.Entity.Staff;

import java.util.ArrayList;

/**
 * Created by Edgar Liu
 */
public class DetermineAccount {
    Staff staff;

    public DetermineAccount(Staff staff){
       if(staff.getStaffId()==null){
           this.staff.setStaffId("");
       }
       if(staff.getStaffPassword()==null){
          this.staff.setStaffPassword("");
       }
       this.staff=new Staff();
       this.staff.setStaffId(staff.getStaffId());
       this.staff.setStaffPassword(staff.getStaffPassword());
    }

    /**
     * 判断是否存在用户且密码是否正确
     * @return 0 不存在用户
     *         1 存在用户但秘密不正确
     *         2 密码正确 为普通用户
     *         -1 出现错误
     */
    public int determine(){
        int flag=0;
        ArrayList<Staff> staffs;
        DatabaseStaff databaseStaff=new DatabaseStaff();
        //第一次判断是否用用户
        staffs=databaseStaff.searchStaff(staff.getStaffId(),1);
        if(staffs==null){
            return -1; //如果返回空值，出现错误
        }
        if(staffs.size()>1){
           flag=1;
        }

        //第二次判断密码是否正确
        staffs=databaseStaff.searchStaff(staff);
        staff=staffs.get(0);

        if(staffs.size()>=1){
            DatabaseDepartment databaseDepartment=new DatabaseDepartment();
            flag=2; // 为普通用户
        }
        return flag;
    }
}