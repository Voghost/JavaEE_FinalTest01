package com.Model.Database;

import com.Model.Entity.Staff;
import com.Model.Entity.Task;

import java.sql.Date;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Edgar Liu
 */

public class DatabaseTask {

    DataBean dataBean = new DataBean();
    DataSource dataSource = dataBean.getDataSource();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    //插入数据
    public int insertTask(Task task) {
        String maxTaskId = "T00000001";
        String sqlSearch = "SELECT MAX(TaskId) AS maxID FROM Task";
        String sqlInsert = "INSERT INTO Task(TaskId,TaskName,TaskRemark,TaskStartDate,TaskEndDate) VALUES(?,?,?,?,?)";

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sqlSearch);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                maxTaskId = resultSet.getString("maxId");
                if (maxTaskId == null) {
                    maxTaskId = "T00000001";
                } else {
                    int tmp = Integer.parseInt(maxTaskId.substring(maxTaskId.length() - 8));
                    tmp++;
                    maxTaskId = "T" + String.format("%08d", tmp);
                }
            }
            preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, maxTaskId);
            preparedStatement.setString(2, task.getTaskName());
            preparedStatement.setString(3, task.getTaskRemark());
            preparedStatement.setString(4, task.getTaskStartDate());
            preparedStatement.setString(5, task.getTaskEndDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return 1;
    }

    //修改数据
    public int updateTask(Task task) {
        try {
            connection = dataSource.getConnection();
            if (task.getTaskName() != null) {
                preparedStatement = connection.prepareStatement("UPDATE task SET TaskName=? WHERE TaskId=?");
                preparedStatement.setString(1, task.getTaskName());
                preparedStatement.setString(2, task.getTaskId());
                preparedStatement.executeUpdate();

            }
            if (task.getTaskRemark() != null) {
                preparedStatement = connection.prepareStatement("UPDATE task SET TaskRemark=? WHERE TaskId=?");
                preparedStatement.setString(1, task.getTaskRemark());
                preparedStatement.setString(2, task.getTaskId());
                preparedStatement.executeUpdate();
            }

            if (task.getTaskStartDate() != null) {
                preparedStatement = connection.prepareStatement("UPDATE task SET TaskStartDate=? WHERE TaskId=?");
                SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
                try {
                    preparedStatement.setDate(1, new Date(sdf.parse(task.getTaskStartDate()).getTime()));
                } catch (ParseException e) {
                    System.out.println(e.toString());
                    System.out.println("日期格式错误");
                }
                preparedStatement.setString(2, task.getTaskId());


                preparedStatement.executeUpdate();
            }

            if (task.getTaskEndDate() != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
                preparedStatement = connection.prepareStatement("UPDATE task SET TaskEndDate=? WHERE TaskId=?");
                try {
                    preparedStatement.setDate(1, new Date(sdf.parse(task.getTaskEndDate()).getTime()));
                } catch (ParseException e) {
                    System.out.println(e.toString());
                    System.out.println("日期格式错误");
                }

                preparedStatement.setString(2, task.getTaskId());
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

    // 删除数据
    public int deleteTask(Task task) {
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement("delete from Task where TaskId=?");
            preparedStatement.setString(1, task.getTaskId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
            return 0;
        } finally {
            closeProcess(connection, resultSet, preparedStatement);
        }
        return 1;
    }

    // 查找数据
    public ArrayList<Task> searchTask(String key, int paramNo) {
        ArrayList<Task> tasks = new ArrayList<Task>();
        String tempElement;
        if (paramNo == 1) {
            tempElement = "TaskId";
        } else if (paramNo == 2) {
            tempElement = "TaskName";
        } else {
            System.out.println("ERROR 参数错误");
            return null;
        }

        try {

            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement("select * from task where " + tempElement + "=?");
            preparedStatement.setString(1, key);
            resultSet = preparedStatement.executeQuery();
            String tmp;
            int countOfResult = 0;
            while (resultSet.next()) {
                Task newtask = new Task();
                if ((tmp = resultSet.getString(1)) != null) {
                    newtask.setTaskId(tmp);
                }
                if ((tmp = resultSet.getString(2)) != null) {
                    newtask.setTaskName(tmp);
                }
                countOfResult++;
                tasks.add(newtask);
            }
            if (countOfResult == 0) {
                return new ArrayList<Task>();
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        } finally {
            closeProcess(connection, resultSet, preparedStatement);
        }
        return tasks;
    }

    //查找数据(通过对象)
    public ArrayList<Task> searchTask(Task task) {
        ArrayList<Task> tasks = new ArrayList<Task>();
        String sql = "SELECT * FROM  task WHERE 1=1";
        int countOfCondition = 0; //拥有条件的次数
        String[] condition = new String[8];

        if (task.getTaskId() != null) {
            sql = sql + " AND TaskId=?";
            condition[countOfCondition] = task.getTaskId();
            countOfCondition++;
        }
        if (task.getTaskName() != null) {
            sql = sql + " AND TaskName=?";
            condition[countOfCondition] = task.getTaskName();
            countOfCondition++;
        }

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 1; i <= countOfCondition; i++) {
                preparedStatement.setString(i, condition[i-1]);
            }
            resultSet = preparedStatement.executeQuery();
            String tmp;
            while (resultSet.next()) {
                Task newTask = new Task();

                if ((tmp = resultSet.getString(1)) != null) {
                    newTask.setTaskId(tmp);
                }
                if ((tmp = resultSet.getString(2)) != null) {
                    newTask.setTaskName(tmp);
                }
                tasks.add(newTask);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            return new ArrayList<Task>();
        } finally {
            closeProcess(connection, resultSet, preparedStatement);
        }
        return tasks;
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
