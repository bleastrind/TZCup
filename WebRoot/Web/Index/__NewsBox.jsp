<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="net.tiaozhanbei.model.*" %>
<%@page import="net.tiaozhanbei.util.Page"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
		Page<News> news=(Page<News>)request.getAttribute("news");
		for (News newss : news.getDataList()) {
%>
  <li><a href="<%=newss.getUrl() %>"><%=newss.getTitle() %></a>
  <span id="data"><%=new SimpleDateFormat("MM-dd").format(newss.getTime()) %></span></li>
<%}%>

