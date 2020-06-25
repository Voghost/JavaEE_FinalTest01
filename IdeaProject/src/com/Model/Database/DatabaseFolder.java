package com.Model.Database;

import com.Model.Entity.Folder;
import com.Model.Entity.Folder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseFolder {
    
    DataBean dataBean = new DataBean();
    DataSource dataSource = dataBean.getDataSource();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    //插入数据
    public int insertFolder(Folder folder) {
        String maxFolderId = "F00001";
        String sqlSearch = "SELECT MAX(FolderId) AS maxID FROM Folder";
        String sqlInsert = "INSERT INTO folder(FolderId,FolderPath,FolderRemark) VALUES(?,?,?)";

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sqlSearch);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                maxFolderId = resultSet.getString("maxId");
                if (maxFolderId == null) {
                    maxFolderId = "F00000001";
                } else {
                    int tmp = Integer.parseInt(maxFolderId.substring(maxFolderId.length() - 8));
                    tmp++;
                    maxFolderId = "F" + String.format("%08d", tmp);
                }
            }
            preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, maxFolderId);
            preparedStatement.setString(2, folder.getFolderPath());
            preparedStatement.setString(3, folder.getFolderRemark());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return 1;
    }

    //修改数据
    public int updateFolder(Folder folder){
        try{
            connection=dataSource.getConnection();
            if(folder.getFolderPath()!=null){
                preparedStatement=connection.prepareStatement("UPDATE folder SET FolderPath=? WHERE FolderId=?");
                preparedStatement.setString(1,folder.getFolderPath());
                preparedStatement.setString(2,folder.getFolderId());
                preparedStatement.executeUpdate();

            }
            if(folder.getFolderRemark()!=null){
                preparedStatement=connection.prepareStatement("UPDATE staff SET FolderRemark=? WHERE FolderId=?");
                preparedStatement.setString(1,folder.getFolderRemark());
                preparedStatement.setString(2,folder.getFolderId());
                preparedStatement.executeUpdate();
            }

        }catch (SQLException e){
            System.out.println(e.toString());
            return 0;
        }finally {
            closeProcess(connection,resultSet,preparedStatement);
        }
        return 1;
    }

    //删除数据
    public int deleteFolder(Folder folder){
        try{
            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement("delete from Folder where folderId=?");
            preparedStatement.setString(1,folder.getFolderId());
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.toString());
            return 0;
        }finally{
            closeProcess(connection,resultSet,preparedStatement);
        }
        return 1;
    }

    //修改数据
    public ArrayList<Folder> searchFolder(String key, int paramNo){
        ArrayList<Folder> folders=new ArrayList<Folder>();
        String tempElement;
        if(paramNo==1){
            tempElement="FolderId";
        }else if(paramNo==2){
            tempElement="FolderPath";
        }else {
            System.out.println("ERROR 参数错误");
            return null;
        }

        try{

            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement("select * from folder where "+tempElement+"=?");
            preparedStatement.setString(1,key);
            resultSet=preparedStatement.executeQuery();
            String tmp;
            while(resultSet.next()){
                Folder newfolder=new Folder();
                if((tmp=resultSet.getString(1))!=null){
                    newfolder.setFolderId(tmp);
                }
                if((tmp=resultSet.getString(2))!=null){
                    newfolder.setFolderPath(tmp);
                }


                folders.add(newfolder);
            }

        }catch(SQLException e){
            System.out.println(e.toString());
        }finally {
            closeProcess(connection,resultSet,preparedStatement);
        }
        return folders;
    }

    //包装了关闭函数，用于关闭数据库相关的连接
    public int closeProcess(Connection connection,ResultSet resultSet,PreparedStatement preparedStatement){
        int flag=1;
        if(preparedStatement!=null){
            try {
                preparedStatement.close();
            }catch (SQLException e){
                System.out.println(e.toString());
                flag=  0;
            }
        }
        if(resultSet!=null){
            try {
                resultSet.close();
            }catch (SQLException e){
                System.out.println(e.toString());
                flag=  0;
            }
        }
        if(connection!=null){
            try{
                connection.close();
            }catch (SQLException e){
                System.out.println(e.toString());
            }
        }
        return flag;
    }
}
