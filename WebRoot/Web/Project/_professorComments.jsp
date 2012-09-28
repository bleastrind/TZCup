<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="net.tiaozhanbei.model.ProjectComment"%>
<%@page import="net.tiaozhanbei.util.Page"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Page<ProjectComment> commentsList = (Page<ProjectComment>)request.getAttribute("professorCommentsList");
%>

				<div class="introtitle">专家点评</div>
						<%for(ProjectComment comment : commentsList.getDataList()){ %>
						<div class="professorname">
							专家：<%=comment.getAuthor().getName() %>
						</div>
						<div class="professorcontent">
						<%=comment.getTitle() %>
						<p><%=comment.getContent() %></p>
						</div>
						<% }%>
						
				