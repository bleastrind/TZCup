package net.tiaozhanbei.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import net.tiaozhanbei.dao.*;
import net.tiaozhanbei.model.Project;
import net.tiaozhanbei.model.ProjectComment;
import net.tiaozhanbei.model.ProjectScore;
import net.tiaozhanbei.model.ProjectState;
import net.tiaozhanbei.model.User;
import net.tiaozhanbei.service.IProjectService;
import net.tiaozhanbei.util.Page;
import net.tiaozhanbei.util.ProjectCommentConst;
import net.tiaozhanbei.util.UserConst;


public class ProjectServiceImpl implements IProjectService {
	
	private static final Logger logger = Logger.getLogger(ProjectServiceImpl.class);
/*
	public void fillProjectPage(User user, int relation, Page<Project> page) {

		String whereString = "where p.owner=?";//"select count(*) "
		
		//String hql = "select p from Project as p left join p.userRelation s where p.owner=? and s.type=?";
		Object[] objects = new Object[1];
		objects[0] = user;
		//objects[1] = relation;
		//if(relation == RelationConst.Type.OWNER){
			//projectDAO.fillPage(page, hql, objects);
		projectDAO.fillPage("select count(*) from Project as p " + whereString , 
				"select p from Project as p left join p.userRelations s " + whereString + " and s.type ="+relation, 
				objects, 
				page);
		//}
		//else if(relation == RelationConst.Type.FUNS || relation == RelationConst.Type.PARTER){
			
		//}
		
	}
*/
	@Autowired
	private IProjectStateDAO stateDAO;
	
	@Autowired
	private IProjectScoreDAO scoreDAO;

	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private IFileInfoDAO fileInfoDAO;
	
	private IProjectDAO projectDAO;
	private IProjectCommentDAO projectCommentDAO;
	
