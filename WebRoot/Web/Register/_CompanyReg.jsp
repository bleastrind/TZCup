<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
    <form action="<%=request.getContextPath() %>/companyReg.do" name="AuthorReg" method="post" id="userForm">
       <table cellpadding="0" cellspacing="0" border="0">
	     <caption>企业用户信息注册</caption>
		 <tbody>
		 
		     <tr>
			   <th >真实姓名:</th>
			   <td class="box"><input type="text" name="realname" /></td>
			  </tr>
			  
			 
			 <tr>
			   <th >企业名称:</th>
			   <td class="box"><input type="text" name="department" /></td>
			  </tr>
			 
			 <tr>
			   <th>联系方式(电话):</th>
			   <td class="box"><input type="text" name="phone" /></td>
			  </tr>
			</tbody>
			</table>
	   
	   
	   
	   
	   <div id="regbutton">
	      <input class="button"  onmouseover="this.className='button_mouseover'" onmouseout="this.className='button'"

 type="submit" value="提交" name="submit" />
	   </div>  
    </form>


