package net.tiaozhanbei.service.impl;

import java.util.List;

import net.tiaozhanbei.dao.INewsDAO;
import net.tiaozhanbei.model.News;
import net.tiaozhanbei.model.User;
import net.tiaozhanbei.service.INewsService;
import net.tiaozhanbei.util.Page;
import net.tiaozhanbei.util.NewsConst;

public class NewsServiceImpl implements INewsService {
	private INewsDAO newsDAO;
	
	public void addAnounce(String content, User author) {
		News anounce= new News();
		anounce.setType(NewsConst.Type.SPECIAL);
		anounce.setTitle(content);
		anounce.setAuthor(author);
		newsDAO.save(anounce);
	}

	public List<News> getAnounce() {
		
		return newsDAO.findByType(NewsConst.Type.SPECIAL);
	}

	public News getHeadNews() {
		
		return newsDAO.getHeadNews();
	}

	public void setHeadNews(News news) {
		for (News anews : newsDAO.findByType(NewsConst.Type.HEAD)) {
			anews.setType(NewsConst.Type.NORMAL);
			newsDAO.update(anews);
		}
		news.setType(NewsConst.Type.HEAD);
		newsDAO.update(news);
		
	}

	public void addNews(News news) {
		System.out.println("NewsServiceImpl.addNews()");
		this.newsDAO.save(news);		
	}

	public void delNews(News news) {
		this.newsDAO.delete(news);
		
	}
	
	public void delNewsById(int newsId) {
		News news = this.newsDAO.findById(newsId);
		this.newsDAO.delete(news);
	}

	public INewsDAO getNewsDAO() {
		return this.newsDAO;
	}

	public List<News> getNewsList() {
		return this.newsDAO.findAll();
	}

	public void setNewsDAO(INewsDAO newsDAO) {
		this.newsDAO = newsDAO;		
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return super.toString();
	}


	public void fillPageByCatagory(Page<News> page,String catagory){
    	newsDAO.fillPage(page, 
    			"from News where catagory like '"+catagory+"%'"
    			);
    }

	public void fillPageByAll(Page<News> page) {
		newsDAO.fillPage(page);
	}
	public List<News> findByCatagory(String catagory) {
		return this.newsDAO.findByCatagory(catagory);
	}

	public List<News> findAll() {
		return this.newsDAO.findAll();
	}

	public News findNewsById(int newsid) {
		return this.newsDAO.findById(newsid);
	}

	public void delAnounce(int contentID) {
		News news = this.newsDAO.findById(contentID);
		this.newsDAO.delete(news);
	}

}
