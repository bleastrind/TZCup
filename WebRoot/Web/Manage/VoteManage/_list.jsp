<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="net.tiaozhanbei.model.Vote"%>
<%
String path = request.getContextPath();
@SuppressWarnings("unchecked")
List<Vote> list = (List<Vote>)request.getAttribute("list");
for(Vote vote : list){
%>
 <tr>
 <th><%=vote.getTitle() %></th>

 <td><a name="ajax" href="<%=path %>/manage/votemodify.do?action=switchEnable&voteId=<%=vote.getId() %>">
 	<% if(vote.getEnable()){ %>
 	 	停用 
 	<%}else{ %>
 		启用
 	<%} %>
 	</a></td>
 <td><a name="ajax" href="<%=path %>/manage/votemodify.do?action=del&voteId=<%=vote.getId() %>">
 删除</a></td>
 </tr>
 <%} %>
