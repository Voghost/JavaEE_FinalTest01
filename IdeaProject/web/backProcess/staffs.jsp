<%@ page import="com.Model.Entity.Staff" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.Model.function.StaffProcess" %>
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
    StaffProcess staffProcess = new StaffProcess();
    ArrayList<Staff> staffs = staffProcess.getAllStaff();
%>

<!-- MainForm -->
<div id="MainForm">
    <div class="form_boxA">
        <h2>员工</h2>
        <table cellpadding="0" cellspacing="0">
            <tr>
                <th>序号</th>
                <th>员工编号</th>
                <th>员工姓名</th>
                <th>员工电话</th>
                <th>员工所属部门数量</th>
                <th>管理</th>
            </tr>

            <%
                System.out.println(staffs.size());
                for (int i = 0; i < staffs.size(); i++) {
            %>
            <tr>
                <td><%out.println(i+1);%></td>
                <td><%out.println(staffs.get(i).getStaffId());%></td>
                <td><%out.println(staffs.get(i).getStaffName());%></td>
                <td><%out.println(staffs.get(i).getStaffPhone());%></td>
                <td><%out.println(staffProcess.getNumOfDepartment(staffs.get(i)));%></td>
                <form action="../deleteEntityServlet" method="post">
                    <input type="hidden" name="entityType" value="staff"/>
                    <input type="hidden" name="deleteSection" value="<%out.print(staffs.get(i).getStaffId());%>"/>
                    <td><input type="submit" value="删除" onClick="return confirm('删除后将无法恢复,确定要删除?')" ></td>
                </form>
            </tr>
            <%
                }
            %>
        </table>
        <p class="msg">共找到<%out.println(staffs.size());%>条记录，当前显示从第1条至第10条</p>
    </div>
</div>
<!-- /MainForm -->

</body>
</html>
