package net.tiaozhanbei.event;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import net.tiaozhanbei.model.User;
import net.tiaozhanbei.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import common.Logger;

/**
 * 处理自动登录事件的监听器
 * @author Administrator
 *
 */
@Component
public class AutoLoginEventListener implements ApplicationListener{

	private static final Logger logger = Logger.getLogger(AutoLoginEventListener.class);
	
	@Autowired
	private IUserService userService;
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof AutoLoginEvent) {
			AutoLoginEvent autoLoginEvent = (AutoLoginEvent) event;
			HttpServletRequest request = autoLoginEvent.getRequest();
			if(request.getAttribute("user") == null)
				readCookies(request);
		}
		
	}
	
	
	private void readCookies(HttpServletRequest request){
		
		Cookie cookies[]=request.getCookies();
		String username=null;
		String password=null;
		Cookie cookie;
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
		logger.info("cookie查询完毕："+username+password);
		
		if (username!=null&&password!=null) {//如果成功查找到用户的信息，则自动登录
			
			
			User user=new User();
			user.setName(username);
			user.setPassword(password);
			user=userService.login(user);
			if(user!=null)//如果自动登陆成功
			{
				request.getSession().setAttribute("user", user);
				
			}
		}
	}

}
