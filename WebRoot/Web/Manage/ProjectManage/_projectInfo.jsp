<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="net.tiaozhanbei.model.Project"%>
<%@page import="net.tiaozhanbei.util.ProjectConst"%>
<%@page import="net.tiaozhanbei.util.datastruct.UrlTree" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Project project = (Project)request.getAttribute("project");
UrlTree catagoryTree=(UrlTree)request.getAttribute("catagoryTree");
//System.out.println(lefttree);
catagoryTree.setContextPath(request);

%>

  


<div class="managebox">
  <div class="boxtitle">信息修改</div>
  <div class="boxbody">
    <form action="<%=path %>/project/modify.do?action=update&projectId=<%=project.getId() %>">
		<table>		

			<tr> <td>简要介绍：</td><td><input name="brief" type="text" value="<%=project.getBrief() %>"/></td></tr>
			<tr> <td>详细介绍:</td><td><textarea name="detail" rows="6"><%=project.getDetal() %></textarea ></td> </tr>
			<tr><td> 类别 ：</td><td>
				<select name="type">
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
				</select></td> </tr>


			   <tr><td><input type="submit" value="提交修改"/> </tr>
			   	
		</table>		
	</form>
		
			
  </div>
</div>
