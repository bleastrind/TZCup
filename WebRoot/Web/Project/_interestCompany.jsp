<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="net.tiaozhanbei.model.User"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Set<User> companies = (Set<User> )request.getAttribute("company");
%>

						<div class="rightbox_title">
							对此项目感兴趣的企业
						</div>
						<div class="rightbox_body">
							<ul>
								<%for(User company : companies){ %>
						<li><a href="<%=path %>/userInfo.do?id=<%=company.getId() %>">
						<%=company.getRealName() %>
						</a>
						
						</li>
						<%} %>
							</ul>
						</div>