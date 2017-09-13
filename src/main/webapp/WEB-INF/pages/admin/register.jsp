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
    <title>用户注册</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <!--自己从网上弄下来的最新版本,这个靠谱,这个一定要放到头部里面才有效-->
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>


    <![endif]-->
    <!--有关ajax表单的库-->
    <script src="http://malsup.github.com/jquery.form.js"></script>

    <%--<script type="text/javascript">--%>

    <%--//验证用户名的格式(只能输入1-30个以字母开头的字串)--%>
    <%--function isTrueName(s) {--%>
    <%--var verifyName = /^[a-zA-Z]{1,30}$/;--%>
    <%--if (!verifyName.exec(s)) return false;--%>
    <%--else return true;--%>
    <%--}--%>

    <%--//验证密码的格式(只能输入6-20个字母、数字、下划线 )这里为什么不识别()括号呢--%>
    <%--function isPasswd(str) {--%>
    <%--var verifyPass = /^[A-Za-z0-9_]{6,20}$/;--%>
    <%--if (!verifyPass.exec(str)) return false;--%>
    <%--else return true;--%>
    <%--}--%>

    <%--//邮箱格式--%>
    <%--function isEmail(str) {--%>
    <%--var verifyEmail = /^[//w-]+(.[//w-]+)*@[//w-]+(.[//w-]+)+$/;--%>
    <%--if (!verifyEmail.exec(str)) return false;--%>
    <%--else return true;--%>
    <%--}--%>

    <%--//验证用户名--%>
    <%--function checkUserName() {--%>
    <%--//用户名--%>
    <%--var userName = document.getElementById("username");--%>
    <%--var noticeName = document.getElementById("inputUserNameStatus");--%>
    <%--if (userName.value == "" || userName.value == null) {--%>
    <%--//                alert("用户名不能为空");//这里不用alert,会出现死循环--%>
    <%--noticeName.value = "用户名不能为空";--%>
    <%--return false;--%>
    <%--} else if (isTrueName(userName.value)) {--%>
    <%--//                alert("用户名只能输入1-30个以字母开头的字串");--%>
    <%--noticeName.value = "用户名只能输入1-30个以字母开头的字串";--%>
    <%--return false;--%>
    <%--//                userName.innerHTML = "用户名只能输入1-30个以字母开头的字串";--%>
    <%--} else {--%>
    <%--return true;--%>
    <%--}--%>

    <%--}--%>

    <%--//验证密码--%>
    <%--function checkPassword() {--%>
    <%--//用户密码--%>
    <%--var password = document.getElementById("password");--%>
    <%--var noticePassword = document.getElementById("inputPasswordStatus");--%>
    <%--if (password.value == "" || password.value == null) {--%>
    <%--//                alert("密码不能为空");--%>
    <%--//                password.innerHTML = "ERROR";--%>
    <%--noticePassword.value = "密码不能为空";--%>
    <%--return false;--%>
    <%--} else if (isPasswd(password.value)) {--%>
    <%--//                alert("密码只能输入6-20个字母、数字、下划线");--%>
    <%--noticePassword.value = "密码只能输入6-20个字母、数字、下划线";--%>
    <%--return false;--%>
    <%--} else {--%>
    <%--return true;--%>
    <%--}--%>
    <%--}--%>

    <%--//验证再次输入的密码--%>
    <%--function checkRepassword() {--%>
    <%--//再次输入密码--%>
    <%--var reInputPassword = document.getElementById("repassword");--%>
    <%--var password = document.getElementById("password");--%>
    <%--if (reInputPassword.value == "" || reInputPassword.value == null) {--%>
    <%--return false;--%>
    <%--//                reInputPassword.innerHTML = "ERROR";--%>
    <%--} else if (!reInputPassword.value == password.value) {--%>
    <%--//                alert("输入的密码和上面的不一致");--%>
    <%--return false;--%>
    <%--} else {--%>
    <%--return true;--%>
    <%--}--%>
    <%--}--%>

    <%--//验证email--%>
    <%--function checkEmail() {--%>
    <%--//邮箱地址(可选)--%>
    <%--var email = document.getElementById("email");--%>
    <%--if (isEmail(email.value)) {--%>
    <%--alert("邮箱格式格式不正确");--%>
    <%--return false;--%>
    <%--} else return true;--%>
    <%--}--%>

    <%--function checkAll() {--%>
    <%--var submitBtn = document.getElementById("submit");--%>
    <%--//            if (checkUserName() && checkPassword() && checkRepassword() && checkEmail()) {--%>
    <%--submitBtn.submit();--%>
    <%--//            }--%>
    <%--}--%>
    <%--</script>--%>
    <script type="text/javascript">

        $(document).ready(function () {



        });

        <%--function testAjax() {--%>
            <%--var form = new FormData(document.getElementById("myForm"));--%>
            <%--form.append("username","admin");--%>
            <%--form.append("password","123");--%>
            <%--&lt;%&ndash;var req = new XMLHttpRequest();&ndash;%&gt;--%>
            <%--&lt;%&ndash;req.open("post", "${pageContext.request.contextPath}/pages/admin/upload", false);&ndash;%&gt;--%>
            <%--&lt;%&ndash;req.send(form);&ndash;%&gt;--%>
            <%--$.ajax({--%>
                <%--url:"${pageContext.request.contextPath}/pages/admin/upload",--%>
                <%--type:"post",--%>
                <%--data:form,--%>
                <%--processData:false,--%>
                <%--contentType:false,--%>
                <%--success:function(data){--%>
                    <%--window.clearInterval(timer);--%>
                    <%--alert(data);--%>
                    <%--console.log("over..");--%>
                <%--},--%>
                <%--error:function (e) {--%>
                    <%--alert("error!!!");--%>
                <%--}--%>
            <%--});--%>
        <%--}--%>
    </script>


</head>
<body>

<div class="container">
    <h1 class="text-center bg-info">用户注册</h1>
    <hr/>

    <form:form method="post" action="/admin/register/submit" commandName="register" role="form" id="myForm">
        <div class="container" id="div_container">

            <div class="form-group has-success has-feedback">
                <label class="control-label" for="username">用户名:</label>
                <input type="text" class="form-control" id="username" name="username"
                       aria-describedby="inputUserNameStatus" placeholder="请输入用户名">
                <span class="glyphicon glyphicon-warning-sign form-control-feedback" aria-hidden="true"></span>
                <span id="inputUserNameStatus" class="sr-only">(warning)</span>
                <span id="noticeUserName"></span>
            </div>

            <div class="form-group has-success has-feedback">
                <label class="control-label" for="password">密码:</label>
                <input type="text" class="form-control" id="password" name="password"
                       aria-describedby="inputPasswordStatus" placeholder="请输入6位数以上密码">
                <span class="glyphicon glyphicon-warning-sign form-control-feedback" aria-hidden="true"></span>
                <span id="inputPasswordStatus" class="sr-only">(warning)</span>
                <span id="noticePassword"></span>
            </div>

            <div class="form-group has-success has-feedback">
                <label class="control-label" for="repassword">再次输入密码:</label>
                <input type="text" class="form-control" id="repassword" name="repassword"
                       aria-describedby="inputPasswordAgainStatus" placeholder="请输入与上面一致的密码">
                <span class="glyphicon glyphicon-warning-sign form-control-feedback" aria-hidden="true"></span>
                <span id="inputPasswordAgainStatus" class="sr-only">(warning)</span>
                <span id="noticeRePassword"></span>
            </div>

            <div class="form-group has-success has-feedback">
                <label class="control-label" for="email">邮箱:</label>
                <div class="input-group">
                    <span class="input-group-addon">@</span>
                    <input type="text" class="form-control" id="email" name="email" aria-describedby="inputEmailStatus"
                           placeholder="请输入标准的邮箱地址(可选)">
                </div>
                <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                <span id="inputEmailStatus" class="sr-only"></span>
                <span id="noticeEmail"></span>
            </div>

            <input type="submit" class="btn btn-sm btn-success" id="submit" value="提交">
        </div>

    </form:form>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>