<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="net.tiaozhanbei.model.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'LoginSuccess.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<%
User user=(User)session.getAttribute("user"); %>
  </head>
  
  <body>
    <table>
		<tr><td>您的用户名：<%= request.getParameter("name")%>   </td></tr>
		<tr><td>您的密码：<%= request.getParameter("password")%>   </td></tr>
		<tr><td>您的E-mail：<%= user.getEmail()%>   </td></tr>
		<tr><td>您的联系方式：<%= user.getPhone()%>   </td></tr>
		<tr><td>您的注册时间：<%= user.getRegisterTime()%>   </td></tr>
		
		
		
	</table>
  </body>
</html>
