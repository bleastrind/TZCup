package net.tiaozhanbei.dao;

import java.util.List;

import net.tiaozhanbei.model.Project;
import net.tiaozhanbei.util.Page;

public interface IProjectDAO {

	public abstract void save(Project transientInstance);

	public abstract void delete(Project persistentInstance);

	public abstract Project findById(java.lang.Integer id);
	
	public void fillPage(final String selectCount, final String select, final Object[] values, final Page<Project> page);
	public void fillPage(Page<Project> page,String hql,Object[] values);
	public void fillPage(Page<Project> page,String hql);
	public void fillPage(Page<Project> page);
	
	public abstract List<Project> findByExample(Project instance);

	public abstract List<Project> findByProperty(String propertyName, Object value);

	public abstract List<Project> findByProjectName(Object projectName);

	public abstract List<Project> findByProjectType(Object projectType);

	public abstract List<Project> findByProjectBrief(Object projectBrief);

	public abstract List<Project> findByProjectDetal(Object projectDetal);

	public abstract List<Project> findByProjectPicpath(Object projectPicpath);

	public abstract List<Project> findByScore(Object score);

	public abstract List<Project> findAll();


	public abstract Project merge(Project detachedInstance);

	public abstract void attachDirty(Project instance);

	public abstract void attachClean(Project instance);
	public void update(Project project);

}