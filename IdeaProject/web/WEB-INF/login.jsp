<%--
  Created by IntelliJ IDEA.
  User: voghost
  Date: 2020/6/25
  Time: 上午7:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all"/>
</head>
<body>
<%--主要背景--%>
<div class="main-bg" id="mian">
    <span style="color:black; font-size:large; font-weight: bold">

    <%if(request.getAttribute("error")!=null){
        out.println(request.getAttribute("error")+"<br/>");
    }%>
    </span>
    <h1 id="head-font">后台管理系统</h1>
    <div class="sub-main-w3">
        <div class="vertical-tab">
            <div id="section1" class="section-w3ls">
                <input type="radio" name="sections" id="option1" checked>
                <label for="option1" class="icon-left-w3pvt"><span class="fa fa-user-circle" aria-hidden="true"></span>登录</label>
                <article>
                    <form action="loginHandlerServlet" method="post">
                        <h3 class="legend">账号登录</h3>
                        <div class="input">
                            <span class="fa fa-envelope-o" aria-hidden="true"></span>
                            <input type="text"  placeholder="账号" name="userName" required/>
                        </div>
                        <div class="input">
                            <span class="fa fa-key" aria-hidden="true"></span>
                            <input type="password" v-model="logindata.password" placeholder="密码" name="password"
                                   required/>
                        </div>
                        <button type="submit" class="btn submit">登 录</button>
                        <!--<a href="#" class="bottom-text-w3ls">忘记密码?</a>-->
                    </form>
                </article>
            </div>
            <div id="section2" class="section-w3ls">
                <input type="radio" name="sections" id="option2">
                <label for="option2" class="icon-left-w3pvt"><span class="fa fa-pencil-square"
                                                                   aria-hidden="true"></span>注册</label>
                <article>
                    <form action="#" method="post">
                        <h3 class="legend">注册帐户</h3>
                        <div class="input">
                            <span class="fa fa-user-o" aria-hidden="true"></span>
                            <input type="text" v-model="registerdata.name" placeholder="用户名" name="name" required/>
                        </div>
                        <div class="input">
                            <span class="fa fa-key" aria-hidden="true"></span>
                            <input type="password" placeholder="密码" name="password"  id="password"  required/>
                        </div>
                        <div class="input">
                            <span class="fa fa-key" aria-hidden="true"></span>
                            <input type="password" placeholder="确认密码" name="confirmPassword"  id="password_check" required/>
                            <span id="warning"></span>
                        </div>
                        <button type="submit" class="btn submit" onclick="check()">注 册</button>
                    </form>
                </article>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
</div>
</body>
<script>
    function check() {
        if(document.getElementById("password").value!=document.getElementById("password_check").value){
            document.getElementById("warning").innerHTML= "两次秘密输入不一致";
            return false
        }else{
            document.getElementById("warning").innerHTML="    ";
            return true
        }
    }
</script>
</html>
