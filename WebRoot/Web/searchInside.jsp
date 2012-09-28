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
					<%@ include file="./common/Topbuttons"%>
			</div>
			<!--=========页首部分结束========-->

			<div id="main">
				<div id="left">
				<%@ include file="./common/left.jsp"%>
				</div>
				<!-- 最左侧结束 -->



				<div id="allright">

					<div id="searchbox">
						<div class="rightform">
							<form method="post" action="<%=path%>/searchInside.do">
								<table>
									<tr>
										<th>
											<bean:message key="index.searchInside"></bean:message>
											:
										</th>
										<td>
											<input type="text" name="searchtext" class="inputtext" value="<%=searchtext %>"/>
										</td>
										<td>
											<input type="submit" name="searchbutton"
												value="<bean:message key="index.search"></bean:message>"
												class="loginsubmit" />
										</td>		
									</tr>
								</table>
								<input type="hidden" name="page"/>
							</form>
						</div>
					</div>

					<div id="mid">
						<div id="searchInfo" class="searchInfo">
							搜索到
							<%=pagedata.getTotalCount() %>
							项结果
						</div>
						<ul>
							<%
		pagedata.setUrlContext(request);
		for (Project project : pagedata.getDataList()) {
%>
							<li class="projectshow">
								<div>
									<div class="projectshowinfo">
										<table>
											<tr>
												<th>
													<span class="title"><a
														href="<%=path %>/project.do?projectId=<%=project.getId()%>"><%=project.getName()%></a>
													</span>
												</th>
												<td>
													<span>作者:<a
														href="<%=path %>/userInfo.do?id=<%=project.getOwner().getId()%>"><%=project.getOwner().getName()%></a>
													</span>
												</td>
											</tr>
											<tr>
												<th colspan=2><%=project.getBrief() %></th>
											</tr>
										</table>
									</div>

								</div>
							</li>
							<%}%>
						</ul>
						<div class="pagelink">

							<%=pagedata.getHrefFormatLinks("javascript:post(%d)")%>
						</div>

					</div>
					<!--=========左侧结束========-->

				</div>
				<!--=========allright结束========-->
			</div>
			<!--=========主体部分结束========-->
			<div id="footer">	
						<%@ include file="./common/footer.jsp"%>

			</div>


			<script>
				function post(page){
				$("form input[name='page']").attr("value",page);
				alert(page);
				$("form")[0].submit();
				}
			</script>

		</div>
	</body>
</html>
