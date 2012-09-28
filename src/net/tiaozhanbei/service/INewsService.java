package net.tiaozhanbei.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import net.tiaozhanbei.dao.INewsDAO;
import net.tiaozhanbei.model.News;
import net.tiaozhanbei.model.User;
import net.tiaozhanbei.util.Page;

public interface INewsService {

	public abstract INewsDAO getNewsDAO();
	
	public abstract void setNewsDAO(INewsDAO newsDAO);
	
	@Transactional
	public void addNews(News news);
	
	@Transactional
	public void delNews(News news);
	
	@Transactional
	public void delNewsById(int newsid);
	
	@Transactional
	public void fillPageByCatagory(Page<News> page,String catagory);
	
	@Transactional
	public void fillPageByAll(Page<News> page);
	
	public List<News> findByCatagory(String catagory);
	
	public List<News> findAll();
	
	public News findNewsById(int newsid);

	/**
	 * 获得通告，通告所有内容存在title中，url为#
	 * @return
	 */
	public List<News> getAnounce();
	
	public News getHeadNews();
	
	/**
	 * 设置头条，头条仅有一个
	 * @param news 已经存在的新闻
	 */
	@Transactional
	public void setHeadNews(News news);

	@Transactional
	public void addAnounce(String content, User author);
	
	@Transactional
	public void delAnounce(int contentID);
	
}