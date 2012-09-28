<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Manage.jsp' starting page</title>
    
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
    用户管理页面 <br>
    
		<div>
			<h2>
					<span >+</span><a href="#">用户管理</a>
				</h2>
				<div >
					<p>
						<a href="#">添加用户</a>
					</p>
					<p>
						<a href="#">用户列表</a>
					</p>
                    <p>
                       <a href="<%=request.getContextPath() %>/noVerifyUser.do">用户审核</a>
                    </p>
					<p>
						<a href="Web/Manage/ProjectManage/FavorProjects.jsp">我喜欢的项目</a>
					</p>	
					<p><a href="<%=request.getContextPath() %>/editUser.do">修改我的信息</a>
					</p>	
		</div>
		</div>
    
    
  </body>
</html>
