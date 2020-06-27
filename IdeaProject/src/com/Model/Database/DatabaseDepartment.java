package com.Model.Database;


import com.Model.Entity.Department;
import com.Model.Entity.Staff;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseDepartment {
    DataBean dataBean = new DataBean();
    DataSource dataSource = dataBean.getDataSource();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    //插入数据
    public int insertDepartment(Department department) {

        String maxDepartmentId = "D00001";
        String sqlSearch = "SELECT MAX(DepartmentId)AS maxID FROM department";
        String sqlInsert = "INSERT INTO department(DepartmentId,DepartmentName,DepartmentAddress)VALUES(?,?,?)";

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sqlSearch);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                maxDepartmentId = resultSet.getString("maxID");
                if (maxDepartmentId == null) {
                    maxDepartmentId = "D001";
                } else {
                    int tmp = Integer.parseInt(maxDepartmentId.substring(maxDepartmentId.length() - 3));
                    tmp++;
                    maxDepartmentId = "D" + String.format("%03d", tmp);
                }
            }
            preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, maxDepartmentId);
            preparedStatement.setString(2, department.getDepartmentName());
            preparedStatement.setString(3, department.getDepartmentAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally {
            closeProcess(connection,resultSet,preparedStatement);
        }
        return 1;
    }

    //修改数据
    public int updateDepartment(Department department) {
        try {
            connection = dataSource.getConnection();
            if (department.getDepartmentName() != null) {
                preparedStatement = connection.prepareStatement("UPDATE department SET departmentName=? WHERE departmentId=?");
                preparedStatement.setString(1, department.getDepartmentName());
                preparedStatement.setString(2, department.getDepartmentId());
                preparedStatement.executeUpdate();

            }
            if (department.getDepartmentId() != null) {
                preparedStatement = connection.prepareStatement("UPDATE department SET departmentAddress=? WHERE departmentId=?");
                preparedStatement.setString(1, department.getDepartmentAddress());
                preparedStatement.setString(2, department.getDepartmentId());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
            return 0;
        } finally {
            closeProcess(connection, resultSet, preparedStatement);
        }
        return 1;
    }

    //删除数据
    public int deleteDepartment(Department department) {
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement("delete from Department where departmentId=?");
            preparedStatement.setString(1, department.getDepartmentId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
            return 0;

        }finally {
            closeProcess(connection,resultSet,preparedStatement);
        }
        return 1;
    }

    //查找数据(通过参数)
    public ArrayList<Department> searchDepartment(String key, int paramNo){
        ArrayList<Department> departments=new ArrayList<Department>();
        String tempElement;
        if(paramNo==1){
            tempElement="DepartmentId";
        }else if(paramNo==2){
            tempElement="DepartmentName";
        }else  if(paramNo==3){
            tempElement="DepartmentAddress";
        }else {
            System.out.println("ERROR 参数错误");
            return null;
        }

        try{

            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement("select * from department where "+tempElement+"=?");
            preparedStatement.setString(1,key);
            resultSet=preparedStatement.executeQuery();
            String tmp;
            while(resultSet.next()){
                Department newDepartment=new Department();
                if((tmp=resultSet.getString(1))!=null){
                    newDepartment.setDepartmentId(tmp);
                }
                if((tmp=resultSet.getString(2))!=null){
                    newDepartment.setDepartmentName(tmp);
                }
                if((tmp=resultSet.getString(3))!=null){
                    newDepartment.setDepartmentAddress(tmp);
                }

                departments.add(newDepartment);
            }

        }catch(SQLException e){
            System.out.println(e.toString());
        }finally {
            closeProcess(connection,resultSet,preparedStatement);
        }
        return departments;
    }

    //查找数据（通过类名)
    public ArrayList<Department> searchDepartment(Department department){
        ArrayList<Department> departments=new ArrayList<Department>();
        String sql="SELECT * FROM department WHERE 1=1 ";
        String conditions[]=new String[8];
        int countOfConditions =0;
       if(department.getDepartmentId()!=null){
           sql=sql+" AND DepartmentId=? ";
           conditions[countOfConditions]=department.getDepartmentId();
           countOfConditions++;
       }
       if(department.getDepartmentName()!=null) {
           sql=sql+" AND DepartmentName =? ";
           conditions[countOfConditions]=department.getDepartmentName();
           countOfConditions++;
       }
       if(department.getDepartmentAddress()!=null){
           sql=sql+" AND DepartmentAdress=? ";
           conditions[countOfConditions]=department.getDepartmentAddress();
           countOfConditions++;
       }



       try{
           connection=dataSource.getConnection();
           preparedStatement=connection.prepareStatement(sql);
           for(int i=1;i<=countOfConditions;i++){
               preparedStatement.setString(i,conditions[i-1]);
           }
          resultSet= preparedStatement.executeQuery();
          String tmp;
           while(resultSet.next()){
               Department newDepartment=new Department();
               if((tmp=resultSet.getString(1))!=null){
                   newDepartment.setDepartmentId(tmp);
               }
               if((tmp=resultSet.getString(2))!=null){
                   newDepartment.setDepartmentName(tmp);
               }
               if((tmp=resultSet.getString(3))!=null){
                   newDepartment.setDepartmentAddress(tmp);
               }

               departments.add(newDepartment);
           }
       }catch (SQLException e){
           System.out.println(e.toString());
           return null;
       }finally {
           closeProcess(connection,resultSet,preparedStatement);
       }
        return departments;
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
