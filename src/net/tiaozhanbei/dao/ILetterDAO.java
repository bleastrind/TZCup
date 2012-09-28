package net.tiaozhanbei.dao;

import java.util.List;

import net.tiaozhanbei.model.Letter;
import net.tiaozhanbei.util.Page;

public interface ILetterDAO {

	public abstract void save(Letter transientInstance);

	public abstract void delete(Letter persistentInstance);

	public abstract Letter findById(java.lang.Integer id);

	public abstract List<Letter> findByExample(Letter instance);

	public abstract List<Letter> findByProperty(String propertyName, Object value);

	public abstract List<Letter> findByLetterTitle(Object letterTitle);

	public abstract List<Letter> findByLetterContent(Object letterContent);

	public abstract List<Letter> findByLetterChecked(Object letterChecked);

	public abstract List<Letter> findByLetterState(Object letterState);

	public abstract List<Letter> findAll();

	public abstract Letter merge(Letter detachedInstance);

	public abstract void attachDirty(Letter instance);

	public abstract void attachClean(Letter instance);
	public void fillPage(Page<Letter> page,String hql,Object[] values);
	public void fillPage(Page<Letter> page,String hql);
	public void fillPage(Page<Letter> page);
	public void update(Letter letter);
}