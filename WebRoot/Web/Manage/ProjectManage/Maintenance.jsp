<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="net.tiaozhanbei.model.FileInfo"%>
<%@page import="net.tiaozhanbei.model.Project"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<FileInfo> files = (List<FileInfo>)request.getAttribute("files");
Project project = (Project)request.getAttribute("project");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Maintenance.jsp' starting page</title>
    
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
    项目文件：
    <%for(FileInfo file : files){%>
    	<%=file.getName() %>
    	<%if(project.getShowFile().getId()!=file.getId()){ %>
     		<a href="<%=path %>/project/modify.do?action=setShowFile&id=<%=project.getId() %>&fileId=<%=file.getId() %>">
     		设为首要展示项目</a>
     		<%}%>
     		
    <%} %>
    项目进度：
    <%=project.getState().getProcess() %>
    <a href="<%=path %>/project/modify.do?action=setProcess&id=<%=project.getId() %>&process=4"/>
  </body>
</html>
