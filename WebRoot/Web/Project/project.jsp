<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="net.tiaozhanbei.util.*"%>
<%@ page import="net.tiaozhanbei.model.*"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
	String path = request.getContextPath();
	String current = path + "/Web/Project";
	String common = path + "/Web/common";
	Project project = (Project) request.getAttribute("project");
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title><bean:message key="11thTZCup"/></title>
		<link href="<%=common%>/css/common.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=common%>/css/redmond/jquery-ui-1.7.1.custom.css"
			rel="stylesheet" type="text/css" />
		<link href="<%=current%>/project.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript"
			src="<%=common%>/js/jquery-1.3.2.min.js"></script>
		<script type="text/javascript" src="<%=common%>/js/jquery.form.js"></script>
		<script type="text/javascript"
			src="<%=common%>/js/jquery-ui-1.7.1.custom.min.js"></script>
		<script src="<%=common%>/js/jquery.history.js" type="text/javascript"></script>
		<script src="<%=current%>/js/project.js" type="text/javascript"></script>
		<script src="<%=current%>/js/jQuery.starVote.js" type="text/javascript"></script>
	</head>

	<body>

		<div id="serverPath" style="display: none;" title="<%=path%>"></div>
		<div id="projectId" style="display: none;"
			title="<%=project.getId()%>"></div>
		<div id="dialogerr" style="display: none;" title="Error">
			<p><bean:message key="error.failed"/></p>
		</div>
		<!--发站内信 -->
		<div id="dialogmessage" style="display: none;" title="<bean:message key="controlpanel.letter.send"/>">
			<p></p>
		</div>
		
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
				
			<div id="allright">
			
				<div id="location">
					<bean:message key="navigation.now"/>>><a href="/"><bean:message key="11thTZCup"/></a>
					>><a href="<%=path %>/projects.do"><bean:message key="index.navigation.projects"/></a>
				</div>
				
				<div id="mid">
				
					<div id="left_info">
						<jsp:include page="_info.jsp"></jsp:include>
					</div>
					
					<div class="left_intro">
						<jsp:include page="_intro.jsp"></jsp:include>					
  					</div>
					
					<div  id="professor" class="left_intro">
					</div>

					
					<div id="addcommentform">
						<div class="introtitle">
							评论
						</div>
					<jsp:include page="_addComments.jsp"></jsp:include>
					</div>
					
					
					
					<div id="normalComment" class="left_comment">
						Loading...
					</div>

					
					
					
					
					
				
				</div>


				<!--=========左侧结束========-->


				<div id="right">

					

					<div id="loginbox">
					</div>


					<div id="interestCompany" class="rightbox">
					</div>

					
					<div id="focus" class="rightbox">
						
					</div>


				</div>
				<!--=========右侧结束========-->

			</div>
			<!--=========allright结束========-->

			</div>
			<!--=========主体部分结束========-->



			<div id="footer">
				<%@ include file="../common/footer.jsp"%>
			</div>
		</div>
	</body>
</html>
