<%--
  Created by IntelliJ IDEA.
  User: voghost
  Date: 2020/6/22
  Time: 下午8:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    Class.forName("com.mysql.cj.jdbc.Driver");
    String DB_URL = "jdbc:mysql://voghost-server.mysql.rds.aliyuncs.com/business_management?useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
    java.sql.Connection connection = null;
    java.lang.String strConn;
    try {
      connection = java.sql.DriverManager.getConnection(DB_URL,"user_bm","Lf@1141776830");
  %>
  连接mysql数据库成功!
  <%
    } catch (java.sql.SQLException exception) {
      out.println(exception.toString());
    } finally {
      if (connection != null) connection.close();
    }

  %>
  </body>
</html>
