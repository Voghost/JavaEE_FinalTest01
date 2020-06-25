package com.Model.Database;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Edgar Liu
 */
public class DatabaseStaffDepartment {
    DataBean dataBean = new DataBean();
    DataSource dataSource = dataBean.getDataSource();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

}
