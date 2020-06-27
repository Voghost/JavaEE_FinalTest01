<%@ page import="com.Model.function.SessionProcess" %><%--
  Created by IntelliJ IDEA.
  User: voghost
  Date: 2020/6/25
  Time: 下午5:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    SessionProcess sessionProcess=new SessionProcess(request,response);
    if(!sessionProcess.hasSession()){
       response.sendRedirect("login.jsp");
       return ;
    }
    String userType=sessionProcess.getUserType();
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>首页</title>
</head>



<frameset rows="100,*" cols="*" scrolling="no" framespacing="0" frameborder="no" border="0">
    <!-- 引用头部 -->
    <frame src="backProcess/head.jsp" name="headmenu" id="mainFrame" title="mainFrame" scrolling="no">
    <!-- 引用左边和主体部分 -->
    <frameset rows="100*" cols="220,*" scrolling="No" framespacing="0" frameborder="no" border="0">

        <%
            if (userType.equals("manager")) {
        %>
        <frame src="backProcess/left_manager.html" name="leftmenu" id="mainFrame" title="mainFrame">
        <frame src="backProcess/main.jsp" name="main" scrolling="yes" noresize="noresize" id="rightFrame"
               title="rightFrame">
        <%
        } else if (userType.equals("staff")) {
        %>
        <frame src="backProcess/left_staff.html" name="leftmenu" id="mainFrame" title="mainFrame">
        <frame src="backProcess/main.jsp" name="main" scrolling="yes" noresize="noresize" id="rightFrame"
               title="rightFrame">
        <%
        }
    %>
    </frameset>
</frameset>
</html>
