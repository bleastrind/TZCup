<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%-- 
    Document   : file_access
    Created on : 2009-3-8, 15:39:59
    Author     : buaatw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="net.tiaozhanbei.model.FileInfo"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="gbk">
        <title>file_access</title>
    </head>
    <body>
        <%
        int ac2 = (Integer) request.getAttribute("ac2");
        int ac3 = (Integer) request.getAttribute("ac3");
        int ac4 = (Integer) request.getAttribute("ac4");
        int ac5 = (Integer) request.getAttribute("ac5");
        FileInfo fileinfo = (FileInfo) request.getAttribute("fileinfo");
        %>
        <form action="<%=request.getContextPath() %>/manage/fileAccess.do" method="post" >
            <table>
                <tr>
                    <td> <%=fileinfo.getName()%> </td>
                </tr>
                <tr>
                    <th><bean:message key="manage.fileacess.newseditor"></bean:message></th>
                    <td><input id="ac2" name="ac2" type="checkbox" value="1" <%=(ac2 == 1 ? "checked" : "")%>></td>
                </tr>
                <tr>
                    <th><bean:message key="manage.fileacess.commonuser"></bean:message></th>
                    <td><input id="ac5"  name="ac5" type="checkbox" value="1" <%=(ac5 == 1 ? "checked" : "")%>></td>
                </tr>
                <tr>
                    <th><bean:message key="manage.fileacess.judge"></bean:message></th>
                    <td><input id="ac3"  name="ac3" type="checkbox" value="1" <%=(ac3 == 1 ? "checked" : "")%>></td>
                </tr>
                <tr>
                    <th><bean:message key="manage.fileacess.company"></bean:message></th>
                    <td><input id="ac4"  name="ac4" type="checkbox" value="1" <%=(ac4 == 1 ? "checked" : "")%>></td>
                </tr>
            </table>
            <input type="hidden" id="ac1" name="ac1" value="1" >
			<input type="hidden" id="fileid"  name="fileid" value="<%=fileinfo.getId() %>" >
            <input type="submit" name="<bean:message key="manage.fileacess.save"></bean:message>"  >
        </form>
    </body>
</html>
