<%@ page language="java" import="com.jspsmart.upload.*" %>
<%@ page import="net.tiaozhanbei.model.FileInfo" %>
<%@ page import="org.apache.commons.logging.*" %>
<%@page import="common.Logger"%>
<%
        try {
        	Logger logger=Logger.getLogger(null);
            FileInfo file = (FileInfo)request.getAttribute("file");
            logger.info("download file:"+file.getName());
            response.reset();
            out.clear();
            out = pageContext.pushBody();
            SmartUpload su = new SmartUpload();
            su.initialize(pageContext);
            su.setContentDisposition(null);
            logger.info(pageContext.getServletContext().getRealPath("/")+"uploadFiles\\"+file.getPath()+file.getName());
            su.downloadFile(pageContext.getServletContext().getRealPath("/")+"uploadFiles\\"+file.getPath()+file.getName());
        } catch (Exception e) {
            out.print("sorry,download fail");
        } 
%>
<html>
<div>
download!
</div>
</html>