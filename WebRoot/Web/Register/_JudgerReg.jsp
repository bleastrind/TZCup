<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<form action="<%=request.getContextPath() %>/judgerReg.do" id="userForm">
       <table cellpadding="0" cellspacing="0" border="0">
	     <caption>请填写您的注册信息</caption>
		 <tbody>
		 
		     <tr>
			   <th >真实姓名:</th>
			   <td class="box"><input type="text" name="realname" /></td>
			  </tr>
			  
			 
			 <tr>
			   <th >所在学校/单位:</th>
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

