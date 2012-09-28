<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page  language="java" import="net.tiaozhanbei.model.User" %>
<%@ page  language="java" import="net.tiaozhanbei.util.*" %>
<%@ page language="java" import="net.tiaozhanbei.model.*" %>

    <% @SuppressWarnings("unchecked") 
    User user=(User)request.getAttribute("userInfo");
    String path = request.getContextPath();

    %>
    <table border=1 >
  	<tr><th>用户信息显示：</th></tr>
  	<tr><td>用户名：<%=user.getName()%></td></tr>
	<tr><td>真实姓名：<%=user.getRealName()%></td></tr>
	<tr><td>性别：<%if (user.getSex()==UserConst.Sex.MALE) {
						out.write("男");
					} else if(user.getSex()==UserConst.Sex.FEMALE){out.write("女");}%>
	</td></tr>
	<tr><td>联系方式：<%= user.getPhone()%> </td> </tr>
	<tr><td>注册时间：<%= user.getRegisterTime()%> </td> </tr>
	<tr><td>电子邮件：<%= user.getEmail()%> </td></tr>
	<tr><td>工作地点:<%=user.getDepartment()%></td></tr>
	<tr><td>该用户参加的项目：<% 
	if(user.getMyProjects().size()>0)
		for(Project project:user.getMyProjects()){
			%>
			<a href="project.do?projectId=<%=project.getId()%>"><%=project.getName()%></a>
			<%
		}
		else
		 out.print("该用户未参加任何项目");
		%>  
	        </td>   </tr>
	        <tr> <td> <a id="sendMassage" href="<%=path%>/manage/letterManage.do?action=send&receiverId=<%=user.getId() %>">
						联系ta
						</a> </td>  </tr>
  </table>
   
