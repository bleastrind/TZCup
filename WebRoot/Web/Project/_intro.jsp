<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="net.tiaozhanbei.model.*" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Project project =(Project) request.getAttribute("project");

List<FileInfo> files = (List<FileInfo>)request.getAttribute("files");
%>	

			<div id="intro">
					<div class="introtitle">
							项目介绍
					</div>
					<div><%=project.getDetal() %>
					</div>
			</div>			
						

			<div id="file">			
					<div class="introtitle">
						项目文件
					</div>
					<div>
					  <ul>
						<%for(FileInfo file : files){ %>
							<li>
							<a href="<%=path %>/file/download.do?fileid=<%=file.getId() %>" ><%=file.getName() %>
							</a>
							</li>
						<%} %>
					   </ul>
					</div>
			</div>			