	public boolean addComment( ProjectComment comment) {
		
		try{
			projectCommentDAO.save(comment);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	
		
	}

	public boolean  vote(int projectId,User user){
		
			
			Project project=projectDAO.findById(projectId);
			int votes=project.getState().getVotes()+1;//����Ŀ��Ʊ��+1
			project.getState().setVotes(votes);//
			int score=user.getScore()-UserConst.SubScores.SubScore;//��ȥ�û��ķ���
			if (score>0) {
				user.setScore(score);			
				userDAO.update(user);//������ݿ���û�����Ŀ��Ϣ			
				projectDAO.update(project);
				return true;
				
			} else {
				System.out.println("分值不足");
				return false;

			}
			
					
		
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public boolean addFocus(int projectId, User user,String type) {

		
			Project project=projectDAO.findById(projectId);
			System.out.println(user.getId());
			user = userDAO.findById(user.getId());
			if(AddFocusType_Favourate.equals(type))
				user.getFavourateProjects().add(project);
			else if (AddFocusType_InterstCompany.equals(type)) {
					user.getInterestProjects().add(project);	
			}else {
				return false;
			}
				
			userDAO.update(user);

			return true;
	}
	


	public void fillPageByNormalComment(Page<ProjectComment> page, int projectId) {
		
		 projectCommentDAO.fillPage(
				 page,
				 "from ProjectComment p where p.projectId="+projectId
				 +" and p.type="+ProjectCommentConst.Type.NORMAL
				 +" order by p.id desc");
		
		
		
	}
	public void fillPageByProfessorComments(Page<ProjectComment> page,
			int projectId) {
		
		
		projectCommentDAO.fillPage(page, "from ProjectComment where projectId="+projectId+" and type="+ProjectCommentConst.Type.PROFESSOR);

		
	}
	public Project getProject(int id) {
		return projectDAO.findById(id);
	}

	public boolean save(Project project) {
	
		projectDAO.save(project);
		return true;
	}
	public boolean updateProject(Project project){
		
	projectDAO.update(project);
	return true;
		
		
	}


	public void fillProjectPage(Order order,String catalog,Page<Project> page){
		String whereString = catalog == null ||"".equals(catalog) ? 
				""	:
				"where type like '"+catalog+"%'";
		if(order == Order.Default)
			projectDAO.fillPage(page, "from Project p "+ whereString + " order by p.id desc");
		else if(order == Order.Vote)
			projectDAO.fillPage("select count(*) from Project "+whereString,
					"select p from Project p left join p.state s"
					+whereString
					+" order by s.votes desc",
					null,
					page);
		else if (order == Order.Rank) {
			projectDAO.fillPage("select count(*) from Project "+whereString,
					"select p from Project p left join p.state s"
					+whereString
					+" order by s.rank",
					null,
					page);
		}else if(order == Order.Visit){
			projectDAO.fillPage("select count(*) from Project "+whereString,
					"select p from Project p left join p.state s"
					+whereString
					+" order by s.visit desc",
					null,
					page);
		}
	}
	
	public void searchInside(String searchtext, Page<Project> page){
		String temp, whereString = "where ";
		StringTokenizer st = new StringTokenizer(searchtext);
		if("".equals(searchtext))
			whereString += "p.name =''";
		else{
			while(st.hasMoreTokens()){
				temp = st.nextToken();
				whereString += "p.name like '%" + temp + "%' or " + "p.brief like '%" + temp + "%'";
				if(st.hasMoreTokens())
					whereString += " or ";
			}
		}
		projectDAO.fillPage(page, "from Project p "+ whereString + " order by p.id desc");
	}
	
	public java.util.List<Project> getProjects(Order order) {
		List<Project> resList=null;
		switch (order) {
		case Default:
			 resList= new ArrayList<Project>(projectDAO.findAll());
			break;

		default:
			break;
		}
		return resList;
	}

	@Transactional
	public boolean deleteComments(int commentId) {

		ProjectComment comment=projectCommentDAO.findById(commentId);
		if(comment!=null)
		{
			projectCommentDAO.delete(comment);
			return true;
		}else {
			return false;
		}
		
		
		
	}
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.service.impl.IProjectService#setProjectDAO(net.tiaozhanbei.dao.impl.ProjectDAO)
	 */
	public void setProjectDAO(IProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.service.impl.IProjectService#setProjectCommentDAO(net.tiaozhanbei.dao.impl.ProjectCommentDAO)
	 */
	public void setProjectCommentDAO(IProjectCommentDAO projectCommentDAO) {
		this.projectCommentDAO = projectCommentDAO;
	}
	
	public Project getProject(User author){
		return null;
	}


	public IUserDAO getUserDAO() {
		return userDAO;
	}


	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public void setShowFile(int projectId, int fileId) {
		projectDAO.findById(projectId).setShowFile( fileInfoDAO.findById(fileId));
		
		
	}

	public ProjectComment getMyComment(User author, int projectId) {
		return projectCommentDAO.query("from ProjectComment where author=? and projectId="+projectId, new Object[]{author});
		
	}

	public ProjectScore getMyScore(User user, int projectId) {
		Project project = projectDAO.findById(projectId);
		for(ProjectScore score : project.getState().getScores()){
			if(score.getJudger().getId() == user.getId())
				return score;
		}
		return null;
	}

	public ProjectComment getComment(int CommentId) {
	
		return 	projectCommentDAO.findById(CommentId);
	}

	public void professorJudge(ProjectScore score, ProjectComment comment){

		scoreDAO.saveOrUpdate(score);
		projectCommentDAO.saveOrUpdate(comment);

		
	}

	public void addStar(int projectId, int star) {
		Project project = projectDAO.findById(projectId);
		ProjectState state = project.getState();
		int starnum = state.getStarnum();
		int totalstar = state.getTotalStars();
		starnum++;
		totalstar+=star;
		state.setTotalStars(totalstar);
		state.setStarnum(starnum);
		stateDAO.update(state);
	}

	public Project visitProject(int id) {
		Project project = projectDAO.findById(id);
		int visit = project.getState().getVisit() + 1;
		project.getState().setVisit(visit);
		projectDAO.update(project);
		logger.info("project:"+id+" visited!");
		return project;
	}
	
	

}
