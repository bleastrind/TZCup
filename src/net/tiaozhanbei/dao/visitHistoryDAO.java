package net.tiaozhanbei.dao;

import java.util.List;

import net.tiaozhanbei.model.visitHistory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for visitHistory entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see net.tiaozhanbei.model.visitHistory
  * @author MyEclipse Persistence Tools 
 */

public class visitHistoryDAO extends HibernateDaoSupport  {
    private static final Log log = LogFactory.getLog(visitHistoryDAO.class);
	//property constants
	public static final String ACTIVENUM = "activenum";
	public static final String TOTALNUM = "totalnum";



	protected void initDao() {
		//do nothing
	}
    
    public void save(visitHistory transientInstance) {
        log.debug("saving visitHistory instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(visitHistory persistentInstance) {
        log.debug("deleting visitHistory instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public visitHistory findById( java.util.Date id) {
        log.debug("getting visitHistory instance with id: " + id);
        try {
            visitHistory instance = (visitHistory) getHibernateTemplate()
                    .get("net.tiaozhanbei.visitHistory", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(visitHistory instance) {
        log.debug("finding visitHistory instance by example");
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
      log.debug("finding visitHistory instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from visitHistory as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByActivenum(Object activenum
	) {
		return findByProperty(ACTIVENUM, activenum
		);
	}
	
	public List findByTotalnum(Object totalnum
	) {
		return findByProperty(TOTALNUM, totalnum
		);
	}
	

	public List findAll() {
		log.debug("finding all visitHistory instances");
		try {
			String queryString = "from visitHistory";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public visitHistory merge(visitHistory detachedInstance) {
        log.debug("merging visitHistory instance");
        try {
            visitHistory result = (visitHistory) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(visitHistory instance) {
        log.debug("attaching dirty visitHistory instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(visitHistory instance) {
        log.debug("attaching clean visitHistory instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static visitHistoryDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (visitHistoryDAO) ctx.getBean("visitHistoryDAO");
	}
}