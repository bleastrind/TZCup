/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package net.tiaozhanbei.action.manage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.tiaozhanbei.action.BaseAction;
import net.tiaozhanbei.model.*;
import net.tiaozhanbei.util.CommonResources;
import net.tiaozhanbei.util.datastruct.UrlTree;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 03-02-2009
 * 
 * XDoclet definition:
 * @struts.action
 */
public class ProjectManageAction extends BaseAction {
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
	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("projectId");
		Project project =getProjectService().getProject(Integer.parseInt(id));
		request.setAttribute("project", project);
		return mapping.findForward("modify");
	}
	
	public ActionForward mylist(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		User user = (User)request.getSession().getAttribute("user");
		user = getUserService().getUserById(user.getId());
		request.setAttribute("myproject", user.getMyProjects());
		return mapping.findForward("mylist");
	}
	public ActionForward favorlist(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		User user = (User)request.getSession().getAttribute("user");
		user = getUserService().getUserById(user.getId());
		request.setAttribute("favorateproject", user.getFavourateProjects());
		return mapping.findForward("favorlist");
	}
	
	public ActionForward regNewProject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		UrlTree tree = UrlTree.load("projectCatagory", CommonResources.getProjectCatagoryBundle());
		request.setAttribute("catagoryTree", tree);
		return mapping.findForward("regnewproject");
	}
}