package net.tiaozhanbei.dao.impl;


import java.util.List;
import net.tiaozhanbei.dao.GenericHibernateDAOCrud;
import net.tiaozhanbei.dao.INewsDAO;
import net.tiaozhanbei.model.News;
import net.tiaozhanbei.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
/**
 	* A data access object (DAO) providing persistence and search support for News entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see net.tiaozhanbei.model.News
  * @author Eclipse Persistence Tools 
 */
@SuppressWarnings("unchecked")
public class NewsDAO extends GenericHibernateDAOCrud<News> implements INewsDAO  {
    public NewsDAO() {
		super(News.class);

	}

	private static final Log log = LogFactory.getLog(NewsDAO.class);
	//property constants
	public static final String NEWS_TITLE = "newsTitle";
	public static final String NEWS_URL = "newsUrl";
	public static final String NEWS_TYPE = "newsType";
	public static final String NEWS_CATAGORY = "newsCatagory";



	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.INewsDAO#save(net.tiaozhanbei.model.News)
	 */
    public void save(News transientInstance) {
        log.debug("saving News instance");
        
        System.out.println(transientInstance.getCatagory());
        System.out.println(transientInstance.getId());
        System.out.println(transientInstance.getTitle());
        
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.INewsDAO#delete(net.tiaozhanbei.model.News)
	 */
	public void delete(News persistentInstance) {
        log.debug("deleting News instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.INewsDAO#findById(java.lang.Integer)
	 */
    
	public static INewsDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (INewsDAO) ctx.getBean("NewsDAO");
	}

	public List<News> findAll() {
		log.debug("finding all news instances");
		try {
			String queryString = "from News";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List<News> findByCatagory(String catagory) {
		log.debug("finding all news instances");
		try {
			String queryString = "from News where catagory =" + catagory;
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public News findById(int id) {
		log.debug("find News by newsId");
		try {
			
			return super.query(id);
		} catch (RuntimeException re) {
			log.error("find news by id failed", re);
			throw re;
		}
	}

	public List<News> findByType(int type) {
		return queryForLists("from News where type=?", new Object[]{type});
	}

	public News getHeadNews(){
		return (News)super.queryForObject("from News where type=?", new Object[]{NewsConst.Type.HEAD});
	}
}