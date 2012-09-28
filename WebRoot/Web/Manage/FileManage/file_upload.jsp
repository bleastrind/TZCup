<%-- 
    Document   : file_upload
    Created on : 2009-2-28, 21:44:54
    Author     : Administrator
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
String path = request.getContextPath();
String current = path+"/Web/Manage";
String common = path+"/Web/common";
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


%>
<%@page contentType="text/html"  import="net.tiaozhanbei.model.FileInfo"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>JSP Page</title>
        <link href="manageright.css" rel="stylesheet" type="text/css" />
    </head>
    <body>

<div class="managebox">
  <div class="boxtitle"><bean:message key="manage.fileupload"></bean:message></div>
  <div class="boxbody">
  <div class="input">
<form action="<%=path %>/manage/uploadfile.do" method="post" ENCType="multipart/form-data" >
    <table>
	  <tr><th><bean:message key="manage.fileupload.choose"></bean:message></th><td><input type="file" name="file" id="file">
	   <% if (request.getParameter("proid")!=null) { %>
                <input type="hidden" id="proid" value="<%=request.getParameter("proid") %>" />
                <%} %>
	  </td></tr>
	  <tr><th><bean:message key="manage.fileupload.authority"></bean:message>:</th><td>
	  
	  
	             <table>
                <tr>
                    <th><bean:message key="manage.fileupload.newseditor"></bean:message></th>
                    <td><input id="ac2" type="checkbox" value="1" ></td>
                </tr>
                <tr>
                    <th><bean:message key="manage.fileupload.commonuser"></bean:message></th>
                    <td><input id="ac5" type="checkbox" value="1" ></td>
                </tr>
                <tr>
                    <th><bean:message key="manage.fileupload.judge"></bean:message></th>
                    <td><input id="ac3" type="checkbox" value="1" ></td>
                </tr>
                <tr>
                    <th><bean:message key="manage.fileupload.company"></bean:message></th>
                    <td><input id="ac4" type="checkbox" value="1" ></td>
                </tr>
            </table>
			
			
	  </td></tr>
	  <tr><th></th><td><input type="submit" 
	  value="<bean:message key="manage.fileupload.submit"></bean:message>" 
	  name="<bean:message key="manage.fileupload.upload"></bean:message>" class="submitbutton"/></td></tr>
	</table>
	</form>
   </div>
  </div>
 </div>
	
    </body>
</html>
