<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String oldurl=(String)request.getAttribute("oldurl");
System.out.print(oldurl);
		if(oldurl!=null)
		response.sendRedirect(oldurl);
		else 
		{
		oldurl="/TZCup/index.do";
		response.sendRedirect(oldurl);
		}
		
%>
