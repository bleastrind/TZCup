<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


	<div class="boxtitle">发件箱</div>
  	<div class="boxbody">
		<div class="input">
		<form action="<%=path%>/manage/sendLetter.do" method="post">
		  <table>
		  <%if((String)request.getAttribute("receiverId") == "") {%>
		   <tr>
			<th><bean:message key="manage.letter.sendto"></bean:message>:</th>
			<td><input type="text" id="title" name="receiverName" ></td>
		   </tr>
		   <%} %>
		   <tr>
			<th><bean:message key="manage.letter.sendtitle"></bean:message>:</th>
			<td><input type="text" id="title" name="title"></td>
		   </tr>
		   <tr>
			<th><bean:message key="manage.letter.sendcontent"></bean:message>:</th>
			<td><textarea rows="8" cols="30" id="content" name="content"></textarea></td>
		</tr>
			<input type="hidden"
				value="<%=request.getAttribute("senderId")%>"
				id="senderId" name="senderId">
			<input type="hidden"
				value="<%=request.getAttribute("receiverId")%>"
				id="receiverId" name="receiverId">
			<tr>
			   <th></th>
			   <td>
			    <input type="submit"
				value="<bean:message key="manage.letter.submit"></bean:message>">
				</td>
				</tr>
			</table>
		</form>
		</div>
		</div>