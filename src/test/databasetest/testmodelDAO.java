package test.databasetest;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for testmodel entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see test.databasetest.testmodel
  * @author MyEclipse Persistence Tools 
 */
@SuppressWarnings("unchecked")
public class testmodelDAO extends HibernateDaoSupport implements ItestmodelDAO  {
    private static final Log log = LogFactory.getLog(testmodelDAO.class);
	//property constants



	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see test.databasetest.ItestmodelDAO#save(test.databasetest.testmodel)
	 */
    public void save(testmodel transientInstance) {
        log.debug("saving testmodel instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see test.databasetest.ItestmodelDAO#delete(test.databasetest.testmodel)
	 */
	public void delete(testmodel persistentInstance) {
        log.debug("deleting testmodel instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    
    
    /* (non-Javadoc)
	 * @see test.databasetest.ItestmodelDAO#findByExample(test.databasetest.testmodel)
	 */
    
	public List findByExample(testmodel instance) {
        log.debug("finding testmodel instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    /* (non-Javadoc)
	 * @see test.databasetest.ItestmodelDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding testmodel instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from testmodel as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see test.databasetest.ItestmodelDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all testmodel instances");
		try {
			String queryString = "from testmodel";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see test.databasetest.ItestmodelDAO#merge(test.databasetest.testmodel)
	 */
    public testmodel merge(testmodel detachedInstance) {
        log.debug("merging testmodel instance");
        try {
            testmodel result = (testmodel) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see test.databasetest.ItestmodelDAO#attachDirty(test.databasetest.testmodel)
	 */
    public void attachDirty(testmodel instance) {
        log.debug("attaching dirty testmodel instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see test.databasetest.ItestmodelDAO#attachClean(test.databasetest.testmodel)
	 */
    public void attachClean(testmodel instance) {
        log.debug("attaching clean testmodel instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static ItestmodelDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (ItestmodelDAO) ctx.getBean("testmodelDAO");
	}
}