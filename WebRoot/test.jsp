<%@ page language="java" import="java.util.*, java.io.*" pageEncoding="ISO-8859-1"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="net.tiaozhanbei.dao.*"%>
<%@page import="net.tiaozhanbei.model.*"%>
<%@page import="test.databasetest.*"%>
<%@page import="org.springframework.orm.hibernate3.HibernateTemplate"%>
<%@page import="org.apache.velocity.runtime.directive.Foreach"%>
<%@page import="javax.management.Query"%> 
<%ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());

		IUserDAO userDAO = (IUserDAO)ac.getBean("UserDAO");
		
		IProjectCommentDAO projectCommentDAO = (IProjectCommentDAO)ac.getBean("ProjectCommentDAO");
		IProjectDAO projectDAO = (IProjectDAO)ac.getBean("ProjectDAO");
		IProjectScoreDAO projectScoreDAO = (IProjectScoreDAO)ac.getBean("ProjectScoreDAO");
		IProjectStateDAO projectStateDAO = (IProjectStateDAO)ac.getBean("ProjectStateDAO");
		IFileInfoDAO fileInfoDAO = (IFileInfoDAO)ac.getBean("FileInfoDAO");
		INewsDAO newsDAO = (INewsDAO)ac.getBean("NewsDAO");
		ILetterDAO letterDAO = (ILetterDAO)ac.getBean("LetterDAO");
		testDAO testdao = (testDAO)ac.getBean("testDAO");
		%>
		<%User user = new User();
		user.setId(2);
		user.setName("hsadgfsdf");
		user.setPassword("sadhfsa");
		Object d = testdao.test(("select count(*) from Project as p where p.owner =?"), user);
		//testdao.test("select count(*) from Project p left join p.state s group by s.rank order by s.rank")
			System.out.println(d);
		//}
		%>
		
		
		<span class="each">
		<a href="project?page=0">0</a></span>
		<span class="this">
		<a href="project?page=1">1</a></span>
		<span class="each">
		<a href="project?page=2">2</a></span>
		<span class="next">
		<a href="project?page=2">></a></span>
		<span class="last">
		<a href="project?page=2">>></a></span>
		