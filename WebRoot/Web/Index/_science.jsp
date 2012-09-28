<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="net.tiaozhanbei.model.*" %>
<%@page import="net.tiaozhanbei.util.Page"%>
<div id="science" style="display:block;" >
<%

String path=request.getContextPath();
		Page<Project> science=(Page<Project>)request.getAttribute("science");
	for (Project project : science.getDataList()) {
%>
<li><div class="smallshow" >
	<div>
		<img src="<%=project.getPicPath() %>"/>
		<a href="<%=path %>/project.do?projectId=<%=project.getId()%>"><%=project.getName()%></a>
	</div>
	<div>
		<%=project.getBrief() %>
	</div>
</div></li>

		<%}%>
		
</div>

<div id="society" style="display:none;">

<%

		Page<Project> society=(Page<Project>)request.getAttribute("society");
	for (Project project : society.getDataList()) {
%>
<li><div class="smallshow">
	<div>
		<img src="<%=project.getPicPath() %>"/>
		<a href="<%=path %>/project.do?projectId=<%=project.getId()%>"><%=project.getName()%></a>
	</div>
	<div>
		<%=project.getBrief() %>
	</div>
</div></li>

		<%}%>
		
		
</div>
<div id="natrual" style="display:none;">
<%
		Page<Project> natrual=(Page<Project>)request.getAttribute("natrual");
	for (Project project : natrual.getDataList()) {
%>
<li><div class="smallshow" >
	<div>
		<img src="<%=project.getPicPath() %>"/>
		<a href="<%=path %>/project.do?projectId=<%=project.getId()%>"><%=project.getName()%></a>
	</div>
	<div>
		<%=project.getBrief() %>
	</div>
</div></li>

		<%}%>
		
</div>