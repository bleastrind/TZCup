package net.tiaozhanbei.dao.impl;

import java.util.List;

import net.tiaozhanbei.dao.GenericHibernateDAOCrud;
import net.tiaozhanbei.dao.IProjectStateDAO;
import net.tiaozhanbei.model.ProjectState;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
/**
 	* A data access object (DAO) providing persistence and search support for ProjectState entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see net.tiaozhanbei.model.ProjectState
  * @author MyEclipse Persistence Tools 
 */
@SuppressWarnings("unchecked")
public class ProjectStateDAO extends GenericHibernateDAOCrud<ProjectState> implements IProjectStateDAO  {
    public ProjectStateDAO() {
		super(ProjectState.class);
	}

	private static final Log log = LogFactory.getLog(ProjectStateDAO.class);
	//property constants
	public static final String PROCESS = "process";
	public static final String VOTES = "votes";
	public static final String RANK = "rank";



	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectStateDAO#save(net.tiaozhanbei.model.ProjectState)
	 */
    public void save(ProjectState transientInstance) {
        log.debug("saving ProjectState instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectStateDAO#delete(net.tiaozhanbei.model.ProjectState)
	 */
	public void delete(ProjectState persistentInstance) {
        log.debug("deleting ProjectState instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectStateDAO#findById(java.lang.Integer)
	 */
    public ProjectState findById( java.lang.Integer id) {
        log.debug("getting ProjectState instance with id: " + id);
        try {
            ProjectState instance = (ProjectState) getHibernateTemplate()
                    .get("net.tiaozhanbei.model.ProjectState", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectStateDAO#findByExample(net.tiaozhanbei.model.ProjectState)
	 */
    public List findByExample(ProjectState instance) {
        log.debug("finding ProjectState instance by example");
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
	 * @see net.tiaozhanbei.dao.impl.IProjectStateDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding ProjectState instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ProjectState as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectStateDAO#findByProcess(java.lang.Object)
	 */
	public List findByProcess(Object process
	) {
		return findByProperty(PROCESS, process
		);
	}
	
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectStateDAO#findByVotes(java.lang.Object)
	 */
	public List findByVotes(Object votes
	) {
		return findByProperty(VOTES, votes
		);
	}
	
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectStateDAO#findByRank(java.lang.Object)
	 */
	public List findByRank(Object rank
	) {
		return findByProperty(RANK, rank
		);
	}
	

	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectStateDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all ProjectState instances");
		try {
			String queryString = "from ProjectState";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectStateDAO#merge(net.tiaozhanbei.model.ProjectState)
	 */
    public ProjectState merge(ProjectState detachedInstance) {
        log.debug("merging ProjectState instance");
        try {
            ProjectState result = (ProjectState) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectStateDAO#attachDirty(net.tiaozhanbei.model.ProjectState)
	 */
    public void attachDirty(ProjectState instance) {
        log.debug("attaching dirty ProjectState instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectStateDAO#attachClean(net.tiaozhanbei.model.ProjectState)
	 */
    public void attachClean(ProjectState instance) {
        log.debug("attaching clean ProjectState instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IProjectStateDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IProjectStateDAO) ctx.getBean("ProjectStateDAO");
	}
}