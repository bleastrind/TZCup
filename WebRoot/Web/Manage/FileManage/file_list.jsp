<%-- 
    Document   : common_list
    Created on : 2009-3-7, 22:53:14
    Author     : buaatw
--%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
String path = request.getContextPath();
String current = path+"/Web/Manage";
String common = path+"/Web/common";
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<%@page contentType="text/html" import="net.tiaozhanbei.model.FileInfo"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=gbk">
        <title>JSP Page</title>

        <link href="manageright.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <% List<FileInfo> list = (List<FileInfo>) request.getAttribute("list");%>
        <div class="managebox">
  		<div class="boxtitle"><bean:message key="manage.filelist"></bean:message></div>
  		<div class="boxbody">
   		<div class="list">
        <table>
            <tr class="listtitle">
                <td><bean:message key="manage.filelist.name"></bean:message></td>
                <td><bean:message key="manage.filelist.authority"></bean:message></td>
                <td><bean:message key="manage.filelist.download"></bean:message></td>
                <td><bean:message key="manage.filelist.delete"></bean:message></td>
            </tr>
            <% if (list != null) {%>
            <% for (FileInfo file : list) {
            %>
            <tr>
                <th><%=file.getName()%> </th>
                <td><a name="ajax" href="<%=path %>/manage/fileAccess.do?fileid=<%=file.getId() %>"  target="_blank">~-~</a></td>
                <td><a href="<%=path %>/file/download.do?fileid=<%=file.getId()%>" target="_blank">下载! </a></td>
                <td><a name="ajax" href="<%=path %>/manage/delFile.do?fileid=<%=file.getId() %>" >DEL</a></td>
            </tr>
            <% }
        }%> 
        </table>
        </div>
       </div>
      </div>
    </body>
</html>
