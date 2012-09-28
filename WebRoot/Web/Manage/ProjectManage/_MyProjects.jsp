<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="net.tiaozhanbei.util.*" %>
<%@ page import="net.tiaozhanbei.model.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Set<Project> dataList = (Set<Project>)request.getAttribute("myproject");
%>

    	<%for(Project project:dataList){%>
	  	<tr>
		  	<th><%=project.getName() %></th>
		  	<td><%=project.getOwner().getName() %></td>
		  	<td><a href="<%=path %>/manage/projectInfo.do?id=<%=project.getId() %>">
		  	查看详情</a></td>
		  	<td><a href="<%=path%>/project/maintenance.do?id=<%=project.getId()%>">
		  	维护</a></td>
	  	</tr>
		<% }%>