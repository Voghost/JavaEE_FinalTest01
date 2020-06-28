<%@ page import="com.Model.function.ProjectProcess" %>
<%@ page import="com.Model.Entity.Project" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.Model.Database.DatabaseProject" %>
<%@ page import="com.Model.function.SessionProcess" %>
<%@ page import="com.Model.Database.DatabaseStaffProject" %>
<%@ page import="com.Model.Entity.Staff" %>
<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="com.Model.Database.DatabaseStaff" %>
<%@ page import="com.Model.Entity.Folder" %>
<%@ page import="com.Model.Database.DatabaseFolder" %><%--
  Created by IntelliJ IDEA.
  User: voghost
  Date: 2020/6/27
  Time: 上午9:57
  To change this template use File | Settings | File Templates.
--%>
<%
    SessionProcess sessionProcess = new SessionProcess(request, response);
    if (!sessionProcess.hasSession()) {
        response.sendRedirect("../login.jsp");
        return;
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
                Staff staff = new Staff();
                Folder folder;
                staff.setStaffId(sessionProcess.getUserName());
                DatabaseStaff databaseStaff = new DatabaseStaff();
                DatabaseFolder databaseFolder = new DatabaseFolder();
                DatabaseStaffProject databaseStaffProject = new DatabaseStaffProject();

                ArrayList<Project> projects = databaseStaffProject.searchProjectsForStaff(staff);

                ArrayList<Staff> staffs = databaseStaff.searchStaff(staff);
                ArrayList<Folder> folders = databaseFolder.searchFolder(new Folder(staffs.get(0).getStaffFileID(), null, null));

            %>
            <tr>
                <th>类型</th>
                <th>文件编号</th>
                <th>文件路径</th>
                <th></th>
            </tr>

            <tr>
                <td>私有文件夹</td>
                <td><%out.print(folders.get(0).getFolderId());%></td>
                <td><%out.print(folders.get(0).getFolderPath());%></td>
            </tr>
                <%
                    for (int i = 0; (i < projects.size())&&(projects.get(i).getProjectPathId()!=null); i++) {
                        folder=databaseFolder.searchFolder(projects.get(i).getProjectPathId());

                %>
            <tr>
                <td>公共项目文件夹</td>
                <td><%out.print(folder.getFolderId());%></td>
                <td><%out.print(folder.getFolderPath());%></td>
            </tr>
                <%
                }
            %>

            <tr>

            </tr>
        </table>
        <p class="msg">共找到<%out.println(projects.size()+1);%>条记录</p>
    </div>
</div>


</body>
</html>
