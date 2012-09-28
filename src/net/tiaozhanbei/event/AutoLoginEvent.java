package net.tiaozhanbei.event;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationEvent;

/**
 * ���¼�������
 * ��Session����User��ʲôҲ���ı�
 * ��Cookies���м�¼��Session�н���User����
 * ����Session��user��Ϊnull;
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
