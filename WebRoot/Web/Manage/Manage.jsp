<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="net.tiaozhanbei.model.User"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
String path = request.getContextPath();
String current = path+"/Web/Manage";
String common = path+"/Web/common";
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
User user = (User)request.getSession().getAttribute("user");

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Manage.html</title>
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="this is my page">

		<link rel="stylesheet" type="text/css" href="<%=common %>/css/redmond/jquery-ui-1.7.1.custom.css">
		<link rel="stylesheet" type="text/css" href="<%=common %>/css/common.css">
		<script src="<%=common %>/js/jquery-1.3.2.min.js" type="text/javascript"></script>
		<script src="<%=common %>/js/jquery.history.js" type="text/javascript"></script>
		
			
		<script src="<%=common %>/js/jquery-ui-1.7.1.custom.min.js" type="text/javascript"></script>
		<script src="<%=common %>/js/jquery.form.js" type="text/javascript"></script>
		 <script src="<%=current %>/manage.js" type="text/javascript"></script>

		
		<link rel="stylesheet" type="text/css" href="<%=current %>/manage.css">
		<link rel="stylesheet" type="text/css" href="<%=current %>/manageright.css">
	</head>

	<body>
	<div id="serverPath" style="display:none;" title="<%=path %>"></div>
	<div id="currentPath" style="display: none;" title=""></div>
	<div id="dialogerr" style="display: none;" title="Error">
		<p>操作失败</p>
	</div>
	<div id="dialogsuccess" style="display: none;" title="成功">
		<p>操作成功</p>
	</div>
		<div id="container">

			<div id="managehead">
				<div id="managelogo"> 
					欢迎登陆第十一届挑战杯官方网站 
				</div>
				<div id="managenavi">
					欢迎您：<%=user.getRealName() == null ? user.getName() : user.getRealName() %>
					<a href="<%=path %>/logoff.do">注销</a>
					<a  href="<%=path %>/index.do">去主页</a>
				</div>
			</div>



			<div id="manageleft">
				<ul id="controlTree">
					<jsp:include page="_lefttree.jsp"></jsp:include>
				</ul>
			</div>


			<div id="manageright">

			</div>



			<div id="managefooter">
				主办单位：共青团中央 中国科协 教育部 全国学联 北京市政府
				<br />
				承办单位：北京航空航天大学
			</div>



		</div>
	</body>
</html>
