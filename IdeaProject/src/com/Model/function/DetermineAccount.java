package com.Model.function;


import com.Model.Database.DatabaseDepartment;
import com.Model.Database.DatabaseStaff;
import com.Model.Entity.Staff;

import java.util.ArrayList;

/**
 * Created by Edgar Liu
 */
public class DetermineAccount {
    Staff staff;

    public DetermineAccount(Staff staff){
       if(staff.getStaffId()==null){
           staff.setStaffId("");
       }
       if(staff.getStaffPassword()==null){
          staff.setStaffPassword("");
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
        ArrayList<Staff> staffs=new ArrayList<Staff>();
        DatabaseStaff databaseStaff=new DatabaseStaff();

        //第一次判断是否用用户
        staffs=databaseStaff.searchStaff(staff.getStaffId(),1);
        if(staffs==null){
            return -1; //如果返回空值，出现错误
        }
        if(staffs.size()==0){
            return 0; //账号错误
        }
        if(staffs.size()>1){
           flag=1; //存在账户
        }

        //第二次判断密码是否正确
        if(staffs.get(0).getStaffPassword().equals(staff.getStaffPassword())){
            flag=2;
        }
        System.out.println(staffs.toString());
        return flag;
    }
}