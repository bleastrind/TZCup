/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package net.tiaozhanbei.action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tiaozhanbei.model.News;
import net.tiaozhanbei.util.Page;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
public class NewsAction extends BaseAction {
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
	private static final Log log = LogFactory.getLog(NewsAction.class);
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		
		try {
				
				Page<News> newsPage = new Page<News>(request.getParameter("page"));
				String catagory = request.getParameter("catagory");
				if (catagory == null)
					getNewsService().fillPageByAll(newsPage);
				else
					getNewsService().fillPageByCatagory(newsPage,catagory);
				request.setAttribute("newsPage", newsPage);
				return mapping.findForward("listNews");
				

		} catch (Exception e) {
			log.warn(e);
			return mapping.findForward("error");
		}

	}


}