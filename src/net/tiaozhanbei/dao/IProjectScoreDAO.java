package net.tiaozhanbei.dao;

import java.util.List;

import net.tiaozhanbei.model.ProjectScore;
import net.tiaozhanbei.util.Page;

public interface IProjectScoreDAO {

	public abstract void save(ProjectScore transientInstance);

	public abstract void delete(ProjectScore persistentInstance);

	public abstract ProjectScore findById(java.lang.Integer id);

	public abstract List<ProjectScore> findByExample(ProjectScore instance);

	public abstract List<ProjectScore> findByProperty(String propertyName, Object value);

	public abstract List<ProjectScore> findByScore(Object score);

	public abstract List<ProjectScore> findByWeight(Object weight);

	public abstract List<ProjectScore> findAll();

	public abstract ProjectScore merge(ProjectScore detachedInstance);

	public abstract void attachDirty(ProjectScore instance);

	public abstract void attachClean(ProjectScore instance);
	public void fillPage(Page<ProjectScore> page,String hql,Object[] values);
	public void fillPage(Page<ProjectScore> page,String hql);
	public void fillPage(Page<ProjectScore> page);
	public void update(ProjectScore projectScore);
	public void saveOrUpdate(ProjectScore projectScore);
	
}