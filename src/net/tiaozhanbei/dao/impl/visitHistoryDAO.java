package net.tiaozhanbei.dao.impl;
//已添加update方法
import java.util.List;

import net.tiaozhanbei.dao.GenericHibernateDAOCrud;
import net.tiaozhanbei.dao.IvisitHistoryDAO;
import net.tiaozhanbei.model.visitHistory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
/**
 	* A data access object (DAO) providing persistence and search support for visitHistory entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see net.tiaozhanbei.model.visitHistory
  * @author MyEclipse Persistence Tools 
 */

public class visitHistoryDAO extends GenericHibernateDAOCrud<visitHistory> implements IvisitHistoryDAO {
    public visitHistoryDAO() {
		super(visitHistory.class);
	}

	private static final Log log = LogFactory.getLog(visitHistoryDAO.class);
	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.IvisiHistoryDAO#save(net.tiaozhanbei.model.visitHistory)
	 */
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#save(net.tiaozhanbei.model.visitHistory)
	 */
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#save(net.tiaozhanbei.model.visitHistory)
	 */
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
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.IvisiHistoryDAO#update(net.tiaozhanbei.model.visitHistory)
	 */
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#update(net.tiaozhanbei.model.visitHistory)
	 */
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#update(net.tiaozhanbei.model.visitHistory)
	 */
    public void update(visitHistory persistentInstance){
    	log.debug("update visitHistory instance");
    	try{
    		getHibernateTemplate().update(persistentInstance);
    	}catch (RuntimeException re) {
			log.error("update failed",re);
		}
    }
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.IvisiHistoryDAO#delete(net.tiaozhanbei.model.visitHistory)
	 */
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#delete(net.tiaozhanbei.model.visitHistory)
	 */
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#delete(net.tiaozhanbei.model.visitHistory)
	 */
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
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.IvisiHistoryDAO#findById(java.util.Date)
	 */
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#findById(java.util.Date)
	 */
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#findById(java.util.Date)
	 */
    public visitHistory findById( java.util.Date id) {
        log.debug("getting visitHistory instance with id: " + id);
        try {
            visitHistory instance = (visitHistory) getHibernateTemplate()
                    .get("net.tiaozhanbei.model.visitHistory", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.IvisiHistoryDAO#findByExample(net.tiaozhanbei.model.visitHistory)
	 */
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#findByExample(net.tiaozhanbei.model.visitHistory)
	 */
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#findByExample(net.tiaozhanbei.model.visitHistory)
	 */
    @SuppressWarnings("unchecked")
	public List<visitHistory> findByExample(visitHistory instance) {
        log.debug("finding visitHistory instance by example");
        try {
            List<visitHistory> results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.IvisiHistoryDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @SuppressWarnings("unchecked")
	public List<visitHistory> findByProperty(String propertyName, Object value) {
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

	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.IvisiHistoryDAO#findByActivenum(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#findByActivenum(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#findByActivenum(java.lang.Object)
	 */
	public List<visitHistory> findByActivenum(Object activenum
	) {
		return findByProperty(ACTIVENUM, activenum
		);
	}
	
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.IvisiHistoryDAO#findByTotalnum(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#findByTotalnum(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#findByTotalnum(java.lang.Object)
	 */
	public List<visitHistory> findByTotalnum(Object totalnum
	) {
		return findByProperty(TOTALNUM, totalnum
		);
	}
	

	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.IvisiHistoryDAO#findAll()
	 */
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#findAll()
	 */
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#findAll()
	 */
	@SuppressWarnings("unchecked")
	public List<visitHistory> findAll() {
		log.debug("finding all visitHistory instances");
		try {
			String queryString = "from visitHistory";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.IvisiHistoryDAO#merge(net.tiaozhanbei.model.visitHistory)
	 */
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#merge(net.tiaozhanbei.model.visitHistory)
	 */
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#merge(net.tiaozhanbei.model.visitHistory)
	 */
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

    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.IvisiHistoryDAO#attachDirty(net.tiaozhanbei.model.visitHistory)
	 */
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#attachDirty(net.tiaozhanbei.model.visitHistory)
	 */
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#attachDirty(net.tiaozhanbei.model.visitHistory)
	 */
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
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.IvisiHistoryDAO#attachClean(net.tiaozhanbei.model.visitHistory)
	 */
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#attachClean(net.tiaozhanbei.model.visitHistory)
	 */
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#attachClean(net.tiaozhanbei.model.visitHistory)
	 */
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

	public static IvisitHistoryDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IvisitHistoryDAO) ctx.getBean("visitHistoryDAO");
	}
}