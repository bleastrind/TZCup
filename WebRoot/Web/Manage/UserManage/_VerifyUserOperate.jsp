<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="net.tiaozhanbei.model.*" %>
<%@ page language="java" import="java.text.SimpleDateFormat" %>
<%@page import="net.tiaozhanbei.util.UserConst;"%>
<% User noVerifyUser=(User)request.getAttribute("noVerifyUser");
		String name=noVerifyUser.getName();
		int type=noVerifyUser.getType();
		int userId=noVerifyUser.getId();
		String department=noVerifyUser.getDepartment();
		String realname=noVerifyUser.getRealName();
		String email=noVerifyUser.getEmail();
		int sex=noVerifyUser.getSex();
		String  phone=noVerifyUser.getPhone();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String  time=format.format(noVerifyUser.getRegisterTime());
		if(realname==null)
		realname=new String("未填写");
		if(email==null)
		email=new String("未填写");
		if(department==null)
		department=new String("未填写");
		if(phone==null)
		phone=new String("未填写");		
		%>


<div class="input">

<form action="<%=request.getContextPath() %>/verifyResult.do">
			<table>
			   <tr>
				<th>用户ID:</th> 
					<td><%=userId%></td>
				</tr>
				<tr>
				  <th>用户名:</th>
					<td><%=name%></td>				
				</tr>
				<tr> 
				  <th>真实姓名:</th><td><%=realname%></td> 
				</tr>
				<tr> 
				  <th>用户性别:</th><td><%
				if(sex==UserConst.Sex.FEMALE)
				out.print("女");
				else if(sex==UserConst.Sex.MALE)
				out.print("男");
				
				%> </td>
				</tr>
				<tr> <th>用户类型:</th><td>
					<%
					if(type==UserConst.Type.AUTHOR)
					out.print("参赛作者");
					else if(type==UserConst.Type.COMMONUSER)
					out.print("普通用户");
					else if(type==UserConst.Type.COMPANY)
					out.print("企业用户");
					else if(type==UserConst.Type.JUDGER)
					out.print("评为用户");
					
					%></td> 
				</tr>
					<tr> <th>email:</th><td><%=email%></td> </tr>
					<tr> <th> 联系方式:</th><td><%=phone%></td> </tr>
					<tr> <th> 企业/学校:</th><td><%=department%></td> </tr>
					<tr><th>注册时间:</th><td><%=time%></td></tr>
					<tr><th>是否允许通过审核:</th><td><input type="radio" value="false" name="isVerify" checked="checked">未通过审核
								<input type="radio" value="true" name="isVerify"/>允许通过审核 
								<input type="hidden" value=<%=userId%> name="userId"/>
								</td></tr>
					<tr><th></th><td> <input type="submit" value="提交审核结果" /> </td></tr>				
				
			</table>			
		</form>
	</div>
		
		
