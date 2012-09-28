<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="net.tiaozhanbei.util.UserConst"%>
<%@ page language="java" import="net.tiaozhanbei.model.*"%>
<%@ page language="java" import="java.text.SimpleDateFormat" %>
<%@page import="net.tiaozhanbei.util.Page"%>
	<% Page<User> userlist=(Page<User>)request.getAttribute("userlist");
		userlist.setUrlContext(request);
		Iterator it = userlist.getDataList().iterator();
		User user = new User();
		
	 %>
<div class="boxtitle">用户列表</div>
  <div class="boxbody">
<div class="list">	 
   <table>
	<tr class="listtitle">
		 <td>用户ID</td> <td>用户名</td> <td>用户类型</td> <td>注册时间</td> <td>是否通过审核</td><td>操作</td> </tr>
		
<% while(it.hasNext()){
		user=(User)it.next();
		int userId=user.getId();
		String name=user.getName();
		int type=user.getType();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String regDate=format.format(user.getRegisterTime());
		boolean verify=user.isVerify();
		%><tr><td><%=userId%></td> <td><%=name%></td>
		<td>
		<%
		if (type==UserConst.Type.AUTHOR) {
		out.print("参赛作者");
			
		} else if(type==UserConst.Type.COMMONUSER){
			out.print("普通用户");
		}
		else if (type==UserConst.Type.COMPANY) {
			out.print("企业用户");
		}else if(type==UserConst.Type.JUDGER){
			out.print("评委用户");
		}%></td>
		<td><%=regDate%>
	</td>
		<td><% if(verify==false) out.print("否");
		else out.print("是"); %></td>
		<td> <a href="javascript:rightchange('<%=request.getContextPath() %>/manage/user/userverify.do?userId=<%=userId%>')">开始审核</a> </td>  </tr>
		<%}%>
	</table>
	<div id="page">
	<%=userlist.getLinks("/manage/user/noVerifyUserList.do") %>
	</div>
</div>
</div>

 