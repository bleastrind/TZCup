<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="net.tiaozhanbei.model.News" %>
<%@ page import="net.tiaozhanbei.service.INewsService" %>
<%@page import="net.tiaozhanbei.util.Page"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	Page<News> defaultpage = (Page<News>)request.getAttribute("newsPage");
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	for (News news : defaultpage.getDataList()) {
%>

<ul>
		  <li><a href="<%=news.getUrl() %>"><%=news.getTitle() %></a><span><%=dateFormat.format(news.getTime()) %></span></li>
</ul>




<% } %>

<div class="pagelink">
	<%=defaultpage.getLinks("news.do") %>
</div>   