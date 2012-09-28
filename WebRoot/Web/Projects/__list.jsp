<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="net.tiaozhanbei.model.*" %>
<%@page import="net.tiaozhanbei.util.Page"%>
<%@page import="net.tiaozhanbei.util.ProjectConst"%>


<ul>
<%
        String path = request.getContextPath();
		Page<Project> pagedata=(Page<Project>)request.getAttribute("page");
		pagedata.setUrlContext(request);
		for (Project project : pagedata.getDataList()) {
%>



<li class="projectshow">
	<div >
		<div class="projectshowpic">
	    <% String picpath = project.getPicPath();
		if(picpath == null){
			picpath = path + "/Web/common/images/";
			if(project.getType().startsWith(ProjectConst.Type.NATURAL))
				picpath += "shownat.jpg";
			else if(project.getType().startsWith(ProjectConst.Type.SCIENCE))
				picpath += "showsci.jpg";
			else if(project.getType().startsWith(ProjectConst.Type.SOCIETY))
				picpath += "showcul.jpg";
		}%>
		<img src="<%=picpath %>"/>
		</div>
		
		<div class="projectshowinfo">
		  <table>
		   <tr>
		     <th><span class="title"><a href="<%=path %>/project.do?projectId=<%=project.getId()%>"><%=project.getName()%></a></span></th>
		     <td><span>作者:<a href="<%=path %>/userinfo.do?Id=<%=project.getOwner().getId()%>"><%=project.getOwner().getName()%></a></span></td>
		   </tr>
		   <tr>
		     <th colspan=2><%=project.getBrief() %></th>
		    </tr>
		    <tr>
		     <th colspan=2><span>排名:<%=project.getState().getRank() %></span>
		<span>星级:<%=project.getState().getTotalStars() > 0 ? String.format("%.2f",project.getState().getTotalStars() /Double.parseDouble(Integer.toString(project.getState().getStarnum()))):
				"暂无" %></span>
		<span>票数:<%=project.getState().getVotes() %></span></th>
		    </tr>
		  </table>
		</div>
   
	</div>
</li>


		<%}%>
</ul>
<div class="pagelink">

	<%=pagedata.getHrefFormatLinks("javascript:loadlist(%d)")%>
</div>   
