package net.tiaozhanbei.filter;


import java.io.IOException; 
import java.io.InputStream;


	import javax.servlet.Filter; 
	import javax.servlet.FilterChain; 
	import javax.servlet.FilterConfig; 
	import javax.servlet.ServletException; 
	import javax.servlet.ServletRequest; 
	import javax.servlet.ServletResponse; 
	import javax.servlet.http.HttpServletRequest; 
	import javax.servlet.http.HttpServletResponse; 

import org.apache.log4j.Logger;


import net.tiaozhanbei.exception.LogicException;
import net.tiaozhanbei.service.IUserService;
import net.tiaozhanbei.util.SafeProperties;
import net.tiaozhanbei.util.UrlAccessJudger;
/**
 * 此过滤器应截获所有调用，验证权限问题
 * @author Administrator
 *
 */
	public class VerifyFilter  implements Filter {

		private Logger logger = Logger.getLogger(VerifyFilter.class);

	private IUserService userService;
	public void destroy() {

	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
	FilterChain filterChain) throws IOException, ServletException {


	HttpServletRequest request = (HttpServletRequest)servletRequest; 

	HttpServletResponse response = (HttpServletResponse)servletResponse;

	
	
	
	
	//关键判断
	if (!pass(request)) {
				
		
		response.sendRedirect(request.getContextPath() + "/loginpage.do?oldurl="+request.getRequestURI()+"?"+request.getQueryString()); 
		return;
	}
	
	filterChain.doFilter(request, response); 


	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}
	
	/**
	 * 验证是否具备权限
	 * @param request
	 * @return
	 */
	private boolean pass(HttpServletRequest request){
		String urlString=request.getRequestURI();
		UrlAccessJudger judger=null;
		try {
			judger = UrlAccessJudger.getInstance();
		} catch (LogicException e) {
			try{
				InputStream inputStream = getClass().getResourceAsStream("/URLAuthority.properties");
				SafeProperties safeProperties = new SafeProperties();
				safeProperties.load(inputStream);
				UrlAccessJudger.setBundle(safeProperties);
				inputStream.close();
				judger = UrlAccessJudger.getInstance();
			}catch (Exception ex) {
				logger.error(ex);
			}
		}
		return judger.accessable(urlString, request);
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}


}
