<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="net.tiaozhanbei.model.Project"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Set<Project> projects = (Set<Project>)request.getAttribute("interest");
%>
						<div class="rightbox_title">
							我关注的项目
						</div>
						<div class="rightbox_body">
							<ul>
						<%for(Project project : projects){ %>
						<li><a href="<%=path %>/project.do?projectId=<%=project.getId() %>">
						<%=project.getName() %>
						</a>
						
						</li>
						<%} %>
							</ul>
						</div>
