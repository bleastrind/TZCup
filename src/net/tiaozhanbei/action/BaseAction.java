package net.tiaozhanbei.action;

import org.springframework.context.ApplicationEvent;
import org.springframework.web.struts.DispatchActionSupport;

import common.Logger;

import net.tiaozhanbei.service.ILetterService;
import net.tiaozhanbei.service.INewsService;
import net.tiaozhanbei.service.IUserService;
import net.tiaozhanbei.service.IProjectService;
import net.tiaozhanbei.service.IFileInfoService;
import net.tiaozhanbei.service.IVoteService;

public class BaseAction extends DispatchActionSupport{

	protected static Logger log = Logger.getLogger(BaseAction.class); 
	
	
	/**
	 * 发布事件到Spring容器中
	 * @param event
	 */
	protected void publishEvent(ApplicationEvent event){
		getWebApplicationContext().publishEvent(event);
	}
	
	protected Object getBean(String name)
	{
		
		return getWebApplicationContext().getBean(name);
	}
	
	protected ILetterService getLetterService(){
		return (ILetterService)getBean("letterService");
	}
	protected IUserService getUserService()
	{
		return (IUserService)getBean("userService");

	}
	protected IProjectService getProjectService() {
		return (IProjectService)getBean("projectService");
	}
	
	protected INewsService getNewsService() {
		return (INewsService)getBean("newsService");
	}
    protected IFileInfoService getFileInfoService() {
		return (IFileInfoService)getBean("fileinfoService");
	}
    
    protected IVoteService getVoteService(){
    	return (IVoteService)getBean("voteService");
    }

}
