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

         String URL ="jdbc:mysql://voghost-server.mysql.rds.aliyuncs.com:3306/business_management?useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
         String URL1 ="jdbc:mysql://127.0.0.1:3306/bsm?useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";

         String userName1="user_bm";
         String password1="Lf@1141776830";

        String userName2="localTest";
        String password2="Lf1141776830";

        ((BasicDataSource)dataSource).setDriverClassName("com.mysql.cj.jdbc.Driver");
        ((BasicDataSource)dataSource).setUrl(URL1);
        ((BasicDataSource)dataSource).setUsername(userName2);
        ((BasicDataSource)dataSource).setPassword(password2);

    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
