<%@ page import="com.Model.Entity.Department" %>
<%@ page import="com.Model.function.DepartmentProcess" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: voghost
  Date: 2020/6/26
  Time: 上午9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<%
    DepartmentProcess departmentProcess = new DepartmentProcess();
    ArrayList<Department> departments = departmentProcess.getAllDepartment();
%>

<!-- MainForm -->
<div id="MainForm">
    <div class="form_boxA">
        <h2>公司所有部门</h2>
        <table cellpadding="0" cellspacing="0">
            <tr>
                <th>序号</th>
                <th>部门编号</th>
                <th>部门名称</th>
                <th>部门地址</th>
                <th>部门人数</th>
            </tr>

            <%
                System.out.println(departments.size());
                for (int i = 0; i < departments.size(); i++) {
            %>
            <tr>
                <td><%out.println(i+1);%></td>
                <td><%out.println(departments.get(i).getDepartmentId());%></td>
                <td><%out.println(departments.get(i).getDepartmentName());%></td>
                <td><%out.println(departments.get(i).getDepartmentAddress());%></td>
                <td><%out.println(departmentProcess.getNumOfStaff(departments.get(i)));%></td>
            </tr>
            <%
                }
            %>
        </table>
        <p class="msg">共找到<%out.println(departments.size());%>条记录，当前显示从第1条至第10条</p>
    </div>
</div>
<!-- /MainForm -->

</body>
</html>
