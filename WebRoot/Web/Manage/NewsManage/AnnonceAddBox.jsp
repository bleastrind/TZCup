<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

			<div class="boxtitle">用户个人信息修改</div>
			<div class="boxbody">
			<div class="input">
<form name="addNews" method="post" action="<%=path %>/manage/addAnnonce.do">
	<table width="100%" align="left">
		<tbody>
			<tr>
				<th>消息内容:</th>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<th></th><td><input type="submit" name="submit" value="提交"></td>
			</tr>
		
		</tbody>
	</table>
</form>
</div>
</div>

