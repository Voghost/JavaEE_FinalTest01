package com.Model.Database;

import com.Model.Entity.Project;
import com.Model.Entity.Staff;
import com.Model.Entity.StaffProject;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Edgar Liu
 */
public class DatabaseStaffProject {
    DataBean dataBean = new DataBean();
    DataSource dataSource = dataBean.getDataSource();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    //建立员工和项目联系
    public int connectStaffToProject(Staff staff, Project project){
        try{
            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement("INSERT INTO staff_project(StaffId,ProjectId) VALUES(?,?)");
            preparedStatement.setString(1,staff.getStaffId());
            preparedStatement.setString(2,project.getProjectId());
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.toString());
            return -1; //-1 插入失败
        }finally {
            closeProcess(connection,resultSet,preparedStatement);
        }
        return 1;
    }

    //删除员工和项目联系
    public int deleteStaffToProject(Staff staff,Project project){
        try{
            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement("DELETE FROM staff_project WHERE StaffId=? AND ProjectId=?");
            preparedStatement.setString(1,staff.getStaffId());
            preparedStatement.setString(2,project.getProjectId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.toString());
            return -1; //删除失败
        }finally {
            closeProcess(connection,resultSet,preparedStatement);
        }
        return 1;
    }

    //查找
    public ArrayList<StaffProject>  searchStaffOrProject(Staff staff,Project project){
        ArrayList<StaffProject> staffProjects=new ArrayList<StaffProject>();
        try{
            connection=dataSource.getConnection();
            if(staff.getStaffId()==null&&project==null){
                return new ArrayList<StaffProject>();
            }else if(staff.getStaffId()!=null&&project.getProjectId()==null){
                preparedStatement=connection.prepareStatement("SELECT * FROM staff_project WHERE StaffId=?");
                preparedStatement.setString(1,staff.getStaffId());
            }else if(staff.getStaffId()==null&&project.getProjectId()!=null){
                preparedStatement=connection.prepareStatement("SELECT * FROM staff_project WHERE ProjectId=?");
                preparedStatement.setString(1,project.getProjectId());
            }else{
                preparedStatement=connection.prepareStatement("SELECT * FROM staff_project WHERE StaffId=? AND ProjectId=?");
                preparedStatement.setString(1,staff.getStaffId());
                preparedStatement.setString(2,project.getProjectId());
            }

            resultSet=preparedStatement.executeQuery();
            int countOfResult=0;

            while(resultSet.next()){
                StaffProject newStaffProject=new StaffProject();
                newStaffProject.setStaffId(resultSet.getString(1));
                newStaffProject.setProjectId(resultSet.getString(2));
                staffProjects.add(newStaffProject);
                countOfResult++;
            }
            if(countOfResult==0){
                return new ArrayList<StaffProject>();
            }



        }catch (SQLException e){
            System.out.println(e.toString());
            return  null;
        }finally {
            closeProcess(connection,resultSet,preparedStatement);
        }
        return staffProjects;
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
