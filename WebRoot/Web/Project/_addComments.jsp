<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//int projectId=Integer.parseInt(request.getAttribute("projectId").toString());
	int projectId=Integer.valueOf(request.getParameter("projectId"));
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


%>

<div class="addcomment">			
			<form action="<%=request.getContextPath() %>/project/addComment.do?projectId=<%=projectId %>" method="post" id="addcommentForm">
			<input type="hidden" name="writeback" id="writeback" >
			<input type="hidden" name="receivernameId" id="receiverId">
			<input type="hidden" name="receivername" id="receivername">
			<input type="hidden" name="url" value="<%=basePath %>/project.do?projectId=<%=projectId %>">
			<table>
			 <tr>
				<th>评论题目：</th><td><input type="text" class="inputtext" name="title"></td>
			 </tr>
			 <tr> 
				<th>评论内容：</th><td><textarea rows=5 class="inputtext" name="content" id="content"></textarea><p></p></td>
			 </tr>
			 
			 <tr>	
				<th></th>
				<td><input type="submit" value="发表评论" >
				<input type="reset" value="清空"></td>
			</tr>
			</table>	
			</form>			
		</div>