<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
String path = request.getContextPath();
String common = path+"/Web/common";
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String oldurl=request.getParameter("oldurl");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>从这里登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=common %>/css/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/Web/login.css" rel="stylesheet" type="text/css"/>

  </head>
  
  <body>    <div id="error-page" class="error-page">
        <table align="left">
      <tr height="40" align="left">
      <th>对不起！您还没有登陆.</th>
      </tr>
      <tr align="left">
      <td>
      <form action="<%=path %>/loginoprate.do?oldurl=<%=oldurl%>"  name="loginForm" method="post" >
      <p>
      <label for="am">用户名:</label>
      <input type="text" class="text1" id="am" name="name"/>
      </p>
    
      <p>
      <label for="pw">密&nbsp;&nbsp;码:</label>
      <input type="password" class="text1" id="pw" name="password"/>
      </p>

      <label for="yz"><img src="<%=path %>/validateimage.do" alt="验证码" name="img1"/></label>
      <input type="text" class="text2" id="yz" name="validateimage"/>
     
      <p>
      <input type="checkbox" name="autoLog" value="true"/>下次自动登陆
      </p>
      <p>
      <input type="submit" value="登陆" class="text3"/>&nbsp;&nbsp;
      <a href="<%=path%>/register.do">
	  [<bean:message key="index.loginbox.registerNewUser"></bean:message>]</a>
      </p>
      </form>
      </td>
      </tr>
      </table>

         </div>
  </body>
</html>
