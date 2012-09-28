<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="net.tiaozhanbei.model.ProjectComment"%>
<%@page import="net.tiaozhanbei.util.Page"%>
<%@ page import="net.tiaozhanbei.model.User"  %>
<%@ page language="java" import="java.text.SimpleDateFormat" %>
<%@page import="net.tiaozhanbei.util.UserConst"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Page<ProjectComment> commentslist=(Page<ProjectComment>)request.getAttribute("normalCommentList");
commentslist.setUrlContext(request);
%>

<%		
		boolean addmark=Boolean.parseBoolean(request.getAttribute("addmark").toString());
		boolean deletevisiable=Boolean.parseBoolean(request.getAttribute("deletevisiable").toString());
		System.out.println("从action传过来的"+addmark+deletevisiable);
		Iterator iterator=commentslist.getDataList().iterator();
		ProjectComment comment;
		String title;
		User author;
		String content;
		int id=0;
		int commentId;
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String commentDate;
		String authorname;
		int projectId=Integer.parseInt(request.getAttribute("projectId").toString());
		while (iterator.hasNext()) {
			id=0;
			comment=(ProjectComment)iterator.next();
			title=comment.getTitle();
			content=comment.getContent();
			commentDate=format.format(comment.getTime());
			author=comment.getAuthor();
			commentId=comment.getId();
			if(author==null){
				authorname = "游客";
			
			}
			else{
			 authorname=author.getName();
			 id=author.getId();	}
			
			%><table>
			      <tr>
			        <th>
			            <span>题目:<%= title%></span> 
			            <a  href="#content" onclick="writeback('<%=authorname %>')" > [回复]</a>
			        <% 
					  		if(deletevisiable==true)
					  {%>
					  <a href="deleteComment.do?commentId=<%=commentId %>&projectId=<%=projectId %>" >[删除]</a><%} %>
					  <%if(addmark==true){ %>
					  <a  href="addmark.do?id=<%=id%>&projectId=<%=projectId%>">[评论很精彩，给他10分!]</a><%} %>
					  </th>
			        <td>评论者:<a  href="userInfo.do?id=<%=id%>" id="<%=id %>" > <%=authorname %> </a></td>
			       </tr>
			       <tr>
			        <th><%=content%></th>
			        <td><%=commentDate %></td>
			       </tr>
			  </table>
					  
			
			<%		
			
		}
  %>
  <div class="pagelink">
  <%= commentslist.getHrefFormatLinks("javascript:loadnormalComment("+projectId+",?)") %>
  </div>
