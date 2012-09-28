<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String current = path+"/Web/Manage";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=current %>/manageright.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
	<div class="managebox">
		<div class="boxtitle">
			我收藏的项目
		</div>
		<div class="boxbody">
			<div class="list">

				<table>
					<tr class="listtitle">
						<td>
							项目名称
						</td>
						<td>
							项目作者
						</td>
						<td>
							查看
						</td>
						<td>
							移除
						</td>
					</tr>
					<jsp:include page="_FavorProjects.jsp"></jsp:include>
				</table>
			</div>
		</div>
</div>

	</body>
</html>
