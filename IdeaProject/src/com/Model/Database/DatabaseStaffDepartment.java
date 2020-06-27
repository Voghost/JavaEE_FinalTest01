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
        }finally {
            closeProcess(connection,resultSet,preparedStatement);
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
        }finally {
            closeProcess(connection,resultSet,preparedStatement);
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
    //查找(不在项目里的员工)
    public ArrayList<Staff>  searchStaffNoInDepartment(Department department){
        ArrayList<Staff> staffs=new ArrayList<Staff>();
        try{
            String sql="SELECT * FROM staff WHERE StaffId NOT IN(SELECT StaffId FROM staff_department WHERE DepartmentId=? )";
            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,department.getDepartmentId());
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
    public ArrayList<Staff>  searchStaffInDepartment(Department department){
        ArrayList<Staff> staffs=new ArrayList<Staff>();
        try{
            String sql="SELECT * FROM staff WHERE StaffId IN(SELECT StaffId FROM staff_department WHERE DepartmentId=? )";
            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,department.getDepartmentId());
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

    //查找(员工拥有的所有部门)
    public ArrayList<Department>  searchDepartmentsForStaff(Staff staff){
        ArrayList<Department> departments =new ArrayList<Department>();
        try{
            String sql="SELECT * FROM  department WHERE DepartmentId IN(SELECT DepartmentId FROM staff_department WHERE StaffId=? )";
            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,staff.getStaffId());
            resultSet=preparedStatement.executeQuery();
            int countOfResult=0;

            while(resultSet.next()){
                Department newDepartment=new Department();
                newDepartment.setDepartmentId(resultSet.getString(1));
                newDepartment.setDepartmentName(resultSet.getString(2));
                newDepartment.setDepartmentAddress(resultSet.getString(3));
                departments.add(newDepartment);
                countOfResult++;
            }
            System.out.println("countOfResult : "+countOfResult);
            if(countOfResult==0){
                return new ArrayList<Department>();
            }



        }catch (SQLException e){
            System.out.println(e.toString());
            return  null;
        }finally {
            closeProcess(connection,resultSet,preparedStatement);
        }
        return departments;
    }

    //是否行政部门
    public boolean isManagerDepartment(Staff staff){
        boolean flag=false;
        try{
            String sql="SELECT * FROM staff_department where StaffId=? AND departmentId=? ";
            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,staff.getStaffId());
            preparedStatement.setString(2,"D001");
            resultSet=preparedStatement.executeQuery();

            if(resultSet.next()){
                flag=true;
            }
        }catch (SQLException e){
            System.out.println(e.toString());
        }finally {
            closeProcess(connection,resultSet,preparedStatement);
        }
        return flag;
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
