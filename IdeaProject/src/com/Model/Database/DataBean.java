package com.Model.Database;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

/**
 * Created by Edgar Liu
 */
public class DataBean {
    DataSource dataSource;
    public DataBean(){
        dataSource=new BasicDataSource();
        ((BasicDataSource)dataSource).setDriverClassName("com.mysql.cj.jdbc.Driver");
        ((BasicDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/Sample?useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true");
        ((BasicDataSource)dataSource).setUsername("user_bm");
        ((BasicDataSource)dataSource).setPassword("Lf@1141776830");
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
