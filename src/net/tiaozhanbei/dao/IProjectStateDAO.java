package net.tiaozhanbei.dao;

import java.util.List;

import net.tiaozhanbei.model.ProjectState;
import net.tiaozhanbei.util.Page;

public interface IProjectStateDAO {

	public abstract void save(ProjectState transientInstance);

	public abstract void delete(ProjectState persistentInstance);

	public abstract ProjectState findById(java.lang.Integer id);

	public abstract List<ProjectState> findByExample(ProjectState instance);

	public abstract List<ProjectState> findByProperty(String propertyName, Object value);

	public abstract List<ProjectState> findByProcess(Object process);

	public abstract List<ProjectState> findByVotes(Object votes);

	public abstract List<ProjectState> findByRank(Object rank);

	public abstract List<ProjectState> findAll();

	public abstract ProjectState merge(ProjectState detachedInstance);

	public abstract void attachDirty(ProjectState instance);

	public abstract void attachClean(ProjectState instance);
	public void fillPage(Page<ProjectState> page,String hql,Object[] values);
	public void fillPage(Page<ProjectState> page,String hql);
	public void fillPage(Page<ProjectState> page);
	public void update(ProjectState projectState);
}