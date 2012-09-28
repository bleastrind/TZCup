package test.databasetest;

import java.util.Iterator;
import java.util.Random;


import net.tiaozhanbei.dao.*;

import net.tiaozhanbei.model.*;
import net.tiaozhanbei.util.ProjectConst;

import org.springframework.beans.BeansException;
import org.springframework.context.*;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ResourceLoader;

@SuppressWarnings("unused")
public class test{
	public static void main(String[] args) {
		//直接获取Spring上下文

		
		ApplicationContext ac=new FileSystemXmlApplicationContext("WebRoot/WEB-INF/config/applicationContext.xml");
		
		Random rnd=new Random();		
		IUserDAO userDAO = (IUserDAO)ac.getBean("UserDAO");
		
		
		IProjectCommentDAO projectCommentDAO = (IProjectCommentDAO)ac.getBean("ProjectCommentDAO");
		IProjectDAO projectDAO = (IProjectDAO)ac.getBean("ProjectDAO");
		IProjectScoreDAO projectScoreDAO = (IProjectScoreDAO)ac.getBean("ProjectScoreDAO");
		IProjectStateDAO projectStateDAO = (IProjectStateDAO)ac.getBean("ProjectStateDAO");
		IFileInfoDAO fileInfoDAO = (IFileInfoDAO)ac.getBean("FileInfoDAO");
		INewsDAO newsDAO = (INewsDAO)ac.getBean("NewsDAO");
		ILetterDAO letterDAO = (ILetterDAO)ac.getBean("LetterDAO");
		testDAO testdao = (testDAO)ac.getBean("testDAO");

			
		
	}
}
		/*
		
		User user2 = new User();
		user2.setUserAuthority(1);
		user2.setUserName("cyq1");
		user2.setUserPasswd("0451124");
		user2.setUserId(1);
		//userDAO.save(user2);
		
		IProjectDAO projectDAO = (IProjectDAO)ac.getBean("ProjectDAO");
=======
		user.setName("test"+rnd.nextInt());
>>>>>>> 1.3
		user.setPassword("0451124");
		Project project = new Project();
		project.setName("tzcup2");
		project.setType(1);
		project.setOwner(user);
		
		UserProjectRelation relation = new UserProjectRelation();
		relation.setUser(user);
		user.getProjectRelations().add(relation);
		project.getUserRelation().add(relation);
		userDAO.save(user);
<<<<<<< test.java
		projectDAO.save(project);
/*
=======

>>>>>>> 1.2
>>>>>>> 1.3
		Project project = new Project();
		user = userDAO.findByUserName(nameString);
		News news =new News();
		news.setTitle("tti");
		news.setUrl(" ");
		news.setAuthor(user);
		newsDAO.save(news);
		System.out.println("finished");
	*/	
	


class beanwithspring implements ApplicationContextAware{
	@SuppressWarnings("unused")
	private ResourceLoader loader;
	public void setResourceLoader(ResourceLoader arg0) {

		
	}
	private ApplicationContext context;
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		// TODO Auto-generated method stub
	}
	public Object getBeanFromSpring(String beanname){
		return context.getBean(beanname);
	}

}


