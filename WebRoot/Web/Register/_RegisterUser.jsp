<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="net.tiaozhanbei.util.*;"%>
<%@ taglib uri ="http://struts.apache.org/tags-bean" prefix="bean" %>
		<form action="<%=request.getContextPath() %>/userRegister.do" name="regForm" method="post">
			 <table cellpadding="0" cellspacing="0" border="0">
			  <caption>����д����ע����Ϣ</caption>
		 <tbody>		 
		     <tr>
			   <th ><bean:message key="register.username"/>:</th>
			   <td class="box"><input type="text" name="name" /></td>
			   <td>
			   <p><span id="tipUser" style="display:none;" class="tip">ID</span></p>
			   <p><span id="okUser" style="display: none;" class="correct">�����û�������</span></p>
			   <p><span id="warnUserExists" style="display: none;" class="warn">���û��Ѵ���</span></p>
			   </td>
			  </tr>
			  
			 
			 <tr>
			   <th><bean:message key="register.password"/>:</th>
			   <td class="box"><input type="password" name="password" /></td>
			   <td>
			   <p><span id="tipPassword" style="display: none;" class="tip">�������������룬������6��20λ֮��</span></p>
			   <p><span id="okPassword" style="display: none;" class="correct">���������</span></p>
			   <p><span id="warnPassword" style="display: none;" class="warn">�Բ���������������ʽ������</span></p>
			   </td>
		     </tr>
			 
			 <tr>
			   <th><bean:message key="register.passwordcheck"/>:</th>
			   <td class="box"><input type="password" name="passwordcheck" /></td>
			   <td>
			   <p><span id="tipPasswordCheck" style="display: none;" class="tip">���������������룬�Ա�ȷ��</span></p>
			   <p><span id="okPasswordCheck" style="display: none;" class="correct">���������</span></p>
			   <p><span id="warnPasswordCheck" style="display: none;" class="warn">�Բ���������������ʽ������</span></p>
			   </td>
		     </tr>
			 
			 <tr>
			   <th ><bean:message key="register.sex"/>:</th>
			   
			   <td class="box">
			       <input type="radio" name="sex" value="<%=UserConst.Sex.MALE %>"  checked="checked" class="sex"/><bean:message key="register.sex.man"/>
                   <input type="radio" name="sex" value="<%=UserConst.Sex.MALE %>"  class="sex"/><bean:message key="register.sex.woman"/> 
			   </td>
			   <td></td>
			  </tr>
			 
			 <tr>
			   <th><bean:message key="register.email"/>:</th>
			   <td class="box"><input type="text" name="email" /></td>
			   <td>
			   <span id="tipMail" style="display: none;" class="tip">����������email��ַ���Ա�������ϵ��</span>
			   </td>
		     </tr>
			 
			 
			 <tr>
			   <th ><bean:message key="register.type"/>:</th>
			   
			   <td class="select" td class="select" colspan="2">
			       <input type="radio" name="type" value="<%=UserConst.Type.COMMONUSER %>" checked="checked"/><bean:message key="register.commonuser"/>
				   <input type="radio" name="type" value="<%=UserConst.Type.COMPANY %>"/><bean:message key="register.company"/>
				   <input type="radio" name="type" value="<%=UserConst.Type.AUTHOR %>" /><bean:message key="register.author"/>
				   <input type="radio" name="type" value="<%=UserConst.Type.JUDGER%>"/><bean:message key="register.judger"/>
			   </td>
			   
			  </tr>
			  <tr> <td><img src="<%=request.getContextPath() %>/validateimage.do" alt="��֤��" name="img1"/> <a href="#">�����壬�����һ��</a>  </td>     </tr>
			  <tr>  <td>  <input type="text" name="validateimage"  > </td> </tr>
			  <tr><td><input type="submit" class="button" value="<bean:message key="submit"/>" ></td>  </tr>
			  
		 </tbody>
	   </table>
		</form>

