<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="net.tiaozhanbei.util.datastruct.UrlTree" %>
<%@page import="com.fredck.FCKeditor.*" %>
<%@page import="com.fredck.*" %> 
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
UrlTree catagoryTree=(UrlTree)request.getAttribute("catagoryTree");
//System.out.println(lefttree);
catagoryTree.setContextPath(request);
%>
<div class="managebox">
<div class="boxtitle">新建投票</div>
      <div class="boxbody">
      <div class="input">
<form name="addNews" method="post" action="<%=path %>/manage/addNews.do">
	<table width="600" align="left">
		<tbody>
				<tr>
					<th>标题:</th>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<th>类型:</th>
					<td><select name="catagory">
					<%
						for (UrlTree urlTree : catagoryTree.getChildren()) {	
					 %>
						<option value="<%=urlTree.getName() %>">
							<bean:message key="<%= urlTree.getFullName() %>"/>
						</option>
					<%} %>
					</select></td>
				</tr>
				<tr>
					<th></th>					
					<td><%
						FCKeditor oFCKeditor;
						oFCKeditor = new FCKeditor(request, "content");
						oFCKeditor.setBasePath(request.getContextPath() + "/FCKeditor/");
						oFCKeditor.setWidth("550");
						oFCKeditor.setHeight("350");
						oFCKeditor.setValue("");
						out.println(oFCKeditor.create());
					%></td>
				</tr>
				<tr>
					<th>代表图片地址</th>
					<td>
					    <input type="text" name="picpath"></input>
					</td>
				</tr>
				<tr>
					<th></th><td><input type="submit" name="submit" value="提交" /></td>
				</tr>
		
		</tbody>
	</table>
</form>

</div>
</div>
</div>
