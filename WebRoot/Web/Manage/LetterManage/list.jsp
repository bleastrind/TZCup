<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="net.tiaozhanbei.model.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


		<%
			List<Letter> list = (List<Letter>) request.getAttribute("list");
			String action = request.getParameter("action");
		%>
	<div class="boxtitle">发件箱</div>
  	<div class="boxbody">
		<div class="list">
         <table  >
			<tr>

				<td>
					发件人
				</td>
				<th>
					标题
				</th>
				<td>
					发件时间
				</td>
			</tr>
		<%
			if (action.equals("receive")) {
		%>


		
			<%
				//发件箱
					for (Letter letter : list) {
			%>
			<tr>

			<td><%=letter.getSender().getName()%></td>
			<th><a
				href="javascript:rightchange('<%=path%>/manage/viewLetter.do?action=send&letterId=<%=letter.getId()%>')"><%=letter.getTitle()%></a>
			<%=letter.getTime()%></th>
			</tr>



			<%
				//收件箱
					}
				} else {
			%>
			<%
				for (Letter letter : list) {
			%>
			<tr>

			<td><%=letter.getReceiver().getName()%></td>
			<th><a
				href="javascript:rightchange('<%=path%>/manage/viewLetter.do?action=receive&letterId=<%=letter.getId()%>')"><%=letter.getTitle()%></a></th>
			<td><%=letter.getTime()%></td>
			<%
				}
				}
			%>
		</table>
		
	</div>
	</div>
