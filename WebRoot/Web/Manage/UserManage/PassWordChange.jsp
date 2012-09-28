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
    
    <title>修改密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="manageright.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
  <div class="managebox">
  <div class="boxtitle">修改密码</div>
  <div class="boxbody">
  <div class="input">
      <form action="<%=request.getContextPath() %>/changePassWord.do" method="post">
  	<table>
		<tr> <th>当前密码:</th><td><input type="password" name="oldpassword"> </td> </tr>
		<tr><th>新密码:</th><td><input type="password" name="newpassword"> </td> </tr>
		<tr><th>新密码确认:</th><td><input type="password" name="newpassword" > </td></tr>
		<tr><th></th><td><input type="submit" value="修改密码" >  </td> </tr>		
  	</table>
	</form>
	</div>
   </div>
  </div>
  </body>
</html>
