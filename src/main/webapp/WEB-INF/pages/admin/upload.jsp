<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%--<script type="text/javascript" src="../js/jquery-1.7.2.js"></script>--%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <title>上传文件</title>
    <!--引用css样式文件(这里为什么应用不了css文件??用下面的链接地址)-->
    <%--<link rel="stylesheet" type="text/css" href="css/style.css"/>--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <!--引用工程的js文件,一定要放在表头-->
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script type="text/javascript">
        var i = 1;
        var j = 1;

        $(document).ready(function () {

            $("#btn_add1").click(function () {
                document.getElementById("newUpload1").innerHTML += '<div id="div_' + i + '"><input name="file" type="file" /><input type="button" value="删除" onclick="del_1(' + i + ')"/></div>';
                i = i + 1;
            });

            $("#btn_add2").click(function () {
                document.getElementById("newUpload2").innerHTML += '<div id="div_' + j + '"><input name="file_' + j + '" type="file" /><input type="button" value="删除" onclick="del_2(' + j + ')"/></div>';
                j = j + 1;
            });
        });

        function del_1(o) {
            document.getElementById("newUpload1").removeChild(document.getElementById("div_" + o));
        }

        function del_2(o) {
            document.getElementById("newUpload2").removeChild(document.getElementById("div_" + o));
        }
    </script>

</head>
<body>

<h1>springMVC字节流输入上传文件</h1>
<form name="userForm1" action="/file/upload" enctype="multipart/form-data" method="post">
    <div id="newUpload1">
        <input type="file" name="file" multiple="multiple">
    </div>

    <input type="button" id="btn_add1" value="增加一行" onclick="addFile1()" class="btn btn-primary btn-sm">
    <input type="submit" value="上传" class="btn btn-success btn-sm">
</form>
<br>
<br>
<hr align="left" width="60%" color="#FF0000" size="3">
<br>
<br>
<h1>springMVC包装类上传文件</h1>
<form name="userForm2" action="/file/upload2" enctype="multipart/form-data" method="post">
    <div id="newUpload2">
        <input type="file" name="file" multiple="multiple">
    </div>
    <input type="button" id="btn_add2" value="增加一行" onclick="addFile2()" class="btn btn-primary btn-sm">
    <input type="submit" value="上传" class="btn btn-success btn-sm">

</form>

<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</body>
</html>