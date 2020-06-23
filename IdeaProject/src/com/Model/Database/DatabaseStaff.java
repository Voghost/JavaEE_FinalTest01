package com.Model.Database;

import com.Model.Entity.Staff;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Edgar Liu
 */

public class DatabaseStaff{
    public int insertStaff(Staff staff){
        DataBean dataBean=new DataBean();
        DataSource dataSource=dataBean.getDataSource();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String maxStaffId="S00001";
        String sqlSearch="SELECT MAX(StaffId) AS maxID FROM staff";
        String sqlInsert="INSERT INTO staff(StaffId,StaffName,StaffPhone,StaffPassword) VALUES(?,?,?,?)";

        try{
            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement(sqlSearch);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){

                 maxStaffId=resultSet.getString("maxId");
                if(maxStaffId==null){
                    maxStaffId="S00001";
                }else {
                    int tmp = Integer.parseInt(maxStaffId.substring(maxStaffId.length() - 5));
                    tmp++;
                    maxStaffId = "S" + String.format("%05d", tmp);
                }
            }
            preparedStatement=connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1,maxStaffId);
            preparedStatement.setString(2,staff.getStaffName());
            preparedStatement.setString(3,staff.getStaffPhone());
            preparedStatement.setString(4,staff.getStaffPassword());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.toString());
        }
        return 1;
    }


}
