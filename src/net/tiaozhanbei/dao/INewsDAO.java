package net.tiaozhanbei.dao;

import java.util.List;

import net.tiaozhanbei.model.News;
import net.tiaozhanbei.util.Page;

public interface INewsDAO {

	public abstract void save(News transientInstance);

	public abstract void delete(News persistentInstance);
	
	public void fillPage(Page<News> page,String hql,Object[] values);
	
	public void fillPage(Page<News> page,String hql);
	
	public void fillPage(Page<News> page);
	
	public List<News> findByCatagory(String catagory);
	
	public List<News> findAll();
	
	public News findById(int id);
	
	public List<News> findByType(int type);
	public News getHeadNews();
	public void update(News news);
}