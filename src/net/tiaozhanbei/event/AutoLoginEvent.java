package net.tiaozhanbei.event;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationEvent;

/**
 * 该事件发生后
 * 如Session中有User，什么也不改变
 * 如Cookies中有记录，Session中将有User存在
 * 否则，Session中user仍为null;
 * @author Administrator
 *
 */
public class AutoLoginEvent extends ApplicationEvent{

	private HttpServletRequest request;
	
	public AutoLoginEvent(Object source) {
		super(source);
	}

	public AutoLoginEvent(Object source,HttpServletRequest request){
		super(source);
		this.request = request;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -7593129976900684834L;

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


}
