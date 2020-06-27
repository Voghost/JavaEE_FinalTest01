<%@ page import="com.Model.function.DepartmentProcess" %>
<%@ page import="com.Model.Entity.Department" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.Model.Database.DatabaseDepartment" %>
<%@ page import="com.Model.function.SessionProcess" %>
<%@ page import="com.Model.Database.DatabaseStaffDepartment" %>
<%@ page import="com.Model.Entity.Staff" %>
<%@ page import="com.Model.Database.DatabaseStaffTask" %>
<%@ page import="com.Model.Entity.Task" %>
<%@ page import="com.Model.function.TaskProcess" %><%--
  Created by IntelliJ IDEA.
  User: voghost
  Date: 2020/6/27
  Time: 上午9:57
  To change this template use File | Settings | File Templates.
--%>
<%
    SessionProcess sessionProcess=new SessionProcess(request,response);
    if(!sessionProcess.hasSession()){
        response.sendRedirect("../login.jsp");
        return ;
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="generator" content=""/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
    <link href="css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print"/>
    <link href="css/print.css" rel="stylesheet" type="text/css" media="print"/>
    <script src="js/jquery-1.10.1.min.js"></script>
    <script src="js/side.js" type="text/javascript"></script>

    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <![endif]-->
</head>
<body>

<!-- MainForm -->
<div id="MainForm">
    <div class="form_boxA">
        <h2>你的所有任务</h2>
        <table cellpadding="0" cellspacing="0">
            <%
            %>
            <tr>
                <th>序号</th>
                <th>任务编号</th>
                <th>任务名称</th>
                <th>任务描述</th>
                <th>任务起始时间</th>
                <th>任务终止时间</th>
            </tr>

            <%
                DatabaseStaffTask databaseStaffTask=new DatabaseStaffTask();
                Staff staff=new Staff(sessionProcess.getUserName(),null,null,null,null);
                ArrayList<Task> tasks=databaseStaffTask.searchTaskForStaff(staff);



                for (int i = 0; i <tasks.size(); i++) {
            %>
            <tr>
                <td><%out.println(i + 1);%></td>
                <td><%out.println(tasks.get(i).getTaskId());%></td>
                <td><%out.println(tasks.get(i).getTaskName());%></td>
                <td><%out.println(tasks.get(i).getTaskRemark());%></td>
                <td><%out.println(tasks.get(i).getTaskStartDate());%></td>
                <td><%out.println(tasks.get(i).getTaskEndDate());%></td>
            </tr>
            <%
                }
            %>
        </table>
        <p class="msg">共找到<%out.println(tasks.size());%>条记录</p>
    </div>
</div>


</body>
</html>
