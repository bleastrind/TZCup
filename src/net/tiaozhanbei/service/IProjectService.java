package net.tiaozhanbei.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;



import net.tiaozhanbei.dao.IProjectCommentDAO;
import net.tiaozhanbei.dao.IProjectDAO;
import net.tiaozhanbei.model.Project;
import net.tiaozhanbei.model.ProjectComment;
import net.tiaozhanbei.model.ProjectScore;
import net.tiaozhanbei.model.User;
import net.tiaozhanbei.util.Page;
public interface IProjectService {

	public enum Order{
		Default,
		Rank,
		Vote,
		Visit,
	}
	public enum Type{
		Owner,
		Favor
	}
	
	public String AddFocusType_InterstCompany = "interest";
	public String AddFocusType_Favourate = "favourate";
	
	public abstract void setProjectDAO(IProjectDAO projectDAO);

	public abstract void setProjectCommentDAO(
			IProjectCommentDAO projectCommentDAO);
	
	@Transactional
	/**
	 * 添加关注
	 */
	public  abstract boolean addFocus(int projectId,User user,String type); 

	public ProjectComment getMyComment(User author,int projectId);
	/**
	 * 根据项目获得普通评论
	 * @param project
	 * @return
	 */
	public void fillPageByNormalComment(Page<ProjectComment> page,int projectId);
	
	public void fillPageByProfessorComments(Page<ProjectComment> page,int projectId);
	
	/**
	 * 按作者获得项目
	 * @param author
	 * @return
	 */
	public Project getProject(User author);
	/**
	 * 按id获得项目
	 * @param id
	 * @return
	 */
	public Project getProject(int id);
	
	/**
	 * 访问项目、会增加visit
	 * @param id
	 * @return
	 */
	@Transactional
	public Project visitProject(int id);
	/**
	 * 按某种排名获得项目
	 * @param order
	 * @return
	 */
	public List<Project> getProjects(Order order);
	/**
	 * 填充分页
	 * @param order
	 * @param catalog
	 * @param page
	 */

	public void fillProjectPage(Order order,String catalog,Page<Project> page);
	
	/**
	 * 站内搜索
	 * @param searchtext
	 * @param page
	 */

	public void searchInside(String searchtext, Page<Project> page);

	/**
	 * 设定展示文件
	 * @param projectId
	 * @param fileId
	 */
	@Transactional
	public void setShowFile(int projectId,int fileId);
	
	/**
	 * 更新项目
	 * @param project
	 */
	@Transactional
	public boolean save(Project project);
	
	@Transactional
	public boolean updateProject(Project project);
	/**
	 * 增加评论
	 */
	@Transactional
	public boolean addComment(ProjectComment comment);
	@Transactional
	/**
	 * 为项目投票
	 */
	public boolean vote(int projectId,User user);
	
	
	/**
	 * 星级投票
	 * @param projectId
	 * @param star
	 */
	@Transactional
	public void addStar(int projectId,int star);
	
	
	public boolean deleteComments(int commentId);

	
	/**
	 * 获得专家对项目的评分
	 * @param user
	 * @param projectId
	 * @return
	 */
	public ProjectScore getMyScore(User user,int projectId);
	
	public ProjectComment getComment(int CommentId);
	
	@Transactional
	public void professorJudge(ProjectScore score, ProjectComment comment);
	
}