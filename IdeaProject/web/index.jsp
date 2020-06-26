<%@ page import="com.Model.Entity.Staff" %>
<%@ page import="com.Model.Database.DatabaseStaff" %>
<%@ page import="java.util.ArrayList" %><%--
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
      Staff staff=new Staff("S00001","员工1",null,null,null);
    DatabaseStaff databaseStaff=new DatabaseStaff();
    //databaseStaff.insertStaff(staff);

    ArrayList<Staff> staffs=databaseStaff.searchStaff(staff);
    System.out.println(staffs.size());
    for(int i=0;i<staffs.size();i++){
      System.out.println("staffId: "+staffs.get(i).getStaffId()+", StaffName: "+staffs.get(i).getStaffName());
    }


  %>
  </body>
</html>
