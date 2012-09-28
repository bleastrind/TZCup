<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="net.tiaozhanbei.model.Project"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Set<Project> projects = (Set<Project>)request.getAttribute("interest");
if(projects!=null){
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

						
<%}else {%>
						<div class="rightbox_title">
								登录
						</div>
							<div class="rightbox_body">
<form id="indexloginform" action="<%=path%>/loginoprate.do?oldurl=<%=path %>/projects.do" method="post">
	<div id="formcontent">
		<table>
			<tr>
				<th>
					<bean:message key="index.loginbox.username"></bean:message>
				</th>
				<td>
					<input type="text" name="name"  class="inputtext"/>
				</td>
			</tr>
			<tr>
				<th>
					<bean:message key="index.loginbox.password"></bean:message>
				</th>
				<td>
					<input type="password" name="password" class="inputtext" />
				</td>
			</tr>
			<tr>
			    <th><bean:message key="index.loginbox.validatecode"></bean:message></th>
				<td>
					<input type="text" name="validateimage" style="width:5em;" />
					<img src="<%=path%>/validateimage.do" 
					alt="<bean:message key="index.loginbox.validatecode"></bean:message>"
						name="img1" />
				</td>
			</tr>
			<tr>
				<td>
					
				</td>
				<td>
					<input type="checkbox" name="autoLog" value="true"><bean:message key="index.loginbox.autologin"></bean:message>
				</td>
			</tr>
			<tr>
			    <th>
			    </th>
				<td>
					<input value="<bean:message key="index.loginbox.login"></bean:message>" type="submit" class="loginsubmit" />
					<a href="<%=path%>/register.do">
					[<bean:message key="index.loginbox.registerNewUser"></bean:message>]</a>		
				
				</td>
			</tr>
		</table>

	</div>
</form>
		
		</div>
<%
	}
%>