<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="net.tiaozhanbei.util.VoteConst"%>
<%
String path = request.getContextPath();

String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

     <div class="boxtitle">新建投票</div>
      <div class="boxbody">
       <div class="input">
		<form action="<%=path %>/manage/addvote.do" method="post">
		   <table>
		   <tr>
			<th>discription:</th><td><textarea name="discription" rows="3"></textarea></td>
		   </tr>
		   <tr>
			<th>type:</th><td><input type="radio" name="type" value="<%=VoteConst.ItemType.RADIO %>" />
					单选
					<input type="radio" name="type" value="<%=VoteConst.ItemType.CHECKBOX %>" />
					多选</td>
			</tr>
			
			<tr>		
			 <th>title:</th><td><input type="text" name="title"/></td>
			 </tr>
			<tr>
			 <th>choices:</th><td><input type=text name="choices"/></td>
			</tr>
			<tr>
			 <th></th><td><input type=text name="choices"/></td>
			</tr>
			<tr>
			 <th></th><td><input type=text name="choices"/></td>
			</tr>
			 <tr>
			 <th></th><td><input type=text name="choices"/></td>
			</tr>
			<tr>
			 <th></th><td><input type=text name="choices"/></td>
			</tr>
			<tr>
			 <th></th><td><input type=submit value="submit"/></td>
			</tr>
			 
			</table>
		</form>
		</div>
		</div>

