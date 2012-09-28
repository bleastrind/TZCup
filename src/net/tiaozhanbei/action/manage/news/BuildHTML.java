package net.tiaozhanbei.action.manage.news;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.tiaozhanbei.model.User;
import net.tiaozhanbei.util.CommonResources;

/** 
 * @file_name 文件名及文件之后的参数.最好为a.jsf?fileId=aaaa 
 * @path 文件所在的路径.相对于根目录而言的. 
 * @realName文件要保存的名字 
 * @realPath文件要保存的真实路径。默认与文件所在的目录相同。 
 */
public class BuildHTML extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7599912701141244146L;
	private static final Log log = LogFactory.getLog(BuildHTML.class);
	
	public String generateNews(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = (Date)request.getSession().getAttribute("time");
		try {
			String title = request.getParameter("title");
			String time = dateFormat.format(date);
			String catagory = request.getParameter("catagory");
			String author = ((User)request.getSession().getAttribute("user")).getName();
			String content = request.getParameter("content");
			
			String fileSouce = CommonResources.getEnvironmentBundle().getString("newspath") + "news.jsp";
			String templateContent =new String();
			FileInputStream fileinputstream = new FileInputStream(fileSouce);//读取模块文件
			
			byte bytes[] = new byte[fileinputstream.available()];
			
			
			fileinputstream.read(bytes);
			fileinputstream.close();
			templateContent=new String(bytes);
			templateContent = templateContent.replaceAll("###title###", title);
			templateContent = templateContent.replaceAll("###time###", time);
			templateContent = templateContent.replaceAll("###catagory###", catagory);
			templateContent=templateContent.replaceAll("###author###", author);
			templateContent=templateContent.replaceAll("###content###", content);//替换掉模块中相应的地方
			templateContent=templateContent.replaceAll("###webpath###", request.getContextPath());
			
			
			//根据时间得文件名
			String fileName = CommonResources.getEnvironmentBundle().getString("newspath") + dateFormat2.format(date) + ".html";//生成的html文件保存路径
			
			FileOutputStream fileoutputstream=new FileOutputStream(fileName);//建立文件输出流
			byte tag_bytes[]=templateContent.getBytes();
			fileoutputstream.write(tag_bytes);
			fileoutputstream.close();
			return request.getContextPath() + "/News/" + dateFormat2.format(date) + ".html";
		} catch(Exception e){
			log.error("generate html file error");
			return null;
		}

	}
		
}