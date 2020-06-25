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
<div class="main-background" id="main">
    <div class="main-bg" id="mian">
        <h1 id="head-font">后台管理系统</h1>
        <div class="sub-main-w3">
            <div class="vertical-tab">
                <div id="section1" class="section-w3ls">
                    <input type="radio" name="sections" id="option1" checked>
                    <label for="option1" class="icon-left-w3pvt"><span class="fa fa-user-circle" aria-hidden="true"></span>登录</label>
                    <article>
                        <form action="#" method="post">
                            <h3 class="legend">账号登录</h3>
                            <div class="input">
                                <span class="fa fa-envelope-o" aria-hidden="true"></span>
                                <input type="email" v-model="logindata.email" placeholder="邮箱" name="email" required />
                            </div>
                            <div class="input">
                                <span class="fa fa-key" aria-hidden="true"></span>
                                <input type="password" v-model="logindata.password" placeholder="密码" name="password" required />
                            </div>
                            <button type="submit" class="btn submit">登 录</button>
                            <!--<a href="#" class="bottom-text-w3ls">忘记密码?</a>-->
                        </form>
                    </article>
                </div>
                <div id="section2" class="section-w3ls">
                    <input type="radio" name="sections" id="option2">
                    <label for="option2" class="icon-left-w3pvt"><span class="fa fa-pencil-square" aria-hidden="true"></span>注册</label>
                    <article>
                        <form action="#" method="post">
                            <h3 class="legend">注册帐户</h3>
                            <div class="input">
                                <span class="fa fa-user-o" aria-hidden="true"></span>
                                <input type="text" v-model="registerdata.name" placeholder="用户名" name="name" required />
                            </div>
                            <div class="input">
                                <span class="fa fa-key" aria-hidden="true"></span>
                                <input type="password" v-model="registerdata.password" placeholder="密码" name="password" required />
                            </div>
                            <div class="input">
                                <span class="fa fa-key" aria-hidden="true"></span>
                                <input type="password" v-model="registerdata.confirmPassword" placeholder="确认密码" name="confirmPassword" required />
                            </div>
                            <button type="submit" class="btn submit">注 册</button>
                        </form>
                    </article>
                </div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
</body>
</html>
