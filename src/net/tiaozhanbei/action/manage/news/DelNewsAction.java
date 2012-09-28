/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package net.tiaozhanbei.action.manage.news;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tiaozhanbei.action.BaseAction;
import net.tiaozhanbei.model.News;
import net.tiaozhanbei.util.CommonResources;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
public class DelNewsAction extends BaseAction {
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
	private static final Log log = LogFactory.getLog(AddNewsAction.class);
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		try {
			int newsid  = Integer.parseInt(request.getParameter("newsid"));
			System.out.println("newsID:" + newsid);
			News news = getNewsService().findNewsById(newsid);
			System.out.println(news.getUrl());
			try {
				getNewsService().delNews(news);
			} catch (Exception e) {
				log.error("del news from databse failed");
				request.setAttribute("message", "fail");
			}


			String filepath=CommonResources.getEnvironmentBundle().getString("newspath");
			String url = news.getUrl();
			String fileName = url.substring(url.length()-19,url.length());
			System.out.println(filepath + fileName);

			try {
				 File file = new File(fileName);    
				 file.delete();
			} catch (Exception e) {
				log.error("del news failed!");
				e.printStackTrace();
			}
			request.setAttribute("message", "success");
		} catch (Exception e) {
			log.error("right check failed!!!");
			request.setAttribute("message", "fail");
		}

		return mapping.findForward("ajaxSuccessOrFailure");
	}
}