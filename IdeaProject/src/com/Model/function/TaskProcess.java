package com.Model.function;

import com.Model.Database.DatabaseStaff;
import com.Model.Database.DatabaseStaffDepartment;
import com.Model.Database.DatabaseStaffTask;
import com.Model.Database.DatabaseTask;
import com.Model.Entity.*;

import java.util.ArrayList;

public class TaskProcess {
    Task task;

    public TaskProcess(){}

    public TaskProcess(Task task){
        this.task=task;
    }

    //得到所有的task
    public ArrayList<Task> getAllTask(){
        DatabaseTask databaseTask=new DatabaseTask();
        return databaseTask.searchTask(new Task(null,null,null,null,null));
    }

    //插入task数据
    public int newTask(Task task){
        DatabaseTask databaseTask=new DatabaseTask();
        databaseTask.insertTask(task);
        return 1;
    }

    //得到某个task涉及的人数
    public int getNumOfTask(Task task){
        DatabaseStaffTask databaseStaffTask=new DatabaseStaffTask();
        ArrayList<StaffTask> staffTasks= databaseStaffTask.searchStaffOrTask(new Staff(null,null,null,null,null),task);
        if(staffTasks==null){
            return -1;
        }
        return staffTasks.size();
    }

    //删除task数据
    public int deleteTask(Task task){
        DatabaseTask databaseTask=new DatabaseTask();

        databaseTask.deleteTask(task);
        return 1;
    }
}
