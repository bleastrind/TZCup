
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="net.tiaozhanbei.util.*" %>
<%@ page import="net.tiaozhanbei.model.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Set<Project> dataList = (Set<Project>)request.getAttribute("favorateproject");

%>

    	<%for(Project project:dataList) {%>
	  	<tr>
		  	<th><%=project.getName() %></th>
		  	<td><%=project.getOwner().getName() %></td>
		  	<td><a href="<%=path %>/project.do?projectId=<%=project.getId() %>">
		  	查看</a></td>
		  	<td><a href="<%=path %>/project/modify.do?id=<%=project.getId() %>&action=delFromMe">
		  	取消收藏</a></td>
	  	</tr>
		<% }%>