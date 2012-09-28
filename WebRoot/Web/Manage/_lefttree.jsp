<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="net.tiaozhanbei.util.datastruct.UrlTree"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
String path = request.getContextPath();
UrlTree lefttree=(UrlTree)request.getAttribute("lefttree");
//System.out.println(lefttree);
lefttree.setContextPath(request);
for (UrlTree urlTree : lefttree.getChildren()) {	
if(urlTree.getChildren().size() > 0 && "#".equals(urlTree.getValue())){
%>
<li>
	
	<a href="<%=path + urlTree.getValue() %>">
	<bean:message key="<%=urlTree.getFullName()%>"/></a>
	<%if(urlTree.getChildren()!=null){%>
	<ul>
		<%for (UrlTree children : urlTree.getChildren()) {%>

		<li>
			<a href="javascript:rightchange('<%=path + children.getValue() %>')">
			<bean:message key="<%=children.getFullName()%>"/></a>
		</li>
		<%}%>
	</ul>
	<%}%>
</li>
<%}
}%>
