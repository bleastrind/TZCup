/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package net.tiaozhanbei.action.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import net.tiaozhanbei.action.*;

import net.tiaozhanbei.model.ProjectComment;
import net.tiaozhanbei.model.ProjectScore;
import net.tiaozhanbei.model.User;

/** 
 * MyEclipse Struts
 * Creation date: 03-20-2009
 * 
 * XDoclet definition:
 * @struts.action
 */
public class JudgeProjectAction extends BaseAction {
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
		int projectId =Integer.parseInt( request.getParameter("id"));
		User author =(User) request.getSession().getAttribute("user");

		ProjectComment comment = getProjectService().getMyComment(author, projectId);
		ProjectScore score = getProjectService().getMyScore(author,projectId);
		request.setAttribute("comment", comment);
		request.setAttribute("score", score);
		request.setAttribute("projectId", new Integer(projectId));
		return mapping.findForward("success");
	}
	
	
}