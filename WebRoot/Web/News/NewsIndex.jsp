<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="net.tiaozhanbei.util.*"%>
<%@page import="net.tiaozhanbei.model.*"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
	String path = request.getContextPath();
	String current = path + "/Web/Projects";
	String common = path + "/Web/common"; 
	String searchtext = (String)request.getAttribute("searchtext");
	Page<Project> pagedata=(Page<Project>)request.getAttribute("page");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>第十一届挑战杯</title>


		<link href="<%=common%>/css/common.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=current%>/projects.css" rel="stylesheet"
			type="text/css" />


	</head>

	<body>
		<div id="serverPath" style="display: none;" title="<%=path%>">
		</div>

		<div id="serverPath" style="display: none;" title="<%=path%>"></div>
		<div id="container">

			<div id="top">
					<%@ include file="../common/Topbuttons"%>
			</div>
			<!--=========页首部分结束========-->

			<div id="main">
				<div id="left">
				<%@ include file="../common/left.jsp"%>
				</div>
				<!-- 最左侧结束 -->
   				
   				<jsp:include page="_activeNews.jsp"></jsp:include>
			<!--=========主体部分结束========-->
			<div id="footer">	
						<%@ include file="../common/footer.jsp"%>

			</div>



		</div>
	</body>
</html>

 
 