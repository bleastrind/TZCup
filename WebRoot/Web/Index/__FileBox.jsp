<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="net.tiaozhanbei.util.Page"%>
<%@page import="net.tiaozhanbei.model.FileInfo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Page<FileInfo> filepage = (Page<FileInfo>)request.getAttribute("page");
for(FileInfo file : filepage.getDataList()){
%>
<li>
  <a href="<%=path %>/file/download.do?fileid=<%=file.getId() %>" ><%=file.getName() %></a>
</li>
<%} %>
