<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="net.tiaozhanbei.model.News" %>
<%@ page import="net.tiaozhanbei.service.INewsService" %>
<%@page import="net.tiaozhanbei.util.Page"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="boxtitle">新闻列表</div>
      <div class="boxbody">
<form name="NewList" action="">
	<table>
		<tbody>
			<tr>
				<th>名称</th>
				<th>时间</th>
			</tr>
<%
	Page<News> newsPage = (Page<News>)request.getAttribute("newsPage");
	newsPage.setUrlContext(request);
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	for (News news : newsPage.getDataList()) {
%>

			<tr>
				<td><a href=<%=news.getUrl() %>><%=news.getTitle() %></a></td>
				<td><%=dateFormat.format(news.getTime()) %></td>
				<td><a href="<%=path %>/manage/delNews.do?newsid=<%=news.getId()%>">删除</a></td>
			</tr>


	<% } %>
		</tbody>
	</table>
</form>
</div>
<div class="pagelink">
	<%=newsPage.getLinks("/news.do?action=list") %>
</div>   