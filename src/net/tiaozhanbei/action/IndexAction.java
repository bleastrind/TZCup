/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package net.tiaozhanbei.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tiaozhanbei.event.AutoLoginEvent;
import net.tiaozhanbei.model.FileInfo;
import net.tiaozhanbei.model.News;
import net.tiaozhanbei.model.Project;
import net.tiaozhanbei.model.Vote;
import net.tiaozhanbei.service.IProjectService.Order;
import net.tiaozhanbei.util.Page;
import net.tiaozhanbei.util.ProjectConst;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



/** 
 * MyEclipse Struts
 * Creation date: 03-02-2009
 * 
 * XDoclet definition:
 * @struts.action
 * @struts.action-forward name="success" path="/Web/Index/index.jsp"
 */
public class IndexAction extends BaseAction {
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
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		if(request.getParameter("ajax")==null)
			return mapping.findForward("success");
		else 
			return super.execute(mapping, form, request, response);
		
	}
	

	
	public ActionForward science(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		Page<Project> science = new Page<Project>(1);
		science.setPageSize(4);
		
		getProjectService().fillProjectPage(Order.Default, ProjectConst.Type.SCIENCE, science);
		
		request.setAttribute("science", science);
		
		Page<Project> society = new Page<Project>(1);
		society.setPageSize(4);
		getProjectService().fillProjectPage(Order.Default, ProjectConst.Type.SOCIETY, society);
		request.setAttribute("society", society);
		
		Page<Project> natrual = new Page<Project>(1);
		natrual.setPageSize(4);
		
		getProjectService().fillProjectPage(Order.Default, ProjectConst.Type.NATURAL, natrual);
		
		request.setAttribute("natrual", natrual);
		return mapping.findForward("science");
	}
	
	
	public ActionForward news(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		Page<News> news = new Page<News>(1);
		news.setPageSize(10);
		
		getNewsService().fillPageByAll(news);
	
		request.setAttribute("news", news);
		return mapping.findForward("news");
	}
	
	public ActionForward votes(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List<Vote> votes = getVoteService().getEnableVotes();
		request.setAttribute("votes", votes);
		return mapping.findForward("votes");
	}
	public ActionForward files(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		Page<FileInfo> page = new Page<FileInfo>("1");
		page.setPageSize(5);
		getFileInfoService().fillCommonFilePage(page);
		request.setAttribute("page", page);
		return mapping.findForward("files");
	}
	public  ActionForward loginbox(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
		//�Զ���¼
		publishEvent(new AutoLoginEvent(this,request));
		
		return mapping.findForward("login");
	}
	
	public ActionForward anounce(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {


			List<News> newsList;
			newsList = getNewsService().getAnounce();
			request.setAttribute("anounce",newsList);
			return mapping.findForward("listAnounce");
	}
}