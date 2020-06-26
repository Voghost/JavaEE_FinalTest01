<%--
  Created by IntelliJ IDEA.
  User: voghost
  Date: 2020/6/25
  Time: 下午5:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>首页</title>
</head>
<frameset rows="100,*" cols="*" scrolling="no" framespacing="0" frameborder="no" border="0">
    <!-- 引用头部 -->
    <frame src="backProcess/head.jsp" name="headmenu" id="mainFrame" title="mainFrame" scrolling="no">
    <!-- 引用左边和主体部分 -->
    <frameset rows="100*" cols="220,*" scrolling="No" framespacing="0" frameborder="no" border="0">
        <frame src="backProcess/left.html" name="leftmenu" id="mainFrame" title="mainFrame">
        <frame src="backProcess/main.jsp" name="main" scrolling="yes" noresize="noresize" id="rightFrame"
               title="rightFrame">
    </frameset>
</frameset>
</html>
