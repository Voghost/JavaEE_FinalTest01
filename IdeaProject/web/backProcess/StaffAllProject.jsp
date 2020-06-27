<%@ page import="com.Model.function.ProjectProcess" %>
<%@ page import="com.Model.Entity.Project" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.Model.Database.DatabaseProject" %>
<%@ page import="com.Model.function.SessionProcess" %>
<%@ page import="com.Model.Database.DatabaseStaffProject" %>
<%@ page import="com.Model.Entity.Staff" %><%--
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
        <h2>公司所有项目</h2>
        <table cellpadding="0" cellspacing="0">
            <%
            %>
            <tr>
                <th>序号</th>
                <th>项目编号</th>
                <th>项目名称</th>
                <th>项目描述</th>
                <th>  </th>
            </tr>

            <%
                DatabaseStaffProject databaseStaffProject=new DatabaseStaffProject();
                Staff staff=new Staff(sessionProcess.getUserName(),null,null,null,null);
                ArrayList<Project> projects=databaseStaffProject.searchProjectsForStaff(staff);

                ProjectProcess projectProcess=new ProjectProcess();



                System.out.println(projects.size());
                for (int i = 0; i < projects.size(); i++) {
            %>
            <tr>
                <td><%out.println(i + 1);%></td>
                <td><%out.println(projects.get(i).getProjectId());%></td>
                <td><%out.println(projects.get(i).getProjectName());%></td>
                <td><%out.println(projects.get(i).getProjectRemark());%></td>
            </tr>
            <%
                }
            %>
        </table>
        <p class="msg">共找到<%out.println(projects.size());%>条记录</p>
    </div>
</div>


</body>
</html>
