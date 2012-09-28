<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="net.tiaozhanbei.util.datastruct.UrlTree" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
UrlTree catagoryTree=(UrlTree)request.getAttribute("catagoryTree");
catagoryTree.setContextPath(request);
%>
		<div>
			<form action="regProject.do" method="post">
				项目名称：<input type="text" name="name"><p>
				项目类型：	   <select name="type"><p>
				<%
				int count = 0;
				for (UrlTree tree:catagoryTree.getChildren()) {
					count++;
				%>
					<optgroup label="<bean:message key="<%=tree.getFullName() %>" />">
					<option value="<%=tree.getFullName() %>"> 
						<bean:message key="<%=tree.getFullName()%>" />
						</option>
					<%
					for (UrlTree child:tree.getChildren()) {
					 %>
						<option value="<%=child.getFullName() %>"> 
						<bean:message key="<%=child.getFullName()%>" />
						</option>
					<%} %>
					</optgroup>
				<%} %>
				</select> <p>
				项目简介：<p><textarea rows="10" name="brief"></textarea><p>
				<input type="submit" > 
						
			</form>			
		</div>