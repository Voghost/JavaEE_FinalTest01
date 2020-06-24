package com.Model.Database;

import com.Model.Entity.Project;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseProject{
    public int insertProject(Project project){
        DataBean dataBean=new DataBean();
        DataSource dataSource=dataBean.getDataSource();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String maxProjectId="F0000001";
        String sqlSearch="SELECT MAX(ProjectId) AS maxID FROM Project";
        String sqlInsert="INSERT INTO Project(ProjectId,ProjectName,ProjectRemark,ProjectStatus) VALUES(?,?,?,?)";

        try{
            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement(sqlSearch);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){

                 maxProjectId=resultSet.getString("maxId");
                if(maxProjectId==null){
                    maxProjectId="P0000001";
                }else {
                    int tmp = Integer.parseInt(maxProjectId.substring(maxProjectId.length() - 8));
                    tmp++;
                    maxProjectId = "P" + String.format("%08d", tmp);
                }
            }
            preparedStatement=connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1,maxProjectId);
            preparedStatement.setString(2,project.getProjectName());
            preparedStatement.setString(3,project.getProjectRemark());
            preparedStatement.setString(4,project.getProjectStatus());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.toString());
        }
        return 1;
    }


}
