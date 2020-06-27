<%@ page import="com.Model.function.SessionProcess" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.Model.Entity.Staff" %>
<%@ page import="com.Model.Database.DatabaseStaff" %><%--
  Created by IntelliJ IDEA.
  User: voghost
  Date: 2020/6/26
  Time: 上午9:10
  To change this template use File | Settings | File Templates.
--%>
<%
    SessionProcess sessionProcess=new SessionProcess(request,response);
    if(!sessionProcess.hasSession()){
        response.sendRedirect("../login.jsp");
        return ;
    }

    String userName;
    DatabaseStaff databaseStaff=new DatabaseStaff();
    ArrayList<Staff> staffs=databaseStaff.searchStaff(sessionProcess.getUserName(),1);
    userName=staffs.get(0).getStaffName();


%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="generator" content="" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
    <link href="css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
    <link href="css/print.css" rel="stylesheet" type="text/css"  media="print" />
    <script src="js/jquery-1.10.1.min.js"></script>
    <script src="js/side.js" type="text/javascript"></script>

    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <![endif]-->
    <style>
        .imgMiddle{text-align:center}
    </style>
</head>

<body>
<!-- wrap_left -->

<!-- /wrap_left -->

<!-- picBox -->
<div class="picBox" onClick="switchSysBar()" id="switchPoint"></div>
<!-- /picBox -->



<!-- wrap_right -->
<div class="wrap_right">
    <header>
        <!-- Header -->

        <!-- /Header -->
    </header>


    <!-- Contents -->
    <div id="Contents">
        <script type="text/javascript">
            $(function(){
                $(".select").each(function(){
                    var s=$(this);
                    var z=parseInt(s.css("z-index"));
                    var dt=$(this).children("dt");
                    var dd=$(this).children("dd");
                    var _show=function(){dd.slideDown(200);dt.addClass("cur");s.css("z-index",z+1);};
                    var _hide=function(){dd.slideUp(200);dt.removeClass("cur");s.css("z-index",z);};
                    dt.click(function(){dd.is(":hidden")?_show():_hide();});
                    dd.find("a").click(function(){dt.html($(this).html());_hide();});
                    $("body").click(function(i){ !$(i.target).parents(".select").first().is(s) ? _hide():"";});})})
        </script>

        <!-- MainForm -->
        <div id="MainForm">
            <div class="form_boxB">
                <h2><font size="10">欢迎你<%out.println(userName);%></font> </h2>
                <table cellpadding="0" cellspacing="0">
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <tr>
                      <div class="imgMiddle">
                          <img src="../images/main_1.gif" width="512" align="middle" />
                      </div>
                    </tr>
                </table>
            </div>
        </div>
        <!-- /MainForm -->


    <footer>
        <address>2020 Corporation,All Rights, PowerBy HuangZiyi, LiuLingfeng</address>
    </footer>
    <!-- /footer -->

</div>
<!-- /wrap_right -->
</body>
</html>
