<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page language="java" import="net.tiaozhanbei.model.*"%>
<%@page import="common.Logger"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	Logger logger=Logger.getLogger(getClass());
	User user=(User)session.getAttribute("user");
	logger.info(user.getName());
	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<body>

	helloff
  	<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
			id="TZCup" width="421" height="198"
			codebase="http://fpdownload.macromedia.com/get/flashplayer/current/swflash.cab">
			<param name="movie" value="<%=path %>/Web/Upload/TZCup.swf" />
			<param name="flashVars" value="uppath=<%=basePath %>manage/uploadfile.do&sessionid=userid=<%=user.getId() %>" />	
			<param name="quality" value="high" />
			<param name="bgcolor" value="#869ca7" />
			<param name="allowScriptAccess" value="sameDomain" />
			<embed src="<%=path %>/Web/Manage/FileManage/TZCup.swf"
				flashvars="uppath=<%=basePath %>manage/uploadfile.do&sessionid=userid=<%=user.getId() %>"
				quality="high" bgcolor="#869ca7"
				width="421" height="198" name="TZCup" align="middle"
				play="true"
				loop="false"
				quality="high"
				allowScriptAccess="sameDomain"
				type="application/x-shockwave-flash"
				pluginspage="http://www.adobe.com/go/getflashplayer">
			</embed>
	</object>

</body>
</html>
