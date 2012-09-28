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
	 * ��ӹ�ע
	 */
	public  abstract boolean addFocus(int projectId,User user,String type); 

	public ProjectComment getMyComment(User author,int projectId);
	/**
	 * ������Ŀ�����ͨ����
	 * @param project
	 * @return
	 */
	public void fillPageByNormalComment(Page<ProjectComment> page,int projectId);
	
	public void fillPageByProfessorComments(Page<ProjectComment> page,int projectId);
	
	/**
	 * �����߻����Ŀ
	 * @param author
	 * @return
	 */
	public Project getProject(User author);
	/**
	 * ��id�����Ŀ
	 * @param id
	 * @return
	 */
	public Project getProject(int id);
	
	/**
	 * ������Ŀ��������visit
	 * @param id
	 * @return
	 */
	@Transactional
	public Project visitProject(int id);
	/**
	 * ��ĳ�����������Ŀ
	 * @param order
	 * @return
	 */
	public List<Project> getProjects(Order order);
	/**
	 * ����ҳ
	 * @param order
	 * @param catalog
	 * @param page
	 */

	public void fillProjectPage(Order order,String catalog,Page<Project> page);
	
	/**
	 * վ������
	 * @param searchtext
	 * @param page
	 */

	public void searchInside(String searchtext, Page<Project> page);

	/**
	 * �趨չʾ�ļ�
	 * @param projectId
	 * @param fileId
	 */
	@Transactional
	public void setShowFile(int projectId,int fileId);
	
	/**
	 * ������Ŀ
	 * @param project
	 */
	@Transactional
	public boolean save(Project project);
	
	@Transactional
	public boolean updateProject(Project project);
	/**
	 * ��������
	 */
	@Transactional
	public boolean addComment(ProjectComment comment);
	@Transactional
	/**
	 * Ϊ��ĿͶƱ
	 */
	public boolean vote(int projectId,User user);
	
	
	/**
	 * �Ǽ�ͶƱ
	 * @param projectId
	 * @param star
	 */
	@Transactional
	public void addStar(int projectId,int star);
	
	
	public boolean deleteComments(int commentId);

	
	/**
	 * ���ר�Ҷ���Ŀ������
	 * @param user
	 * @param projectId
	 * @return
	 */
	public ProjectScore getMyScore(User user,int projectId);
	
	public ProjectComment getComment(int CommentId);
	
	@Transactional
	public void professorJudge(ProjectScore score, ProjectComment comment);
	
}