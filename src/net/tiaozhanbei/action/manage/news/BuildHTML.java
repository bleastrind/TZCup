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
 * @file_name �ļ������ļ�֮��Ĳ���.���Ϊa.jsf?fileId=aaaa 
 * @path �ļ����ڵ�·��.����ڸ�Ŀ¼���Ե�. 
 * @realName�ļ�Ҫ��������� 
 * @realPath�ļ�Ҫ�������ʵ·����Ĭ�����ļ����ڵ�Ŀ¼��ͬ�� 
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
			FileInputStream fileinputstream = new FileInputStream(fileSouce);//��ȡģ���ļ�
			
			byte bytes[] = new byte[fileinputstream.available()];
			
			
			fileinputstream.read(bytes);
			fileinputstream.close();
			templateContent=new String(bytes);
			templateContent = templateContent.replaceAll("###title###", title);
			templateContent = templateContent.replaceAll("###time###", time);
			templateContent = templateContent.replaceAll("###catagory###", catagory);
			templateContent=templateContent.replaceAll("###author###", author);
			templateContent=templateContent.replaceAll("###content###", content);//�滻��ģ������Ӧ�ĵط�
			templateContent=templateContent.replaceAll("###webpath###", request.getContextPath());
			
			
			//����ʱ����ļ���
			String fileName = CommonResources.getEnvironmentBundle().getString("newspath") + dateFormat2.format(date) + ".html";//���ɵ�html�ļ�����·��
			
			FileOutputStream fileoutputstream=new FileOutputStream(fileName);//�����ļ������
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