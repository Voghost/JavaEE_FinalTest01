<%@ page import="com.Model.function.SessionProcess" %><%--
  Created by IntelliJ IDEA.
  User: voghost
  Date: 2020/6/26
  Time: 上午9:06
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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>头部</title>
    <link rel="stylesheet" type="text/css" href="css/public.css" />
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/public.js"></script>
</head>

<body>
<!-- 头部 -->
<div class="head">
    <div class="headL">
        <img class="headLogo" src="img/logLOGO.png"/>
    </div>
    <div class="headR">
        <span style="color:#FFF">欢迎：<%out.print(new SessionProcess(request,response).getUserName());%></span> <a href="../login.jsp" rel="external" target="_top">【退出】</a>
    </div>
</div>
</body>
</html>
