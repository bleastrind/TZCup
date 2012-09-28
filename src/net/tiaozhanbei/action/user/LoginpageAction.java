/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package net.tiaozhanbei.action.user;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.tiaozhanbei.action.BaseAction;
import net.tiaozhanbei.model.User;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 03-29-2009
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 * @struts.action-forward name="loginpage" path="/Web/Login.jsp"
 */
public class LoginpageAction extends BaseAction {
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
	
		//�Զ���½
		User user=(User)request.getSession().getAttribute("user");
		if(user==null)
		{
			Cookie cookies[]=request.getCookies();
			String username=null;
			String password=null;
			Cookie cookie;
			if(cookies!=null){
				for (int i = 0; i < cookies.length; i++) {
					cookie=cookies[i];
					if("username".equals(cookie.getName()))
					{
						username=cookie.getValue();
		
					}
					else if("password".equals(cookie.getName())) {
						password=cookie.getValue();
		
						
					}
				}
			}
			User user2=new User();
			user2.setName(username);
			user2.setPassword(password);
			user=getUserService().login(user2);
			if(user!=null){
				request.getSession().setAttribute("user", user);
				request.setAttribute("oldurl", request.getParameter("oldurl"));
				return mapping.findForward("redirect");
			}
		}

		
		return mapping.findForward("loginpage");
	}
}