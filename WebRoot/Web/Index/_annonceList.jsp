<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="net.tiaozhanbei.model.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
	List<News> annonceList = (List<News>)request.getAttribute("annonceList");
	for (News news : annonceList) {
%>
	<p><%=news.getTitle() %></p>
<% } %>