<%--
  Created by IntelliJ IDEA.
  User: voghost
  Date: 2020/6/26
  Time: 上午9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>首页左侧导航</title>
    <link rel="stylesheet" type="text/css" href="css/public.css" />
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/public.js"></script>

    <head></head>

<body id="bg">
<!-- 左边节点 -->
<div class="container">

    <div class="leftsidebar_box">
        <a href="main.html" target="main">
            <div class="line">
                <img src="img/coin01.png" />&nbsp;&nbsp;首页
            </div>
        </a>
        <dl class="system_log">
            <dt>
                <img class="icon1" src="img/coin03.png" />
                <img class="icon2" src="img/coin04.png" />部门管理<img class="icon3" src="img/coin19.png" /><img
                    class="icon4" src="img/coin20.png" />
            </dt>
            <dd>
                <img class="coin11" src="img/coin111.png" />
                <img class="coin22" src="img/coin222.png" />
                <a class="cks" href="departments.jsp" target="main">所有部门</a>
                <img class="icon5" src="img/coin21.png" />
            </dd>
            <dd>
                <img class="coin11" src="img/coin111.png" />
                <img class="coin22" src="img/coin222.png" />
                <a class="cks" href="newDepartment.jsp" target="main">新建部门</a>
                <img class="icon5" src="img/coin21.png" />
            </dd>
            <dd>
                <img class="coin11" src="img/coin111.png" />
                <img class="coin22" src="img/coin222.png" />
                <a class="cks" href="departments.jsp" target="main">删除部门</a>
                <img class="icon5" src="img/coin21.png" />
            </dd>

        </dl>
        <dl class="system_log">
            <dt>
                <img class="icon1" src="img/coin01.png" />
                <img class="icon2" src="img/coin02.png" />项目管理<imgclass="icon3" src="img/coin19.png" />
                <img class="icon4" src="img/coin20.png" />
            </dt>
            <dd>
                <img class="coin11" src="img/coin111.png" />
                <img class="coin22" src="img/coin222.png" />
                <a class="cks" href="projects.jsp" target="main">所有项目</a>
                <img class="icon5" src="img/coin21.png" />
            </dd>
            <dd>
                <img class="coin11" src="img/coin111.png" />
                <img class="coin22" src="img/coin222.png" />
                <a class="cks" href="newProject.jsp" target="main">新建项目</a>
                <img class="icon5" src="img/coin21.png" />
            </dd>
            <dd>
                <img class="coin11" src="img/coin111.png" />
                <img class="coin22" src="img/coin222.png" />
                <a class="cks" href="projects.jsp" target="main">删除项目</a>
                <img class="icon5" src="img/coin21.png" />
            </dd>
            <dd>
                <img class="coin11" src="img/coin111.png" />
                <img class="coin22" src="img/coin222.png" />
                <a class="cks" href="projects.jsp" target="main">修改项目状态</a>
                <img class="icon5" src="img/coin21.png" />
            </dd>

        </dl>
        <dl class="system_log">
            <dt>
                <img class="icon1" src="img/coin07.png" />
                <img class="icon2" src="img/coin08.png" />任务管理<img class="icon3" src="img/coin19.png" />
                <img class="icon4" src="img/coin20.png" />
            </dt>
            <dd>
                <img class="coin11" src="img/coin111.png" />
                <img class="coin22" src="img/coin222.png" />
                <a href="p1.html" target="main" class="cks">所有任务</a>
                <img class="icon5" src="img/coin21.png" />
            </dd>
            <dd>
                <img class="coin11" src="img/coin111.png" />
                <img class="coin22" src="img/coin222.png" />
                <a href="newStaff.html" target="main" class="cks">新建任务</a>
                <img class="icon5" src="img/coin21.png" />
            </dd>
            <dd>
                <img class="coin11" src="img/coin111.png" />
                <img class="coin22" src="img/coin222.png" />
                <a href="p1.html" target="main" class="cks">删除任务</a>
                <img class="icon5" src="img/coin21.png" />
            </dd>
            <dd>
                <img class="coin11" src="img/coin111.png" />
                <img class="coin22" src="img/coin222.png" />
                <a href="p1.html" target="main" class="cks">修改任务状态</a>
                <img class="icon5" src="img/coin21.png" />
            </dd>
        </dl>
        <dl class="system_log">
            <dl class="system_log">
                <dt>
                    <img class="icon1" src="img/coin07.png" />
                    <img class="icon2" src="img/coin08.png" />员工管理<img class="icon3" src="img/coin19.png" />
                    <img class="icon4" src="img/coin20.png" />
                </dt>
                <dd>
                    <img class="coin11" src="img/coin111.png" />
                    <img class="coin22" src="img/coin222.png" />
                    <a href="staffs.jsp" target="main" class="cks">所有员工</a>
                    <img class="icon5" src="img/coin21.png" />
                </dd>
                <dd>
                    <img class="coin11" src="img/coin111.png" />
                    <img class="coin22" src="img/coin222.png" />
                    <a href="newStaff.jsp" target="main" class="cks">添加员工</a>
                    <img class="icon5" src="img/coin21.png" />
                </dd>
                <dd>
                    <img class="coin11" src="img/coin111.png" />
                    <img class="coin22" src="img/coin222.png" />
                    <a href="p1.html" target="main" class="cks">删除员工</a>
                    <img class="icon5" src="img/coin21.png" />
                </dd>
                <dd>
                    <img class="coin11" src="img/coin111.png" />
                    <img class="coin22" src="img/coin222.png" />
                    <a href="p1.html" target="main" class="cks">查找员工</a>
                    <img class="icon5" src="img/coin21.png" />
                </dd>
            </dl>
            <dl class="system_log">
                <dt>
                    <img class="icon1" src="img/coin10.png" /><img class="icon2" src="img/coin09.png" /> 其他管理<img
                        class="icon3" src="img/coin19.png" /><img class="icon4" src="img/coin20.png" />
                </dt>
                <dd>
                    <img class="coin11" src="img/coin111.png" /><img class="coin22" src="img/coin222.png" /><a
                        class="cks">其他管理</a><img class="icon5" src="img/coin21.png" />
                </dd>
            </dl>
            <dl class="system_log">
                <dt>
                    <img class="icon1" src="img/coin11.png" /><img class="icon2" src="img/coin12.png" /> 新闻管理<img
                        class="icon3" src="img/coin19.png" /><img class="icon4" src="img/coin20.png" />
                </dt>
                <dd>
                    <img class="coin11" src="img/coin111.png" /><img class="coin22" src="img/coin222.png" /><a
                        class="cks">新闻管理</a><img class="icon5" src="img/coin21.png" />
                </dd>
            </dl>
            <dl class="system_log">
                <dt>
                    <img class="icon1" src="img/coin14.png" /><img class="icon2" src="img/coin13.png" /> 心愿管理<img
                        class="icon3" src="img/coin19.png" /><img class="icon4" src="img/coin20.png" />
                </dt>
                <dd>
                    <img class="coin11" src="img/coin111.png" /><img class="coin22" src="img/coin222.png" /><a
                        class="cks">心愿管理</a><img class="icon5" src="img/coin21.png" />
                </dd>
            </dl>
            <dl class="system_log">
                <dt>
                    <img class="icon1" src="img/coin15.png" /><img class="icon2" src="img/coin16.png" /> 预警管理<img
                        class="icon3" src="img/coin19.png" /><img class="icon4" src="img/coin20.png" />
                </dt>
                <dd>
                    <img class="coin11" src="img/coin111.png" /><img class="coin22" src="img/coin222.png" /><a
                        class="cks">预警管理</a><img class="icon5" src="img/coin21.png" />
                </dd>
            </dl>
            <dl class="system_log">
                <dt>
                    <img class="icon1" src="img/coin17.png" /><img class="icon2" src="img/coin18.png" /> 收支管理<img
                        class="icon3" src="img/coin19.png" /><img class="icon4" src="img/coin20.png" />
                </dt>
                <dd>
                    <img class="coin11" src="img/coin111.png" /><img class="coin22" src="img/coin222.png" /><a
                        class="cks">收支管理</a><img class="icon5" src="img/coin21.png" />
                </dd>
            </dl>
            <dl class="system_log">
                <dt>
                    <img class="icon1" src="img/coinL1.png" /><img class="icon2" src="img/coinL2.png" /> 系统管理<img
                        class="icon3" src="img/coin19.png" /><img class="icon4" src="img/coin20.png" />
                </dt>
                <dd>
                    <img class="coin11" src="img/coin111.png" /><img class="coin22" src="img/coin222.png" /><a
                        href="changepwd.html" target="main" class="cks">修改密码</a><img class="icon5"
                                                                                     src="img/coin21.png" />
                </dd>
                <dd>
                    <img class="coin11" src="img/coin111.png" /><img class="coin22" src="img/coin222.png" /><a
                        class="cks">退出</a><img class="icon5" src="img/coin21.png" />
                </dd>
            </dl>

    </div>

</div>
</body>
</html>
