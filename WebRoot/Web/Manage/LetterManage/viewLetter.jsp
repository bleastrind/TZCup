<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="net.tiaozhanbei.model.*" %>
<%@ page import="org.apache.log4j.Logger" %>
<%
Logger logger=Logger.getLogger("viewLetter");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Letter letter=(Letter)request.getAttribute("letter");
logger.debug("letter:"+letter.getTitle());
logger.debug("letter:"+letter.getContent());
String viewer;
String action=(String)request.getParameter("action");
if(action.equals("send")) viewer="接收者";
	else viewer="发送者";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
 	标题：<%=letter.getTitle()+"" %>
	<%=viewer+"" %>：<a><%=letter.getSender().getName()+"" %></a>
	发送时间：<%=letter.getTime()+"" %>
	内容：<%=letter.getContent()+"" %>
	<a > 返回</a>
	<a name="ajax" href="<%=path %>/delLetter.do?action=<%=action %>&letterId=<%=letter.getId() %>" >删除</a>
	
  </body>
</html>
