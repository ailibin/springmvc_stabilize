<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.aiitec.demo.model.service.ControlService "%>
<jsp:useBean id="ControlService" class="com.aiitec.demo.model.impl.ControlServiceImpl" scope="page"></jsp:useBean>
	<%
	String str = ControlService.serviceTest("test");
	%>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>hello world</title>
</head>
<body>
  <label>hello world <%=str%> </label>
</body>
</html>