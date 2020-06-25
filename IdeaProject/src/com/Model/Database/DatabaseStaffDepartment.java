package com.Model.Database;

import com.Model.Entity.Department;
import com.Model.Entity.Staff;
import com.Model.Entity.StaffDepartment;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Edgar Liu
 */
public class DatabaseStaffDepartment {
    DataBean dataBean = new DataBean();
    DataSource dataSource = dataBean.getDataSource();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

//建立员工和部门联系
    public int connectStaffToDepartment(Staff staff, Department department){
        try{
            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement("INSERT INTO staff_department(StaffId,DepartmentId) VALUES(?,?)");
            preparedStatement.setString(1,staff.getStaffId());
            preparedStatement.setString(2,department.getDepartmentId());
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.toString());
            return -1; //-1 插入失败
        }
        return 1;
    }

//删除员工和部门联系
    public int deleteStaffToDepartment(Staff staff,Department department){
        try{
            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement("DELETE FROM staff_department WHERE StaffId=? AND DepartmentId=?");
            preparedStatement.setString(1,staff.getStaffId());
            preparedStatement.setString(2,department.getDepartmentId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.toString());
            return -1; //删除失败
        }
        return 1;
    }

    //查找
    public ArrayList<StaffDepartment>  searchStaffOrDepartment(Staff staff,Department department){
        ArrayList<StaffDepartment> staffDepartments=new ArrayList<StaffDepartment>();
        try{
            connection=dataSource.getConnection();
            if(staff.getStaffId()==null&&department==null){
                return new ArrayList<StaffDepartment>();
            }else if(staff.getStaffId()!=null&&department.getDepartmentId()==null){
                preparedStatement=connection.prepareStatement("SELECT * FROM staff_department WHERE StaffId=?");
                preparedStatement.setString(1,staff.getStaffId());
            }else if(staff.getStaffId()==null&&department.getDepartmentId()!=null){
                preparedStatement=connection.prepareStatement("SELECT * FROM staff_department WHERE DepartmentId=?");
                preparedStatement.setString(1,department.getDepartmentId());
            }else{
                preparedStatement=connection.prepareStatement("SELECT * FROM staff_department WHERE StaffId=? AND DepartmentId=?");
                preparedStatement.setString(1,staff.getStaffId());
                preparedStatement.setString(2,department.getDepartmentId());
            }

            resultSet=preparedStatement.executeQuery();
            int countOfResult=0;

            while(resultSet.next()){
                StaffDepartment newStaffDepartment=new StaffDepartment();
                newStaffDepartment.setStaffId(resultSet.getString(1));
                newStaffDepartment.setDepartmentId(resultSet.getString(2));
                staffDepartments.add(newStaffDepartment);
                countOfResult++;
            }
            if(countOfResult==0){
                return new ArrayList<StaffDepartment>();
            }



        }catch (SQLException e){
            System.out.println(e.toString());
            return  null;
        }finally {
            closeProcess(connection,resultSet,preparedStatement);
        }
        return staffDepartments;
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
