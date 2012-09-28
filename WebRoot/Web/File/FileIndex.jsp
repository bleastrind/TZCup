<%--
    Document   : common_list
    Created on : 2009-3-7, 22:53:14
    Author     : buaatw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="net.tiaozhanbei.model.FileInfo" %>
<%@page import="java.util.List" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=gbk">
        <title>JSP Page</title>
    </head>
    <body>
    <table>
        <% List<FileInfo> list = (List<FileInfo>) request.getAttribute("list");%>
            <% if (list != null) {%>
            <% for (FileInfo file : list) {
            %>
            <div class="file">
                <a href="<%=request.getContextPath() %>/file/download.do?fileid=<%=file.getId() %>"><%=file.getName() %></a>
            </div>
            <% }
        }%>
        </table>
    </body>
</html>
