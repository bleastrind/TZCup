<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String current = path+"/Web/Manage";
String common = path+"/Web/common";
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户个人信息修改</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=current %>/manageright.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>   

  <div class="boxtitle">用户审核</div>
  <div class="boxbody">

    
    <jsp:include page="_VerifyUserOperate.jsp"></jsp:include>
    

	
  </div>

  </body>
</html>
