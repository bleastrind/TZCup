<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="net.tiaozhanbei.util.datastruct.UrlTree" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
UrlTree catagoryTree=(UrlTree)request.getAttribute("catagoryTree");
catagoryTree.setContextPath(request);
%>

   <form action="<%=request.getContextPath() %>/authorReg.do" name="AuthorReg" method="post" id="userForm">
       <table cellpadding="0" cellspacing="0" border="0">
	     <caption>参赛作者相关信息</caption>
		 <tbody>
		 
		     <tr>
			   <th >真实姓名:</th>
			   <td class="box"><input type="text" name="realName" /></td>
			  </tr>
			  
			 
			 <tr>
			   <th >所在学校:</th>
			   <td class="box"><input type="text" name="department" /></td>
			  </tr>
			 
			 <tr>
			   <th>联系方式(电话):</th>
			   <td class="box"><input type="text" name="phone" /></td>
			  </tr>
			</tbody>
			</table>
			
			
		<table cellpadding="0" cellspacing="0" border="0">
	     <caption>参赛项目信息</caption>
		 <tbody>
		 
		     <tr>
			   <th >项目名称:</th>
			   <td class="box"><input type="text" name="name" /></td>
			  </tr>
			  
			 
			 <tr>
			   <th class="select">项目类型：</th>
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
				</select>
			  </tr>
			 
			 <tr>
			   <th class="select">项目简介：</th>
			   <td class="brief" colspan="2"><textarea name="brief" rows="10"  class="brief" style="width:400px;overflow-x:visible;overflow-y:visible;"></textarea></td>
			 </tr>
			</tbody>
			</table>
 <div id="regbutton">
	      <input class="button"  onmouseover="this.className='button_mouseover'" onmouseout="this.className='button'"

 type="submit" value="提交" name="submit" />
	   </div>  
    </form>