package com.Model.Database;

import com.Model.Entity.Folder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseFolder{
    public int insertFolder(Folder folder){
        DataBean dataBean=new DataBean();
        DataSource dataSource=dataBean.getDataSource();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String maxFolderId="F00001";
        String sqlSearch="SELECT MAX(FolderId) AS maxID FROM Folder";
        String sqlInsert="INSERT INTO folder(FolderId,FolderPath,FolderRemark) VALUES(?,?,?)";

        try{
            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement(sqlSearch);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){

                 maxFolderId=resultSet.getString("maxId");
                if(maxFolderId==null){
                    maxFolderId="F00001";
                }else {
                    int tmp = Integer.parseInt(maxFolderId.substring(maxFolderId.length() - 5));
                    tmp++;
                    maxFolderId = "F" + String.format("%05d", tmp);
                }
            }
            preparedStatement=connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1,maxFolderId);
            preparedStatement.setString(2,staff.getFolderPath());
            preparedStatement.setString(3,staff.getFolderRemark());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.toString());
        }
        return 1;
    }


}
