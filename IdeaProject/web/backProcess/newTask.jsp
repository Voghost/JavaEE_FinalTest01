<%--
  Created by IntelliJ IDEA.
  User: voghost
  Date: 2020/6/26
  Time: 上午9:11
  To change this template use File | Settings | File Templates.
--%>
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


<form action="../newEntityServlet" method="post">
    <input type="hidden" name="entityType" value="task"/>
    <!-- Popup -->
    <div id="Popup">
        <!-- SubPopup -->
        <div id="SubPopup">
            <script type="text/javascript">
                $(function () {
                    $(".select").each(function () {
                        var s = $(this);
                        var z = parseInt(s.css("z-index"));
                        var dt = $(this).children("dt");
                        var dd = $(this).children("dd");
                        var _show = function () {
                            dd.slideDown(200);
                            dt.addClass("cur");
                            s.css("z-index", z + 1);
                        };
                        var _hide = function () {
                            dd.slideUp(200);
                            dt.removeClass("cur");
                            s.css("z-index", z);
                        };
                        dt.click(function () {
                            dd.is(":hidden") ? _show() : _hide();
                        });
                        dd.find("a").click(function () {
                            dt.html($(this).html());
                            _hide();
                        });
                        $("body").click(function (i) {
                            !$(i.target).parents(".select").first().is(s) ? _hide() : "";
                        });
                    })
                })
            </script>
            <div class="form_boxC">
                <p>"<span class="f_cB">*</span>"号为必填项目</p>

                <table cellpadding="0" cellspacing="0">
                    <tr>
                        <th>任务名称 <span class="f_cB">*</span></th>
                        <td>
                            <div class="txtbox floatL" style="width:200px;">
                                <input name="TaskName" type="text" size="20" placeholder="任务名称">
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <th>任务描述 <span class="f_cB">*</span></th>
                        <td>
                            <div class="txtbox floatL" style="width:700px;">
                                <input name="TaskRemark" type="text" size="95" placeholder="任务描述">
                            </div>
                        </td>

                    </tr>

                    <tr>
                        <th>截止时间 <span class="f_cB">*</span></th>
                        <td>
                            <div class="txtbox floatL" style="width:700px;">
                                <input name="TaskEndDate" type="text" size="95" placeholder="截止时间">
                            </div>
                        </td>

                    </tr>


                </table>
            </div>
        </div>
        <!-- SubPopup -->

        <div id="BtmBtn">
            <div class="btn_boxB floatR mag_l20"><input name="" type="reset" value="取消"
                                                        onmousemove="this.className='input_move'"
                                                        onmouseout="this.className='input_out'"></div>
            <div class="btn_box floatR"><input name="" type="submit" value="提交"
                                               onmousemove="this.className='input_move'"
                                               onmouseout="this.className='input_out'"></div>
        </div>
    </div>
    <!-- /Popup -->
</form>
<%--
<iframe id="id_iframe" name="nm_iframe" style="display:none;"></iframe>
--%>
</body>
</html>
