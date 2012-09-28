<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="net.tiaozhanbei.model.*"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	User user = (User) session.getAttribute("user");
	if (user != null) {//如果访问主页时可以找到用户名，就自动登录
		String name = user.getName();
%>
<bean:message key="index.loginbox.welcome"></bean:message>：<%=name%>!
<a href="<%=path%>/logoff.do"><bean:message key="index.loginbox.logout"></bean:message></a>
<p />
	<a href="<%=path%>/manage.do"><bean:message key="index.loginbox.gotoManagement"></bean:message></a>
	<%
		} else {
	%>

<form id="indexloginform" action="<%=path%>/loginoprate.do?from=index">
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

<%
	}
%>