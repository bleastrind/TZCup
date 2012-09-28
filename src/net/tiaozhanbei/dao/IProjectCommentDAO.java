package net.tiaozhanbei.dao;

import java.util.List;

import net.tiaozhanbei.model.ProjectComment;
import net.tiaozhanbei.util.Page;

public interface IProjectCommentDAO {

	public abstract void save(ProjectComment transientInstance);

	public abstract void delete(ProjectComment persistentInstance);

	public abstract ProjectComment findById(java.lang.Integer id);

	public List<ProjectComment> findByProject(int projectId,int type);
	
	public abstract List<ProjectComment> findByExample(ProjectComment instance);

	public abstract List<ProjectComment> findByProperty(String propertyName, Object value);

	public abstract List<ProjectComment> findByCommentContent(Object commentContent);

	public abstract List<ProjectComment> findByCommentTime(Object commentTime);

	public abstract List<ProjectComment> findAll();

	public abstract ProjectComment merge(ProjectComment detachedInstance);

	public abstract void attachDirty(ProjectComment instance);

	public abstract void attachClean(ProjectComment instance);
	public void fillPage(Page<ProjectComment> page,String hql,Object[] values);
	public void fillPage(Page<ProjectComment> page,String hql);
	public void fillPage(Page<ProjectComment> page);
	public void update(ProjectComment projectComment);
	public void saveOrUpdate(ProjectComment comment);
	public ProjectComment query(String hql,Object[] values);
}