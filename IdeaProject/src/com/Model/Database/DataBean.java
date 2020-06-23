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
        ((BasicDataSource)dataSource).setUrl("jdbc:mysql://voghost-server.mysql.rds.aliyuncs.com:3306/business_management?useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true");
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
