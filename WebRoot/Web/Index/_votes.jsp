<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="net.tiaozhanbei.model.Vote"%>
<%@page import="net.tiaozhanbei.model.VoteItem"%>
<%@page import="net.tiaozhanbei.util.VoteConst"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Vote> votes = (List<Vote>)request.getAttribute("votes");
for(Vote vote : votes){
	System.out.println(vote.getVoteItems().size());
boolean isRadio = vote.getType()==VoteConst.ItemType.RADIO;
%>

<div class="vote">
	<h5><%=vote.getTitle() %></h5>
	<p><%=vote.getDescription() %></p>
	<form id="voteForm" method="post" action="<%=path %>/vote.do?action=vote" target="_blank">
	<input type="text" style=" display:none;" name="type" value="<%=isRadio ? "radio" : "checkbox" %>"/>
	<input type="text" style=" display:none;" name="id" value="<%=vote.getId() %>" />
	<% for(VoteItem item : (Set<VoteItem>)vote.getVoteItems()){ 
%>
	    	<input type=<%=isRadio ? "radio" : "checkbox" %> name="voteItemIds" value=<%=item.getId() %> />
	    	<%=item.getContent() %></br> 
	<%	
	  } %>
	  <input type="submit" class="buttonsubmit" value="<bean:message key="index.votes.voting"></bean:message>" />
	  </form>
</div>
<%} %>
<script>
function vote(){
	
}
</script>