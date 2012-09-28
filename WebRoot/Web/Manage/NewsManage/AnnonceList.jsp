<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="net.tiaozhanbei.model.News" %>
<%@ page import="net.tiaozhanbei.service.INewsService" %>
<%@page import="net.tiaozhanbei.util.Page"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<form name="AnnonceList" action="">
	<table>
		<tbody>
			<tr>
				<th>名称</th>
				<th>发布者</th>
				<th></th>
			</tr>
			<% 
				List<News> annonceList = (List<News>)request.getAttribute("annonceList");
				for (News news : annonceList) {
			%>
			<tr>	
				<td><%=news.getTitle() %></td>
				<td><%=news.getAuthor().getName() %></td>
				<td>
					<a href="${pageContext.request.contextPath}/manage/delAnnonce.do?newsid=<%=news.getId()%>">
						删除
					</a>
				</td>
			</tr>
			<% } %>
		</tbody>
	</table>
</form>