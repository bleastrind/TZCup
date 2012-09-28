<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="net.tiaozhanbei.model.Vote"%>
<%@page import="net.tiaozhanbei.model.VoteItem"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Vote vote = (Vote)request.getAttribute("vote");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'vote.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<h1><bean:message key="index.vote.result"></bean:message></h1>
  	<br>
  	<img src="http://chart.apis.google.com/chart?
chs=375x150
&amp;chd=t:0<% for (VoteItem item : vote.getVoteItems()){ %>,<%=item.getVotes() %><%} %>
&amp;cht=p3
&amp;chl=<% for (VoteItem item : vote.getVoteItems()){ %>|<%=item.getContent() %><%} %>" 
alt="<%=vote.getTitle() %>" />
<br>
<% for (VoteItem item : vote.getVoteItems()){ %>
<li><%=item.getContent()%>:<%=item.getVotes()%><bean:message key="index.vote.tickets"></bean:message></li>
<%} %>
  </body>
</html>
