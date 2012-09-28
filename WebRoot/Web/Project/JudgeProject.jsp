<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="net.tiaozhanbei.model.ProjectComment"%>
<%@page import="net.tiaozhanbei.model.Project"%>
<%@page import="net.tiaozhanbei.model.ProjectScore"%>
<%
String path = request.getContextPath();
	String current = path + "/Web/Project";
	String common = path + "/Web/common";
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

ProjectComment comment =(ProjectComment) request.getAttribute("comment");
ProjectScore score= (ProjectScore) request.getAttribute("score");
Integer projectId = (Integer) request.getAttribute("projectId");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'JudgeProject.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<link href="<%=common%>/css/common.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=common%>/css/redmond/jquery-ui-1.7.1.custom.css"
			rel="stylesheet" type="text/css" />
		<link href="<%=current%>/project.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript"
			src="<%=common%>/js/jquery-1.3.2.min.js"></script>
		<script type="text/javascript" src="<%=common%>/js/jquery.form.js"></script>
		<script type="text/javascript"
			src="<%=common%>/js/jquery-ui-1.7.1.custom.min.js"></script>
		<script src="<%=current%>/js/judge.js" type="text/javascript"></script>

  </head>
  
  <body>
    <form action="<%=path %>/project/judge.do?id=<%=projectId %>">
		<input type="text" name="projectId" value="<%=projectId %>"/>
    	<input type="text" name="commentId" value="<%=comment==null ? "" : comment.getId() %>"/>
    	打分：<input type="text" name="score" value="<%=score==null ? "" : score.getScore() %>"/>
    	点评：
    	标题：<input type="text" name="title" value="<%=comment==null ? "" : comment.getTitle() %>"/><p>
    	内容:<input type="text" name="content" value="<%=comment == null ? "":comment.getContent() %>"/>
    	<input type="submit" />
    </form>
  </body>
</html>
