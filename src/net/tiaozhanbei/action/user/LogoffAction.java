/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package net.tiaozhanbei.action.user;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.tiaozhanbei.action.BaseAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



/** 
 * MyEclipse Struts
 * Creation date: 03-18-2009
 * 
 * XDoclet definition:
 * @struts.action input="/Web/Login.jsp" validate="true"
 * @struts.action-forward name="success" path="/Web/testSuccess.jsp"
 */
public class LogoffAction extends BaseAction {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	
		Cookie cookies[]=request.getCookies(); 
		
		Cookie cookie=null; 
	
		String name=null; 
		System.out.println("ע���û���ʼ");
		for(int i=0;i<cookies.length;i++){ 
			cookie=cookies[i]; 
			name=cookie.getName(); 
			if (name.equals("username")) {
				cookie.setMaxAge(0);
				System.out.println("�û���"+cookie.getValue());
				cookie.setValue(null);			
				System.out.println("ɾ����"+cookie.getValue());
				response.addCookie(cookie);

			
		
				}else if(name.equals("password")){
				cookie.setMaxAge(0);
				cookie.setValue(null);
				response.addCookie(cookie);
				System.out.println("ɾ������");
			}

		}
		request.getSession().removeAttribute("user");
		System.out.println("ע���ɹ���");
		
		
		return mapping.findForward("index");
	}
}