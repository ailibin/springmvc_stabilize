<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>验证码</title>

    <script type="text/javascript" src="<%=request.getContextPath()%>/res/js/jquery-1.11.3.min.js">
    </script>
</head>

<body>
<script type="text/javascript">
    $(function () {  //生成验证码
        $('#kaptchaImage').click(function () {
            $(this).hide().attr('src', '<%=path%>/member/captcha-image?' + Math.floor(Math.random() * 100)).fadeIn();
        });
    });

    window.onbeforeunload = function () {
        //关闭窗口时自动退出
        if (event.clientX > 360 && event.clientY < 0 || event.altKey) {
            alert(parent.document.location);
        }
    };

    function changeCode() {  //刷新
        $('#kaptchaImage').hide().attr('src', '<%=path%>/member/captcha-image?' + Math.floor(Math.random() * 100)).fadeIn();
        event.cancelBubble = true;
    }
</script>

<div class="form-group">
    <label>验证码 </label>
    <form action="<%=path%>/member/checkCode">
        <input name="j_code" type="text" id="kaptcha" maxlength="4" class="form-control"/>
        <br/>
        <img src="<%=path%>/member/captcha-image" id="kaptchaImage" style="margin-bottom: -3px"/>
        <a href="#" onclick="changeCode()">看不清?换一张</a>
        <input type="submit" value="验证">

        <span>${checkCode }</span>
    </form>
</div>
</body>
</html>