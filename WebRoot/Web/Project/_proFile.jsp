<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="net.tiaozhanbei.model.FileInfo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<FileInfo> list=(List<FileInfo>)request.getAttribute("list");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%for(FileInfo file:list){ %>
	<a href="<%=path %>/file/download.do?fileid=<%=file.getId() %>" ><%=file.getName() %></a>
	<br>	
<% }%>