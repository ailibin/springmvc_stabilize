<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户登陆</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!--自己从网上弄下来的最新版本,这个靠谱,这个一定要放到头部里面才有效-->
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>

    <!--自己写的css可能不好看-->
    <script src="${pageContext.request.contextPath}/css/signin.css"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script type="text/javascript">
        var username = document.getElementById("username");
        var password = document.getElementById("password");
        $(document).ready(function () {
            $("#username").onblur(function () {
                if (username.value == "" || username.value == null) {
                    alert("用户名不能为空");
                }
            });

            $("#password").onblur(function () {
                if (password.value == "" || password.value == null) {
                    alert("输入的密码不能为空");
                }
            })

            $("#submit").onclick(function () {
                if (password.value == "" || password.value == null) {
                    alert("输入的密码不能为空");
                } else if (username.value == "" || username.value == null) {
                    alert("用户名不能为空");
                }
            })
        })


    </script>
</head>
<body class="form-signin">
<div class="container">
    <h1 class="text-center bg-success">用户登陆</h1>
    <hr/>

    <form:form method="post" action="/admin/login/submit" commandName="login" role="form">
        <div class="form-group">
            <label>用户名:</label>
            <input type="text" name="username" id="username" class="form-control" placeholder="请输入用户名" >
        </div>
        <div class="form-group">
            <label>密码:</label>
            <input type="password" name="password" id="password" class="form-control" placeholder="请输入密码">
        </div>
        <button type="submit" class="btn btn-sm btn-success" id="submit">提交</button>

        <span style="margin-left: 200px"><label style="font-style: normal"><font color="#F15A24">还没有注册？</font></label>请点击<a
                href="/admin/register" type="button" class="btn btn-primary btn-sm"
                style="margin-left: 10px">注册</a></span>
    </form:form>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>