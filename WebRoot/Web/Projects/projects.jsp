<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="net.tiaozhanbei.util.*"%>
<%@page import="net.tiaozhanbei.util.datastruct.UrlTree" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
	String path = request.getContextPath();
	String current = path + "/Web/Projects";
	String common = path + "/Web/common";
	UrlTree catagoryTree=(UrlTree)request.getAttribute("catagoryTree");
//System.out.println(lefttree);
catagoryTree.setContextPath(request);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>第十一届挑战杯</title>
		
		<link href="<%=common%>/css/redmond/jquery-ui-1.7.1.custom.css"
			rel="stylesheet" type="text/css" />
		<link href="<%=common%>/css/common.css" rel="stylesheet" type="text/css" />
		<link href="<%=current%>/projects.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript"
			src="<%=common%>/js/jquery-1.3.2.min.js"></script>
		<script type="text/javascript"
			src="<%=common%>/js/jquery-ui-1.7.1.custom.min.js"></script>


		<script src="<%=common%>/js/jquery.history.js" type="text/javascript"></script>
		<script src="<%=current%>/projects.js" type="text/javascript"></script>
	</head>

	<body>
	<div id="serverPath" style="display: none;" title="<%=path%>">
		</div>
		
		<div id="serverPath" style="display: none;" title="<%=path%>"></div>
		<div style="display:none;">
			<form id="requireform">
			<%String orderBy = request.getParameter("orderBy");
			String catalog = request.getParameter("catalog");
			%>
				<input type="text" name="orderBy" value="<%=orderBy == null ? "" : orderBy %>" />
				<input type="text" name="catalog" value="<%=catalog == null ? "" : catalog %>" />
			</form>
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
				您现在的位置>><a href="<%=path %>/index.do">第十一届挑战杯官方网站</a>
				>><a href="<%=path %>/projects.do">项目展示</a>
			</div>
					
				<div id="mid">
		
					<div id="left_option" class="left_option">

					</div>
					<div id="left_project">
						<div id="tabs">
							<ul>
							<%
							int count = 0; 
							for (UrlTree tree : catagoryTree.getChildren()) {
								count ++; 
							%>

								<li>
									<a name="<%=tree.getFullName() %>" href="#tabs-<%=count %>"><bean:message
											key="<%=tree.getFullName() %>" /> </a>
								</li>
							<%} %>
							</ul>
							<%
							count = 0;
							for (UrlTree tree : catagoryTree.getChildren()) {
								count ++;
							%>
							
							<div id="tabs-<%=count %>">
								<!-- 科技发明类-->
								<table>
									<tr>
										<td>
											<a href="called by javascript"
												name="<%=tree.getFullName() %>"> <bean:message
													key="<%=tree.getFullName() %>" /> </a> &nbsp;&nbsp;
										</td>
										<%
										for (UrlTree child : tree.getChildren()) {
										 %>
										<td>
											<a href="called by javascript"
												name="<%=child.getFullName()%>"> <bean:message
													key="<%=child.getFullName()%>" /> </a>
											&nbsp;&nbsp;
										</td>
										<%} %>
									</tr>
								</table>
							</div>
							<%} %>		
						</div>
					</div>
					<div>
						<table>
							<tr>
								<td>
									排序方式
								</td>
								<td>
									<select id="orderBy" size="1">
										<option value="time">
											按时间
										</option>
										<option value="rank">
											按排名
										</option>
										<option value="vote">
											按投票
										</option>
										<option value="visit">
											按点击率
										</option>
									</select>
								</td>
							</tr>
						</table>
					</div>
					<div id="left_main" class="left_main">
						<div id="projectslist">
						</div>

					</div>
					<div id="left_bottom" class="left_bottom" style="display:none;">

					</div>
				</div>
				<!--=========左侧结束========-->


				<div id="right">

					


					<div class="rightbox">
						<div class="rightbox_title">最新项目
						</div>
						<div class="rightbox_body">
							<ul>
								<li>
									<a href="#">打算范德萨</a>
								</li>
								<li>
									<a href="#">范德萨个的撒</a>
								</li>
								<li>
									<a href="#">的撒范德萨范德萨啊范德萨 </a>
								</li>
								<li>
									<a href="#">暂无</a>
								</li>
								<li>
									<a href="#">暂无</a>
								</li>
							</ul>
						</div>
						<div class="more">
							<a href="#">更多>></a>
						</div>
					</div>

					<!-- 关注项目 -->
					<div id="focus">
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
