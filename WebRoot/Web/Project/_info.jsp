<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="net.tiaozhanbei.model.*" %>
<%@page import="net.tiaozhanbei.util.UserConst"%>
<%@page import="net.tiaozhanbei.service.IProjectService"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Project project =(Project) request.getAttribute("project");
User author = project.getOwner();
User user = (User) request.getSession().getAttribute("user");
FileInfo showFile = project.getShowFile();
%>

						<div class="projecttitle">
							<%=project.getName() %>
						</div>
<!-- 信息，星级评分 -->						
						<div id="infoauthor">
						
							<p>
								<strong>第一作者：</strong>
								<a href="<%=path %>/userInfo.do?id=<%=author.getId() %>">
								<%=author.getRealName() %>
								</a>
							</p>
							<p>
								<strong>Email:</strong>
								<a href="mailto:<%=author.getEmail() %>"><%=author.getEmail() %></a>
							</p>
							<p>
								<strong>所在学校：</strong>	
								<%=author.getDepartment() %>
						
							</p>
							<p>
								<strong>项目类别：</strong>
								<bean:message key="<%=project.getType() %>"/>
							</p>
							
							<!-- 星级评分 -->


							
						<div id="starvote"title="<%=project.getState().getTotalStars()%>">
<strong>投票评分：</strong>
<script type="text/javascript">
var starconf = {
        activeImageSrc: "<%=path %>/Web/Project/images/active_star.gif",
	passiveImageSrc: "<%=path %>/Web/Project/images/passive_star.gif",
	maxScore: 5,
	fn: commitvote,
	star: <%=project.getState().getStarnum() > 0? project.getState().getTotalStars() / project.getState().getStarnum():0 %>,
	messages: [
	    "Your vote have been saved.",
	    "Very bad",
	    "Bad",
	    "Good, but could be better",
	    "Good enough",
	    "Very good"
	]
    };   

$("#starvote").starVote(starconf);
$("#starvote").find("img:even").slice(0, starconf.star).css({display: "none"});
$("#starvote").find("img:odd").slice(0, starconf.star).css({display: "inline"});

function commitvote(star,e,starnum){
	$.get("<%=path %>/project/star.do?projectId=<%=project.getId()%>&star="+starnum,null,null);
}
</script>
</div>

						</div>
						
<!-- 收藏关注审查 -->						
					<div id="infobanplace">	

						<div class="infoban">
						<a name="focus" href="<%=path %>/addfocus.do?type=<%=IProjectService.AddFocusType_Favourate %>&projectId=<%=project.getId() %>">
						收藏此项目</a>	
						</div>
						<br/><br/>
						<div class="infoban">
						<a id="sendMassage" href="<%=path%>/manage/letterManage.do?action=send&receiverId=<%=project.getOwner().getId() %>">
						联系该作者
						</a></div>

						
						<%if(user!=null && user.getRoles().contains(UserConst.Authority.COMPANY)) {%>
							<br/><br/>
							<div class="infoban">
							<a alt="关注此项目您的企业将显示在右边" name="interestCompany" href="<%=path %>/addfocus.do?type=<%=IProjectService.AddFocusType_InterstCompany %>&projectId=<%=project.getId() %>">
							关注此项目</a>
							</div>

						<%} %>
						
							
						<%if(user != null && user.getRoles().contains(UserConst.Authority.JUDGER)){%>
						<br/><br/>
						<div class="infoban">
							<a name="ajax" href="<%=path %>/judgeProject.do?id=<%=project.getId() %>">
							审查此项目</a>
						</div>
						<%} %>						
						</div>
						
						
<!-- 视频图片 -->							
						<div id="picvideo">
						
<%if(showFile !=null){
						if(showFile.getType() == FileInfo.Type.Picture){ %>
						<div class="introtitle">项目图片</div>
						<div class="infopic">
							<img src="<%=path +showFile.getPath() %>"/>
						</div>
						<%} else if(showFile.getType() == FileInfo.Type.Movie){%>
						<div class="introtitle">项目视频</div>
						<div class="infovideo">
							<img src="<%=path +showFile.getPath() %>"/>
						</div>
						<%} 
						}%>
			</div>
							
							


