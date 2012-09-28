<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="net.tiaozhanbei.util.datastruct.UrlTree" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
UrlTree catagoryTree=(UrlTree)request.getAttribute("catagoryTree");
catagoryTree.setContextPath(request);
%>

   <form action="<%=request.getContextPath() %>/changeToAuthor.do" name="AuthorReg" method="post" id="userForm">
       <table cellpadding="0" cellspacing="0" border="0">
	     <caption>�������������Ϣ</caption>
		 <tbody>
		 
		     <tr>
			   <th >��ʵ����:</th>
			   <td class="box"><input type="text" name="realName" /></td>
			  </tr>
			  
			 
			 <tr>
			   <th >����ѧУ:</th>
			   <td class="box"><input type="text" name="department" /></td>
			  </tr>
			 
			 <tr>
			   <th>jϵ��ʽ(�绰):</th>
			   <td class="box"><input type="text" name="phone" /></td>
			  </tr>
			</tbody>
			</table>
			
			
		<table cellpadding="0" cellspacing="0" border="0">
	     <caption>������Ŀ��Ϣ</caption>
		 <tbody>
		 
		     <tr>
			   <th >��Ŀ���:</th>
			   <td class="box"><input type="text" name="name" /></td>
			  </tr>
			  
			 
			 <tr>
			   <th class="select">��Ŀ���ͣ�</th>
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
			   <th class="select">��Ŀ��飺</th>
			   <td class="brief" colspan="2"><textarea name="brief" rows="10"  class="brief" style="width:400px;overflow-x:visible;overflow-y:visible;"></textarea></td>
			 </tr>
			</tbody>
			</table>
 <div id="regbutton">
	      <input class="button"  onmouseover="this.className='button_mouseover'" onmouseout="this.className='button'"

 type="submit" value="�ύ" name="submit" />
	   </div>  
    </form>