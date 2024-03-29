/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package net.tiaozhanbei.action.manage.letter;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tiaozhanbei.action.BaseAction;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.Logger;

import net.tiaozhanbei.model.Letter;
import net.tiaozhanbei.model.User;

/**
 * MyEclipse Struts Creation date: 03-21-2009
 * 
 * XDoclet definition:
 * 
 * @struts.action validate="true"
 */
public class ListLetterAction extends BaseAction {
	/*
	 * Generated Methods
	 */

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	Logger logger=Logger.getLogger(getClass());
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		/*
		 * �ڼ�ҳ:num 
		 * �鿴��:userId 
		 * �鿴��������ռ��䣺action=send,receive
		 */
		String action =(String) request.getAttribute("action");
		logger.debug("listLetter:"+action);
		if (action.equals("listSend")) {
			
			User user=(User)request.getSession().getAttribute("user");
			List<Letter> list = getLetterService().send(
					user.getId(),
					/*Integer.parseInt(request.getParameter("num"))*/1);
			System.out.println("sendlist_size:"+list.size());
			request.setAttribute("list", list);
			return mapping.findForward("list");
		}
		if (action.equals("listReceive")) {
			
			User user=(User)request.getSession().getAttribute("user");
			List<Letter> list = getLetterService().receive(
					user.getId(),
					/*Integer.parseInt(request.getParameter("num"))*/1);
			
			request.setAttribute("list", list);
			return mapping.findForward("list");
		}
		if (action.equals("listNew")) {
			
			User user=(User)request.getSession().getAttribute("user");
			List<Letter> list = getLetterService().receiveNew(
					user.getId(),
					/*Integer.parseInt(request.getParameter("num"))*/1);
			
			request.setAttribute("list", list);
			return mapping.findForward("list");
		}
		return mapping.findForward("error");
	}
}