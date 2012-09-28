<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
	String path = request.getContextPath();
	String current = path + "/Web/Index";
	String common = path + "/Web/common";
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title><bean:message key="11thTZCup"></bean:message></title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="挑战杯官网,11届">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript"
			src="<%=common%>/js/jquery-1.3.2.min.js"></script>
		<script type="text/javascript"
			src="<%=common%>/js/jquery-ui-1.7.1.custom.min.js"></script>
		<script src="<%=current%>/index.js" type="text/javascript"></script>
		
		<link href="<%=common%>/css/common.css" rel="stylesheet" type="text/css" />
		<link href="<%=current%>/index.css" rel="stylesheet" type="text/css" />
		<link href="<%=common%>/css/redmond/jquery-ui-1.7.1.custom.css"/>

	</head>

	<body>
		<!-- This element is used to help js code to locate the path of the server-->
		<div id="serverPath" style="display: none;" title="<%=path%>">
		</div>

		<div id="container">


			<div id="top">	
				<%@ include file="../common/Topbuttons"%>

				<div id="topcontent">
				
					<p><bean:message key="index.welcomeToFirstPage"></bean:message></p>
					<p/><div id="clock">表</div>


					<div id="searchbox">
						<div class="rightform">
							<form action="<%=path %>/searchInside.do">
								<table>
									<tr>
										<th>
											<bean:message key="index.searchInside"></bean:message>:
										</th>
										<td>
											<input type="text" name="searchtext" class="inputtext" />
										</td>
										<td>
											<input type="submit" name="searchbutton" 
											value="<bean:message key="index.search"></bean:message>"
												class="loginsubmit" />
										</td>
									</tr>
								</table>
							</form>
						</div>
					</div>

				</div>


			</div>
			<!--=========页首部分结束========-->

			<div id="main">

				<div id="left">
						<%@ include file="../common/left.jsp"%>
				</div>
				<!-- 最左侧结束 -->




			<div id="mid">
					<div id="newspic">

						<jsp:include page="_newsPic.jsp"></jsp:include>

						</div>

			

					<div id="newslist">
						<div class="listtitle">
							<div class="colorban">
								<bean:message key="index.news"></bean:message>
							</div>
							<div class="listmore">
								<a href=""><bean:message key="moreInfo"></bean:message></a>
							</div>
						</div>
						<div class="listbody">
							<ul id="newslistcontext">
								<li>
									Loading...
								</li>

						</ul>
						</div>
					</div>

					<div id="projectlist">

		   			 <div class="listtitle">

							<div name="ajax" id="#science" class="onban">
								<bean:message key="index.scienceAndTech"></bean:message>
							</div>
							<div name="ajax" id="#natrual" class="offban">
								<bean:message key="index.naturalScience"></bean:message>
							</div>
							<div name="ajax" id="#society" class="offban">
								<bean:message key="index.societyAndHuman"></bean:message>
							</div>
							<div class="listmore">
								<a href="<%=path%>/projects.do"><bean:message key="moreInfo"></bean:message></a>
							</div>
						
				
					</div>
						<div class="listbody">
						</div>

				    </div>
				 
				 
			</div>
				<!-- 中间结束 -->



				<div id="right">





					<div id="loginbox">

					</div>

					<div id="anounce">
						Loading...
					</div>
					<div class="rightbox">
						<div class="rightbox_title">
							<bean:message key="index.navigation.fileDownload"/>
						</div>
						<div class="rightbox_body">
							<ul id="files">
								<li>
									Loading...
								</li>
								<!--  TO BE Loaded Like:
		    <li><a href="#">第十一届挑战杯竞赛会徽、VI、吉祥物征集报名表</a></li>
			<li><a href="#">第十一届挑战杯竞赛主题口号应征报名表</a></li>
			<li><a href="#">第十一届挑战杯竞赛会歌征集报名表 </a></li>
			<li><a href="#">暂无</a></li>
			<li><a href="#">暂无</a></li>
			-->
							</ul>
						</div>
						<div class="more">
							<a href="#"><bean:message key="moreInfo"/></a>
						</div>
					</div>

					<div class="rightbox">
						<div class="rightbox_title">
							<bean:message key="index.navigation.latestVote"/>
						</div>
						<div class="rightbox_body">
							<ul id="votes">
								<li>
									Loading..
								</li>
							
							</ul>
						</div>
					</div>



				</div>
				<!--=========右侧结束========-->


			</div>
			<!--=========主体部分结束========-->



			<div id="footer">

				<%@ include file="../common/footer.jsp"%>

			</div>

    </div>
	</body>
</html>
