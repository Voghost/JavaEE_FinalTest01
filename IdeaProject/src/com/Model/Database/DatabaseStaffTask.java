package com.Model.Database;

import com.Model.Entity.Department;
import com.Model.Entity.Task;
import com.Model.Entity.Staff;
import com.Model.Entity.StaffTask;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Edgar Liu
 */
public class DatabaseStaffTask {
    DataBean dataBean = new DataBean();
    DataSource dataSource = dataBean.getDataSource();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    //建立员工和部门联系
    public int connectStaffToTask(Staff staff, Task task) {
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO staff_task(StaffId,TaskId) VALUES(?,?)");
            preparedStatement.setString(1, staff.getStaffId());
            preparedStatement.setString(2, task.getTaskId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
            return -1; //-1 插入失败
        }finally {
            closeProcess(connection,resultSet,preparedStatement);
        }
        return 1;
    }

    //删除员工和部门联系
    public int deleteStaffToTask(Staff staff, Task task) {
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM staff_task WHERE StaffId=? AND TaskId=?");
            preparedStatement.setString(1, staff.getStaffId());
            preparedStatement.setString(2, task.getTaskId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
            return -1; //删除失败
        }finally {
            closeProcess(connection,resultSet,preparedStatement);
        }
        return 1;
    }

    //查找
    public ArrayList<StaffTask> searchStaffOrTask(Staff staff, Task task) {
        ArrayList<StaffTask> staffTasks = new ArrayList<StaffTask>();
        try {
            connection = dataSource.getConnection();
            if (staff.getStaffId() == null && task == null) {
                return new ArrayList<StaffTask>();
            } else if (staff.getStaffId() != null && task.getTaskId() == null) {
                preparedStatement = connection.prepareStatement("SELECT * FROM staff_task WHERE TaskId=?");
                preparedStatement.setString(1, staff.getStaffId());
            } else if (staff.getStaffId() == null && task.getTaskId() != null) {
                preparedStatement = connection.prepareStatement("SELECT * FROM staff_task WHERE TaskId=?");
                preparedStatement.setString(1, task.getTaskId());
            } else {
                preparedStatement = connection.prepareStatement("SELECT * FROM staff_task WHERE StaffId=? AND TaskId=?");
                preparedStatement.setString(1, staff.getStaffId());
                preparedStatement.setString(2, task.getTaskId());
            }

            resultSet = preparedStatement.executeQuery();
            int countOfResult = 0;

            while (resultSet.next()) {
                StaffTask newStaffTask = new StaffTask();
                newStaffTask.setStaffId(resultSet.getString(1));
                newStaffTask.setTaskId(resultSet.getString(2));
                staffTasks.add(newStaffTask);
                countOfResult++;
            }
            if (countOfResult == 0) {
                return new ArrayList<StaffTask>();
            }


        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        } finally {
            closeProcess(connection, resultSet, preparedStatement);
        }
        return staffTasks;
    }

    //查找(不在项目里的员工)
    public ArrayList<Staff>  searchStaffNoInDepartment(Task task){
        ArrayList<Staff> staffs=new ArrayList<Staff>();
        try{
            String sql="SELECT * FROM staff WHERE StaffId NOT IN(SELECT StaffId FROM staff_task WHERE TaskId=? )";
            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,task.getTaskId());
            resultSet=preparedStatement.executeQuery();
            int countOfResult=0;

            while(resultSet.next()){
                Staff newStaff=new Staff();
                newStaff.setStaffId(resultSet.getString(1));
                newStaff.setStaffName(resultSet.getString(2));
                newStaff.setStaffPhone(resultSet.getString(3));
                newStaff.setStaffFileID(resultSet.getString(4));
                newStaff.setStaffPassword(resultSet.getString(5));
                staffs.add(newStaff);
                countOfResult++;
            }
            if(countOfResult==0){
                return new ArrayList<Staff>();
            }



        }catch (SQLException e){
            System.out.println(e.toString());
            return  null;
        }finally {
            closeProcess(connection,resultSet,preparedStatement);
        }
        return staffs;
    }

    //查找(在项目里的员工)
    public ArrayList<Staff>  searchStaffInDepartment(Task task){
        ArrayList<Staff> staffs=new ArrayList<Staff>();
        try{
            String sql="SELECT * FROM staff WHERE StaffId IN(SELECT StaffId FROM staff_task WHERE TaskId=? )";
            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,task.getTaskId());
            resultSet=preparedStatement.executeQuery();
            int countOfResult=0;

            while(resultSet.next()){
                Staff newStaff=new Staff();
                newStaff.setStaffId(resultSet.getString(1));
                newStaff.setStaffName(resultSet.getString(2));
                newStaff.setStaffPhone(resultSet.getString(3));
                newStaff.setStaffFileID(resultSet.getString(4));
                newStaff.setStaffPassword(resultSet.getString(5));
                staffs.add(newStaff);
                countOfResult++;
            }
            if(countOfResult==0){
                return new ArrayList<Staff>();
            }



        }catch (SQLException e){
            System.out.println(e.toString());
            return  null;
        }finally {
            closeProcess(connection,resultSet,preparedStatement);
        }
        return staffs;
    }
    //查找(员工拥有的所有任务)
    public ArrayList<Task>  searchTaskForStaff(Staff staff){
        ArrayList<Task> tasks=new ArrayList<Task>();
        try{
            String sql="SELECT * FROM  task WHERE TaskId IN(SELECT TaskId FROM staff_task WHERE StaffId=? )";
            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,staff.getStaffId());
            resultSet=preparedStatement.executeQuery();
            int countOfResult=0;

            while(resultSet.next()){
                Task newTask=new Task();
                newTask.setTaskId(resultSet.getString(1));
                newTask.setTaskName(resultSet.getString(2));
                newTask.setTaskRemark(resultSet.getString(3));
                newTask.setTaskStartDate(resultSet.getString(4));
                newTask.setTaskEndDate(resultSet.getString(5));
                countOfResult++;
                tasks.add(newTask);
            }
            if(countOfResult==0){
                return new ArrayList<Task>();
            }



        }catch (SQLException e){
            System.out.println(e.toString());
            return  null;
        }finally {
            closeProcess(connection,resultSet,preparedStatement);
        }
        return tasks;
    }
    //包装了关闭函数，用于关闭数据库相关的连接
    public int closeProcess(Connection connection, ResultSet resultSet, PreparedStatement preparedStatement) {
        int flag = 1;
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
                flag = 0;
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
                flag = 0;
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return flag;
    }
}
