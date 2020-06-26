package com.Model.Database;

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
