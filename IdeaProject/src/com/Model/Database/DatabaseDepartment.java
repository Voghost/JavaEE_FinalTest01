package com.Model.Database

import com.Model.Enity.Department;

import javax.sql.Database
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Result;
improt java.sql.SQLException;

public class DatabaseDepartment(
    public int insertDepartment(Department department){
        DataBean dataBean=new DataBean();
        DataSource dataSource=dataBean.getDataSource();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String maxDepartmentId="D00001";
        String sqlSearch="SELECT MAX(DepartmentId)AS maxID FROM department";
        String sqlInsert="INSERT INTO department(DepartmentId,DepartmentName,DepartmentAddress)VALUES(?,?,?)";

        try{
            connection=dataSource.getConnection();
            preparedStatement=connection.preparedStatement(sqlSearch);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                maxDepartmentId=resultSet.getString("maxID");
                if(maxDepartmentId==null){
                    maxDepartmentId="D00001";
                }else{
                    int tmp=Integer.parseInt(maxDepartmentId.substring(maxDepartmentId,length()-5));
                    tmp++;
                    maxDepartmentId="D"+String.format("%05d",tmp);
                }
            }
            preparedStatement=connection.preparedStatement(sqlInsert);
            preparedStatement=setString(1,maxDepartmentId);
            preparedStatement=setString(2,department.getDepartmentName());
            preparedStatement=setString(3,department.getDepartmentAddress());
            preparedStatement.executeUpdate();
        }catch(SQLException){
            System.out.println(e.toString());
        }
        return 1;
    }
)