package net.tiaozhanbei.dao;

import java.util.Date;
import java.util.List;

import net.tiaozhanbei.model.News;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for News entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see net.tiaozhanbei.model.News
  * @author MyEclipse Persistence Tools 
 */

public class NewsDAO extends HibernateDaoSupport  {
    private static final Log log = LogFactory.getLog(NewsDAO.class);
	//property constants
	public static final String NEWS_TITLE = "newsTitle";
	public static final String NEWS_AUTHOR = "newsAuthor";
	public static final String NEWS_CONTENT = "newsContent";
	public static final String NEWS_CLASSES = "newsClasses";
	public static final String NEWS_TYPE = "newsType";
	public static final String NEWS_PIC_PATH = "newsPicPath";



	protected void initDao() {
		//do nothing
	}
    
    public void save(News transientInstance) {
        log.debug("saving News instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
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
    
    public News findById( java.lang.Integer id) {
        log.debug("getting News instance with id: " + id);
        try {
            News instance = (News) getHibernateTemplate()
                    .get("net.tiaozhanbei.News", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(News instance) {
        log.debug("finding News instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding News instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from News as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByNewsTitle(Object newsTitle
	) {
		return findByProperty(NEWS_TITLE, newsTitle
		);
	}
	
	public List findByNewsAuthor(Object newsAuthor
	) {
		return findByProperty(NEWS_AUTHOR, newsAuthor
		);
	}
	
	public List findByNewsContent(Object newsContent
	) {
		return findByProperty(NEWS_CONTENT, newsContent
		);
	}
	
	public List findByNewsClasses(Object newsClasses
	) {
		return findByProperty(NEWS_CLASSES, newsClasses
		);
	}
	
	public List findByNewsType(Object newsType
	) {
		return findByProperty(NEWS_TYPE, newsType
		);
	}
	
	public List findByNewsPicPath(Object newsPicPath
	) {
		return findByProperty(NEWS_PIC_PATH, newsPicPath
		);
	}
	

	public List findAll() {
		log.debug("finding all News instances");
		try {
			String queryString = "from News";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public News merge(News detachedInstance) {
        log.debug("merging News instance");
        try {
            News result = (News) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(News instance) {
        log.debug("attaching dirty News instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(News instance) {
        log.debug("attaching clean News instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static NewsDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (NewsDAO) ctx.getBean("NewsDAO");
	}
}