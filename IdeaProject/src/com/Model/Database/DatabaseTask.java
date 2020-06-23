package com.Model.Database;

import com.Model.Entity.Task;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Edgar Liu
 */

public class DatabaseTask{
    public int insertTask(Task task){
        DataBean dataBean=new DataBean();
        DataSource dataSource=dataBean.getDataSource();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String maxTaskId="S00001";
        String sqlSearch="SELECT MAX(TaskId) AS maxID FROM Task";
        String sqlInsert="INSERT INTO Task(TaskId,TaskName,TaskRemark,TaskStartDate,TaskEndDate) VALUES(?,?,?,?,?)";

        try{
            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement(sqlSearch);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){

                 maxTaskId=resultSet.getString("maxId");
                if(maxTaskId==null){
                    maxTaskId="T00001";
                }else {
                    int tmp = Integer.parseInt(maxTaskId.substring(maxTaskId.length() - 5));
                    tmp++;
                    maxTaskId = "S" + String.format("%05d", tmp);
                }
            }
            preparedStatement=connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1,maxTaskId);
            preparedStatement.setString(2,task.getTaskName());
            preparedStatement.setString(3,task.getTaskRemark());
            preparedStatement.setString(4,task.getTaskStartDate());
            preparedStatement.setString(5,task.getTaskEndDate());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.toString());
        }
        return 1;
    }


}
