package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.tiaozhanbei.model.*;
import net.tiaozhanbei.util.Page;
import net.tiaozhanbei.util.UserConst;
import org.apache.commons.validator.*;
@SuppressWarnings("unused")
public class jspServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8966535210301978381L;

	/**
	 * Constructor of the object.
	 */
	public jspServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	/*	HttpSession session=request.getSession();
		ArrayList<User> userlist=(ArrayList<User>)session.getAttribute("userlist");
		Iterator it = userlist.iterator();
		User user=new User();
		while(it.hasNext()){
			user=(User)it.next();
		int userId=user.getId();
		String name=user.getName();
		int type=user.getType();
		String regDate=user.getRegisterTime().toString();
		boolean verify=user.isVerify();
		
		if (type==UserConst.Type.AUTHOR) {
			
		} else if(type==UserConst.Type.COMMONUSER){

		}
		else if (type==UserConst.Type.COMPANY) {
			
		}else if(type==UserConst.Type.JUDGER){
			
		}
		
	}*/
		User user=(User)request.getAttribute("noVerifyUser");
		String name=user.getName();
		int type=user.getType();
		int userId=user.getId();
		String deparment=user.getDepartment();
		String realname=user.getRealName();
		String email=user.getEmail();
		int sex=user.getSex();
		String  phone=user.getPhone();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String  time=format.format(user.getRegisterTime());
		String userType;
		//User user=new User();
		if (type==UserConst.Type.AUTHOR) {
			userType=new String("参赛作者");
			
		} else if (type==UserConst.Type.COMMONUSER) {
			userType=new String("普通用户");
			
		}else if (type==UserConst.Type.COMPANY) {
			userType=new String("企业用户");
			
		}else if (type==UserConst.Type.JUDGER) {
			userType=new String("评委用户");
			
		}
		

}
	


	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		Page<ProjectComment> page=(Page<ProjectComment>)request.getAttribute("defaultPage");
		Iterator<ProjectComment> iterator=page.getDataList().iterator();
		ProjectComment comment;
		String title;
		User author;
		String content;
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String regDate;
		while (iterator.hasNext()) {
			comment=iterator.next();
			title=comment.getTitle();
			content=comment.getContent();
			regDate=format.format(comment.getTime());
			author=comment.getAuthor();
			String authorname=author.getName();
			int id=author.getId();			
			
		}
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user!=null){//如果访问主页时可以找到用户名，就自动登录
			String name=user.getName();			
			
		}
		else {
			
		}
		String oldurl=(String)request.getAttribute("oldurl");
		response.sendRedirect(oldurl);
	
		
		
		
		
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
