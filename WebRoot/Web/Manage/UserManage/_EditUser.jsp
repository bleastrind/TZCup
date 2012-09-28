<%@  page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page language="java" import="net.tiaozhanbei.model.*" %>
<%@ page language="java" import="java.text.SimpleDateFormat" %>
<%@ page language="java" import="net.tiaozhanbei.util.UserConst" %>
<%User user=(User)session.getAttribute("user");
		String name=user.getName();
		int type=user.getType();
		int userId=user.getId();
		String deparment=user.getDepartment();
		String realname=user.getRealName();
		String email=user.getEmail();
		int sex=user.getSex();
		String  phone=user.getPhone();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String  time=format.format(user.getRegisterTime()); %>
		
		
			<form action="<%=request.getContextPath() %>/manage/editOperate.do" method="post">
			<table>		
			<tr> <th>用户名:</th><td><%= name%></td> </tr>
			<tr><th>用户类型:</th><%
			if (type==UserConst.Type.AUTHOR) {%>
			<td>参赛作者</td>
			
		<%} else if (type==UserConst.Type.COMMONUSER) {%>
			<td>普通用户</td>
			
		<%}else if (type==UserConst.Type.COMPANY) {%>
			<td>企业用户</td>
			
		<%}else if (type==UserConst.Type.JUDGER) {%>
			<td>评委用户</td>			
		<%}%></tr>			
			<tr> <th>注册时间:</th><td><%=time%></td></tr>
			<tr> <th>email:</th><td><input type="text" value="<%=email%>" name="email"/></td> </tr>
			<tr><th> 企业名称/学校:</th><td><input type="text" value="<%=deparment%>" name="department"/></td> </tr>
			<tr> <th>联系方式:</th><td><input type="text" value="<%=phone%>" name="phone" /> </td>  </tr>
			<tr> <th>真实姓名:</th><td> <input  type="text" value="<%=realname%>" name="realName"/> </td>  </tr>
			<tr> <th>性别:</th><td>
				<%if(sex==UserConst.Sex.MALE)
				{%><input type="radio" checked="checked" name="sex" value=<%=sex%>/> 男
				<input type="radio" name="sex" value="<%=UserConst.Sex.FEMALE%>"/>女
				<%} else if(sex==UserConst.Sex.FEMALE){%>
				<input type="radio" name="sex" value="<%=UserConst.Sex.MALE%>"/>男
				<input type="radio" name="sex" value="<%=sex%>" checked="checked"/>女<%}%>		
			   </td></tr>
			   <tr><td></td><td><input type="submit" value="提交修改"/> </td><td><a href="index.do"><input type="button" value="取消"> </a></td> </tr>
			   	
				</table>		
			</form>

