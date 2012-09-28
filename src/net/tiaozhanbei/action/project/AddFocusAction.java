/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package net.tiaozhanbei.action.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.tiaozhanbei.model.User;
import net.tiaozhanbei.action.*;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



/** 
 * MyEclipse Struts
 * Creation date: 03-01-2009
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class AddFocusAction extends BaseAction {
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
		int projectId=Integer.valueOf(request.getParameter("projectId"));

		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");//从session中获取发出该操作的用户信息
		
		
			
			if (getProjectService().addFocus(projectId,user,request.getParameter("type"))) {
				request.setAttribute("message", "success");
			}else {
				request.setAttribute("message", "No such focus type");
			}
			
		
			return mapping.findForward("ajaxSuccessOrFailure");
		
		
	}
}