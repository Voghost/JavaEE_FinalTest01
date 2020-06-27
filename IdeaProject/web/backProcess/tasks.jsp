<%@ page import="com.Model.Entity.Task" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.Model.function.TaskProcess" %>
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
    TaskProcess taskProcess = new TaskProcess();
    ArrayList<Task> tasks = taskProcess.getAllTask();
%>

<!-- MainForm -->
<div id="MainForm">
    <div class="form_boxA">
        <h2>任务</h2>
        <table cellpadding="0" cellspacing="0">
            <tr>
                <th>序号</th>
                <th>任务编号</th>
                <th>任务名称</th>
                <th>任务描述</th>
                <th>任务开始时间</th>
                <th>任务截止时间</th>
                <th>任务涉及人数</th>
                <th>管理</th>
            </tr>

            <%
                System.out.println(tasks.size());
                for (int i = 0; i < tasks.size(); i++) {
            %>
            <tr>
                <td><%out.println(i+1);%></td>
                <td><%out.println(tasks.get(i).getTaskId());%></td>
                <td><%out.println(tasks.get(i).getTaskName());%></td>
                <td><%out.println(tasks.get(i).getTaskRemark());%></td>
                <td><%out.println(tasks.get(i).getTaskStartDate());%></td>
                <td><%out.println(tasks.get(i).getTaskEndDate());%></td>
                <td><%out.println(taskProcess.getNumOfTask(tasks.get(i)));%></td>
                <td>
                    <form action="../deleteEntityServlet" method="post">
                        <input type="hidden" name="entityType" value="task"/>
                        <input type="hidden" name="deleteSection"
                               value="<%out.print(tasks.get(i).getTaskId());%>"/>
                        <div class="btn_box floatR mag_l20">
                            <input type="submit" value="删除任务" onClick="return confirm('删除后将无法恢复,确定要删除?')">
                        </div>
                    </form>
                    <form action="insertTaskStaff.jsp" method="post">
                        <input type="hidden" name="sectionTask" value="<%out.print(tasks.get(i).getTaskId());%>"/>

                        <div class="btn_boxB floatR">
                            <input type="submit" value="添加员工">
                        </div>
                    </form>
                    <form action="deleteTaskStaff.jsp" method="post">
                        <input type="hidden" name="sectionTask" value="<%out.print(tasks.get(i).getTaskId());%>"/>

                        <div class="btn_boxB floatR">
                            <input type="submit" value="删除员工">
                        </div>
                    </form>
                </td>

            </tr>
            <%
                }
            %>
        </table>
        <p class="msg">共找到<%out.println(tasks.size());%>条记录，当前显示从第1条至第10条</p>
    </div>
</div>
<!-- /MainForm -->

</body>
</html>
