<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="net.tiaozhanbei.dao.IUserDAO"%>
<%@page import="net.tiaozhanbei.dao.UserDAO"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <% IUserDAO dao = new UserDAO();
  String name=dao.findById(1).getUserName(); %>
  <%=name %>
    This is my JSP page. <br>
  </body>
</html>
