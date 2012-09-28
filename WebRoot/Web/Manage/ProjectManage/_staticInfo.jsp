<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="net.tiaozhanbei.model.Project"%>
<%@page import="net.tiaozhanbei.model.ProjectState"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	Project project = (Project) request.getAttribute("project");
	ProjectState state = project.getState();
%>
<div class="managebox">
	<div class="boxtitle">
		项目状态
	</div>
	<div class="boxbody">
<form action="">
		<table>
			<tr>
				<td>
					票数：
				</td>
				<td><%=state.getVotes()%></td>
			</tr>
			<tr>
				<td>
					排名：
				</td>
				<td><%=state.getRank() %></td>
			</tr>
			<tr>
				<td>
					可用分配点数：
				</td>
				<td><%=project.getScore() %></td>
			</tr>
			<tr>
				<td>
					公众评价：
				</td>
				<td>
					<%=state.getTotalStars()%>
				</td>
			</tr>


		</table>

	</div>
</div>