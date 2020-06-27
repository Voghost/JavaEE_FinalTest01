package com.Model.Database;

import com.Model.Entity.Folder;
import com.Model.Entity.Project;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseProject {

    DataBean dataBean = new DataBean();
    DataSource dataSource = dataBean.getDataSource();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    //插入数据
    public int insertProject(Project project) {
        String maxProjectId = "F0000001";
        String sqlSearch = "SELECT MAX(ProjectId) AS maxID FROM project";
        String sqlInsert = "INSERT INTO project(ProjectId,ProjectName,ProjectPathId,ProjectRemark) VALUES(?,?,?,?)";

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sqlSearch);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                maxProjectId = resultSet.getString("maxId");
                if (maxProjectId == null) {
                    maxProjectId = "P00000001";
                } else {
                    int tmp = Integer.parseInt(maxProjectId.substring(maxProjectId.length() - 8));
                    tmp++;
                    maxProjectId = "P" + String.format("%08d", tmp);
                }
            }
            preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, maxProjectId);
            preparedStatement.setString(2, project.getProjectName());
            preparedStatement.setString(3, project.getProjectPathId());
            preparedStatement.setString(4, project.getProjectRemark());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally {
            closeProcess(connection,resultSet,preparedStatement);
        }
        return 1;
    }

    //修改数据
    public int updateProject(Project project){
        try{
            connection=dataSource.getConnection();
            if(project.getProjectName()!=null){
                preparedStatement=connection.prepareStatement("UPDATE project SET ProjectName=? WHERE ProjectId=?");
                preparedStatement.setString(1,project.getProjectName());
                preparedStatement.setString(2,project.getProjectId());
                preparedStatement.executeUpdate();

            }
            if(project.getProjectPathId()!=null){
                preparedStatement=connection.prepareStatement("UPDATE project SET ProjectPathId=? WHERE ProjectId=?");
                preparedStatement.setString(1,project.getProjectPathId());
                preparedStatement.setString(2,project.getProjectId());
                preparedStatement.executeUpdate();
            }

            if(project.getProjectRemark()!=null){
                preparedStatement=connection.prepareStatement("UPDATE project SET ProjectRemark=? WHERE ProjectId=?");
                preparedStatement.setString(1,project.getProjectRemark());
                preparedStatement.setString(2,project.getProjectId());
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
    public int deleteProject(Project project){
        try{
            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement("delete from project where ProjectId=?");
            preparedStatement.setString(1,project.getProjectId());
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.toString());
            return 0;
        }finally{
            closeProcess(connection,resultSet,preparedStatement);
        }
        return 1;
    }

    // 查找数据
    public ArrayList<Project> searchProject(String key, int paramNo){
        ArrayList<Project> projects=new ArrayList<Project>();
        String tempElement;
        if(paramNo==1){
            tempElement="ProjectId";
        }else if(paramNo==2){
            tempElement="ProjectName";
        }else if(paramNo==3){
            tempElement="ProjectPathId";
        }else {
            System.out.println("ERROR 参数错误");
            return null;
        }

        try{

            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement("select * from project where "+tempElement+"=?");
            preparedStatement.setString(1,key);
            resultSet=preparedStatement.executeQuery();
            String tmp;
            int countOfResult=0;
            while(resultSet.next()){
                Project newproject=new Project();
                if((tmp=resultSet.getString(1))!=null){
                    newproject.setProjectId(tmp);
                }
                if((tmp=resultSet.getString(2))!=null){
                    newproject.setProjectName(tmp);
                }
                if((tmp=resultSet.getString(3))!=null){
                    newproject.setProjectPathId(tmp);
                }

                projects.add(newproject);
                countOfResult++;
            }
            if(countOfResult==0){
                return new ArrayList<Project>();
            }

        }catch(SQLException e){
            System.out.println(e.toString());
        }finally {
            closeProcess(connection,resultSet,preparedStatement);
        }
        return projects;
    }

    //查找数据(通过对象)
    public ArrayList<Project> searchProject(Project project){
        ArrayList<Project> projects=new ArrayList<Project>();
        String sql="SELECT * FROM project WHERE 1=1 ";
        int countOfConditions=0;
        String conditions[] =new String[8];

        if(project.getProjectId()!=null){
            sql=sql+" AND ProjectId=?";
            conditions[countOfConditions]=project.getProjectId();
            countOfConditions++;

        }
        if(project.getProjectName()!=null) {
            sql=sql+" AND ProjectName=?";
            conditions[countOfConditions]=project.getProjectName();
            countOfConditions++;
        }
        if(project.getProjectPathId()!=null){
            sql=sql+" AND ProjectPathId=?";
            conditions[countOfConditions]=project.getProjectPathId();
            countOfConditions++;
        }
        if(project.getProjectRemark()!=null){
            sql=sql+" AND ProjectRemark=?";
            conditions[countOfConditions]=project.getProjectRemark();
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
            int countOfResult=0;
            while(resultSet.next()){
                Project newProject=new Project();

                if((tmp=resultSet.getString(1))!=null){
                    newProject.setProjectId(tmp);
                }
                if((tmp=resultSet.getString(2))!=null){
                    newProject.setProjectName(tmp);
                }
                if((tmp=resultSet.getString(3))!=null){
                    newProject.setProjectPathId(tmp);
                }
                if((tmp=resultSet.getString(4))!=null){
                    newProject.setProjectRemark(tmp);
                }

                projects.add(newProject);
                countOfResult++;
            }
            if(countOfResult==0){
                return new ArrayList<Project>();
            }
        }catch (SQLException e){
            System.out.println(e.toString());
            return null;
        }finally {
            closeProcess(connection,resultSet,preparedStatement);
        }
        return projects;
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
