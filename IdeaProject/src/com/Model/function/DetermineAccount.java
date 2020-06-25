package com.Model.function;


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
           this.staff.setStaffId("");
       }
       if(staff.getStaffPassword()==null){
          this.staff.setStaffPassword("");
       }
       this.staff=new Staff();
       this.staff.setStaffId(staff.getStaffId());
       this.staff.setStaffPassword(staff.getStaffPassword());
    }


    public int determine(){
        DatabaseStaff databaseStaff=new DatabaseStaff();
        return 1;
    }
}
